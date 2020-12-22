public class StaticExam {
	// 멤버 필드
	private int x;
	private static int y;
	static { // static 초기화 구문
		y = 5;
}
	// 생성자
	public StaticExam() {
		x = 10;
	}
	// 메서드
	public int getX() {	// getter 와 같은 멤버 메서드만이 예외적으로 static에 관계없이 사용 가능
		return x;
	}
	public static int getY() { // getter 와 같은 멤버 메서드만이 예외적으로 static에 관계없이 사용 가능
		return y;
	}

	public static void main(String[] args) {
		// System.out.println("x : " + x);	// Error!
		System.out.println("y : " + getY());

		StaticExam se = new StaticExam();
		System.out.println("x : " + se.getX());
		System.out.println("y : " + y);
		

	}
}