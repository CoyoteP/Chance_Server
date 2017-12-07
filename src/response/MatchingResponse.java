package response;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import bean.User;
import dto.UserDto;
import net.arnx.jsonic.JSON;

@Path("/matching")
public class MatchingResponse {

	@GET
	@Path("/easy")
	@Produces({"application/json"})
	public Response Matching(){
		UserDto uDto = new UserDto();
		ArrayList<User> users = new ArrayList<User>();
		users = uDto.UserSearch();

		// JSONICでJSON文字列にエンコードする。
		String json = JSON.encode(users);


		return Response.ok()
				.entity(json)
				.build();

	}

}
