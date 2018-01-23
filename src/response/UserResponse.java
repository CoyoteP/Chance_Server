package response;

import javax.persistence.NoResultException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import dto.UserDto;
import net.arnx.jsonic.JSON;

@Path("/user")
public class UserResponse {

	@GET
	@Path("/create")
	@Produces({"application/json"})
	public Response create(@QueryParam("id") int id){
		UserDto uDto = new UserDto();
		String test = uDto.Create();
		// JSONICでJSON文字列にエンコードする。
		String json = JSON.encode(test);
		return Response.ok()
				.entity(json)
				.build();
	}
	@GET
	@Path("/login")
	@Produces({"application/json"})
	public Response Login(@QueryParam("id") int id){
		try {
			UserDto uDto = new UserDto();
			String test = uDto.Create();
			String json = JSON.encode(test);
			return Response.ok()
					.entity(json)
					.build();  // JSONが返る(ステータスコード：200)
		} catch (NoResultException e) {
			throw new WebApplicationException(404);    // 404が返る
		}
	}
	@GET
	@Path("/test")
	@Produces({"application/json"})
	public String Test(@QueryParam("id") int id){
		return "123";
	}

}

