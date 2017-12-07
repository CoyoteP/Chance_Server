package dto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.User;
public class MatchingDto extends Dto{
	private final String USER_SEARCH = "SELECT id\r\n" +
			"FROM sample.tags\r\n" +
			"WHERE tag IN (\r\n" +
			"  SELECT tag\r\n" +
			"  FROM sample.tags\r\n" +
			"  where id = '2'\r\n" +
			")\r\n" +
			"AND id != '2'\r\n" +
			"GROUP BY id\r\n" +
			"ORDER BY RAND() LIMIT 3;";
	private ResultSet rset;
	public ArrayList<User> UserSearch(){
		ArrayList<User> users = new ArrayList<User>();
		try(PreparedStatement ps = connection.prepareStatement(USER_SEARCH)) {
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
}
