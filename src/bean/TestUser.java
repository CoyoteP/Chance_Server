package bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestUser {

	private String userid;
    private String username;
	public TestUser(String string, String string2) {
		this.userid = string;
		this.username = string2;
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}


}
