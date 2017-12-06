package dto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.User;
public class UserDto extends Dto{
	private final String USER_SEARCH = "SELECT * from sample.test ORDER BY RAND() LIMIT 5;";
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
