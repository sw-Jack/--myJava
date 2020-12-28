package kg.lee.vo;

// �� ���� ���α׷� - ArrayList Ȱ�� 
// VO
public class Customer {
	// ���
	private String name;
	private int age;
	private String phone;
	private String address;
	
	// ������
	public Customer() {}
	public Customer(String name, int age, String phone, String address) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}
	
	// �޼��� 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
/*
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("- ��      �� : ");
		sb.append(name);
		sb.append("\n");
		sb.append("- ��      �� : ");
		sb.append(age);
		sb.append("\n");
		sb.append("- ��ȭ��ȣ : ");
		sb.append(phone);
		sb.append("\n");
		sb.append("- ��      �� : ");
		sb.append(address);
		sb.append("\n");
		return sb.toString();
	}
*/

	// ��� ������ ��� �޼���
	 public void printAll() {
		 System.out.println("- ��      �� : " + this.name);
		 System.out.println("- ��      �� : " + this.age);
		 System.out.println("- ��ȭ��ȣ : " + this.phone);
		 System.out.println("- ��      �� : " + this.address + "\n");
	 }
	 
}
