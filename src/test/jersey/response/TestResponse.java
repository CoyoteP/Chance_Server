package test.jersey.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestResponse {

    private int id;
    private String name;

    /**
     * デフォルトコンストラクタ（JSONエンコードに必須）
     */
    public TestResponse(){
    }

    /**
     * データ初期化用コンストラクタ
     * @param id
     * @param name
     */
    public TestResponse(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}