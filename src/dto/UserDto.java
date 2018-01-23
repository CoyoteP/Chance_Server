package dto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.User;
public class UserDto extends Dto{
	private PreparedStatement ps ;
	private final String USERS_SEARCH = "SELECT id\r\n" +
			"FROM sample.tags\r\n" +
			"WHERE tag IN (\r\n" +
			"  SELECT tag\r\n" +
			"  FROM sample.tags\r\n" +
			"  where id = '2'\r\n" +
			")\r\n" +
			"AND id != '2'\r\n" +
			"GROUP BY id\r\n" +
			"ORDER BY RAND() LIMIT 3;";
	private final String CREATE_ID = "INSERT INTO sample.id VALUES(LPAD(@id := @id + 1,12,'0'));";
	private final String GET_ID = "SELECT id FROM sqmple.id ORDER BY RAND() LIMIT 1;";
	private final String CREATE_USER = "INSERT INTO sample.user VALUES(?)";
	private final String DELETE_ID = "DELETE FROM sample.id WHERE id = ?";
	private final String USER_SEARCH = "SELECT COUNT(*) FROM sample.test WHERE id = ?";
	private ResultSet rset;
	public ArrayList<User> UserSearch(){
		ArrayList<User> users = new ArrayList<User>();
		try(PreparedStatement ps = connection.prepareStatement(USERS_SEARCH)) {
			rset = ps.executeQuery();
			User user;
			while ( rset.next() ) {
				user = new User();
				user.setId(rset.getString(1));
				users.add(user);
			}
			rset.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	public String Create() {
		String id = "";
		try {
			ps = connection.prepareStatement(GET_ID);
			rset = ps.executeQuery();
			 id = rset.getString("id");
			ps = connection.prepareStatement(CREATE_USER);
			ps.setString(1,id );
			ps.executeUpdate();
			ps = connection.prepareStatement(DELETE_ID);
			ps.setString(1, id);
			ps.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		try(PreparedStatement ps = connection.prepareStatement(DELETE_ID)) {
			ps.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	public boolean Login(String id) {
		boolean boo = false;
		try(PreparedStatement ps = connection.prepareStatement(USER_SEARCH)) {
			rset = ps.executeQuery();
			if(rset.next()) {
				boo =  true;
			}else
				boo =  false;

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return boo;
	}
}
