package response;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import bean.TestUser;
import net.arnx.jsonic.JSON;

@Path("/api")
public class TestJerseyResource {

    // テストデータ
    private static Set<TestUser> set;

    static{
        // とりあえずテストデータ（ほんとはこんなことやってはダメ）
        set = new HashSet<TestUser>();
        set.add(new TestUser("1", "一郎"));
        set.add(new TestUser("2", "次郎"));
        set.add(new TestUser("3", "三郎"));
        set.add(new TestUser("4", "四郎"));
    }

    @GET
    @Path("/test")
    @Produces({"application/json"})
    public Response TestResource(@QueryParam("id") String id){

        TestUser res = null;

        // idが一致するデータを返す.
        for( TestUser tmp : set ){
            if(id.equals(tmp.getUserid())){
                res = tmp;
            }
        }

        // 一致無しの場合は空データを返す
        if( res == null ){
            res = new TestUser("", "");
        }

        // JSONICでJSON文字列にエンコードする。
        String json = JSON.encode(res);


        return Response.ok()
                .entity(json)
                .build();
    }

}