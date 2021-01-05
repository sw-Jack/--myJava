package lee.java.exam05;
import java.io.Serializable;

// 직렬화 예제 : 객체(Data 클래스) 직렬화
public class Data implements Serializable {
	private int no;
	private String name;
	private String mail;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
}
