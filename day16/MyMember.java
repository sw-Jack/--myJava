 public class MyMember {
	 // ������
	 private String name;	// �̸�
	 private int age;		// ����
	 private String phone;	// ��ȭ��ȣ
	 private String addr;	// �ּ�

	 // ������
	 public MyMember() {}	// default ������
	 public MyMember(String name, int age, String phone, String addr) {
		 this.name = name;
		 this.age = age;
		 this.phone = phone;
		 this.addr = addr;
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

	 public String getAddr() {
		 return addr;
	 }
	 public void setAddr(String addr) {
		 this.addr = addr;
	 }

	 // ��� ȸ������ ��� �޼���
	 public void printAll() {
		 System.out.println("��    �� : " + this.name);
		 System.out.println("��    �� : " + this.age);
		 System.out.println("��ȭ��ȣ : " + this.phone);
		 System.out.println("��    �� : " + this.addr + "\n");
	 }

 }