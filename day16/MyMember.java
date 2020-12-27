 public class MyMember {
	 // 생성자
	 private String name;	// 이름
	 private int age;		// 나이
	 private String phone;	// 전화번호
	 private String addr;	// 주소

	 // 생성자
	 public MyMember() {}	// default 생성자
	 public MyMember(String name, int age, String phone, String addr) {
		 this.name = name;
		 this.age = age;
		 this.phone = phone;
		 this.addr = addr;
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

	 public String getAddr() {
		 return addr;
	 }
	 public void setAddr(String addr) {
		 this.addr = addr;
	 }

	 // 모든 회원정보 출력 메서드
	 public void printAll() {
		 System.out.println("이    름 : " + this.name);
		 System.out.println("나    이 : " + this.age);
		 System.out.println("전화번호 : " + this.phone);
		 System.out.println("주    소 : " + this.addr + "\n");
	 }

 }