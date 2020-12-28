package kg.lee.vo;

// 고객 관리 프로그램 - ArrayList 활용 
// VO
public class Customer {
	// 멤버
	private String name;
	private int age;
	private String phone;
	private String address;
	
	// 생성자
	public Customer() {}
	public Customer(String name, int age, String phone, String address) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}
	
	// 메서드 
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
		StringBuffer sb = new StringBuffer("- 이      름 : ");
		sb.append(name);
		sb.append("\n");
		sb.append("- 나      이 : ");
		sb.append(age);
		sb.append("\n");
		sb.append("- 전화번호 : ");
		sb.append(phone);
		sb.append("\n");
		sb.append("- 주      소 : ");
		sb.append(address);
		sb.append("\n");
		return sb.toString();
	}
*/

	// 모든 고객정보 출력 메서드
	 public void printAll() {
		 System.out.println("- 이      름 : " + this.name);
		 System.out.println("- 나      이 : " + this.age);
		 System.out.println("- 전화번호 : " + this.phone);
		 System.out.println("- 주      소 : " + this.address + "\n");
	 }
	 
}
