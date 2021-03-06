abstract class AbsEx1 {
	int a = 100; // 변수
	final String str = "abstract test"; // 상수
	public String getStr() { // 일반 메서드
		return str;
	}

	// 추상 메서드는 몸체(body)가 없다.
	abstract public int getA();4
}
abstract class AbsEx2 extends AbsEx1 {
	public int getA() { // 부모 클래스(AbsEx1)의 추상 메서드 재정의
		return a;
	}
	// 추상 메서드
	abstract public String getStr(); 
}
public class AbsEx extends AbsEx2 {
	public String getStr() { // AbsEx2의 추상 메서드 재정의
		return str; // str은 AbsEx1의 멤버
	}

	// main 메서드
	public static void main(String[] args) {
		AbsEx abs = new AbsEx();
		
		System.out.println("abs.getA() : " + abs.getA());
		System.out.println("abs.getStr() : " + abs.getStr());
	}
}
