package response;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import bean.TestResponse;
import net.arnx.jsonic.JSON;

@Path("/member")
public class MemberResponse {
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
        for( TestResponse tmp : set ){

                res = tmp;
        }

        // 一致無しの場合は空データを返す
        if( res == null ){
            res = new TestResponse(0, "");
        }

        // JSONICでJSON文字列にエンコードする。
        String json = JSON.encode(res);


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

