// static inner 클래스 예제
public class StaticInner {
	// 멤버 변수
	int a = 10;
	private int b = 100;
	static int c = 200;

	// static inner 클래스
	static class Inner {
		// 어쩔 수 없이 이너 클래스를 static으로 선언해야 하는 경우가 있다.
		// 이는 이너 클래스의 멤버들 중 static 멤버가 하나라도 존재할 때의 경우가 해당된다.
		static int d = 1000; // static 변수
		public void printData() {
			System.out.println("static int c : " + c);
			System.out.println("static int d : " + d);
			// System.out.println("int a : " + a); // Error
			// System.out.println("private int b : " + b); // Error
		}
	}

	// main 메서드
	public static void main(String[] args) {
		// 또 다른 독립된 객체에서 static inner 클래스 생성
		StaticInner.Inner inner = new StaticInner.Inner();
		inner.printData();
	}
}
