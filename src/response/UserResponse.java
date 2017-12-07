package response;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/user")
public class UserResponse {

    @GET
    @Path("/create")
    @Produces({"application/json"})
    public String create(@QueryParam("id") int id){
    	
		return null;
    	
    }
    @GET
    @Path("/test")
    @Produces({"application/json"})
    public String Test(@QueryParam("id") int id){
    	return "123";
    }

}

