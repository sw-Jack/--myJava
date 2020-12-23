public class NewAccount extends Account {
	// 멤버 
	private String pass;
	// 생성자
	public NewAccount() { }
	public NewAccount(String name, String pass) {
		super(name);
		this.pass = pass;
	}
	// 메소드
	public boolean passCheck(String pass) {
		if(pass.equals(this.pass)) {
			return true;

		} else {
			return false;
		}
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPass() {
		return pass;
	}
}