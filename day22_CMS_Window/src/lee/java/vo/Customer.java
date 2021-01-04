package lee.java.vo;

public class Customer {
	// ���
	private String name;
	private String idNum;
	private String phone;
	private Boolean sex;
	private String hobby;
	
	// ������
	public Customer(String name, String idNum, String phone, Boolean sex, String hobby) {
		super();
		this.name = name;
		this.idNum = idNum;
		this.phone = phone;
		this.sex = sex;
		this.hobby = hobby;
	}
	
	// �޼���
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	
	public boolean isSex() {
		return sex;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	// toString() : �ش� Ŭ������ ��ǥ�ϴ� ���ڿ� ��ȯ
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(" ");
		sb.append(name);
		sb.append("(");
		sb.append(isSex() ? "����" : "����");
		sb.append(")");
		return super.toString();
	}
}
