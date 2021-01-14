package lee.java.exam09;
import java.io.Serializable;

public class MyMember implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String pwd;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
