public class NewAccount extends Account {
	// ��� 
	private String pass;
	// ������
	public NewAccount() { }
	public NewAccount(String name, String pass) {
		super(name);
		this.pass = pass;
	}
	// �޼ҵ�
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