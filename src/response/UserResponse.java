package response;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import bean.TestResponse;
import bean.User;
import dto.UserDto;
import net.arnx.jsonic.JSON;

@Path("/user")
public class UserResponse {
	private static Set<TestResponse> set;

    static{
        // とりあえずテストデータ（ほんとはこんなことやってはダメ）
        set = new HashSet<TestResponse>();
        set.add(new TestResponse(1, "一郎"));
        set.add(new TestResponse(2, "次郎"));
        set.add(new TestResponse(3, "三郎"));
        set.add(new TestResponse(4, "四郎"));
    }
    @GET
    @Path("/join")
    @Produces({"application/json"})
    public Response TestResource(){

        TestResponse res = null;
        UserDto uDto = new UserDto();
        ArrayList<User> users = new ArrayList();
        users = uDto.UserSearch();

        // JSONICでJSON文字列にエンコードする。
        String json = JSON.encode(users);


        return Response.ok()
                .entity(json)
                .build();
    }
    @GET
    @Path("/test")
    @Produces({"application/json"})
    public String Test(@QueryParam("id") int id){
    	return "123";
    }

}

