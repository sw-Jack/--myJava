class MyClass {
	private String name;
	private int age;
	// ������ 4��
	/////////////////////////////////////
	public MyClass() {
		name = "����";
	}
	public MyClass(String n) {
		name = n;
	}
	public MyClass(int a, String n) {
		age = a;
		name = n;
	}
	public MyClass(String n, int a) {
		age = a;
		name = n;
	}
	/////////////////////////////////////
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}
public class MyClassEx {
	public static void main(String[] args) {
		MyClass mc1 = new MyClass();
		MyClass mc2 = new MyClass("�����");
		MyClass mc3 = new MyClass(25, "������");
		MyClass mc4 = new MyClass("�߰���", 45);

		System.out.println(mc1.getName() + ", " + mc1.getAge());
		System.out.println(mc2.getName() + ", " + mc2.getAge());
		System.out.println(mc3.getName() + ", " + mc3.getAge());
		System.out.println(mc4.getName() + ", " + mc4.getAge());
	}
}