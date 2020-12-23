interface Inter1 {
	public int getA(); // 추상 메서드
}
interface Inter2 {
	public int getA(); // 추상 메서드
}
interface Inter3 extends Inter1, Inter2 { // *** 다중 상속 : 인터페이스는 다중 상속을 위함
	public int getData(); // 추상 메서드
}

public class InterEx2 implements Inter3 {
	int a = 100;
	public int getA() {
		return a;
	}
	public int getData() {
		return (a+10);
	}
	public static void main(String[] args) {
		InterEx2 it = new InterEx2();

		Inter1 it1 = it; // Inter1 it1 = new InterEx2(); // 부모 = new 자식
		Inter2 it2 = it; // Inter2 it2 = new InterEx2();
		Inter3 it3 = it; // Inter3 it3 = new InterEx2();

		System.out.println(it1.getA());
		System.out.println(it2.getA());
		System.out.println(it3.getData());
	}
}
