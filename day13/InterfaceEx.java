interface InterEx {
	// 인터페이스는 상수와 추상 메서드로만 구성됨
	// 상수
	static final int A = 100; 
	//  추상 메서드
	abstract int getA(); // abstract 예약어는 생략 가능
}
public class InterfaceEx implements InterEx {
	public int getA() {
		return A;
	}
	public static void main(String[] args) {
		InterfaceEx if1 = new InterfaceEx();
		System.out.println("getA() : " + if1.getA());
	}
}