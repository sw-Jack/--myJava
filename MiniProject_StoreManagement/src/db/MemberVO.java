package db;

public class MemberVO {
	// ���
	private String name;
	private String id;
	private String pw;
	private String phoneNum;
	private String storeCode;
	public String getName() {
		return name;
	}
	
	// ������
	public MemberVO() {}
	
	// �޼���
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}