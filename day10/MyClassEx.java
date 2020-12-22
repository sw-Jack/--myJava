class MyClass {
	private String name;
	private int age;
	// 생성자 4개
	/////////////////////////////////////
	public MyClass() {
		name = "무명";
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
		MyClass mc2 = new MyClass("손흥민");
		MyClass mc3 = new MyClass(25, "오구리");
		MyClass mc4 = new MyClass("야고보", 45);

		System.out.println(mc1.getName() + ", " + mc1.getAge());
		System.out.println(mc2.getName() + ", " + mc2.getAge());
		System.out.println(mc3.getName() + ", " + mc3.getAge());
		System.out.println(mc4.getName() + ", " + mc4.getAge());
	}
}