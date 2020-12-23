// member inner 클래스 예제
public class MemberInner {
	int a = 10;
	private int b = 100;
	static int c = 200;
	
	// 여기서의 이너 클래스 -> 위의 멤버 변수들과 동등한 위치에 존재하기 때문에
	// 접근제한자 / 지정자에 관계없이 변수 참조 가능
	class Inner { // 이너 클래스 정의
		public void printData() {
			System.out.println("int a : " + a);
			System.out.println("private int b : " + b); // *****
			System.out.println("static int c : " + c); // *****
		}
	}

	public static void main(String[] args) {
		// MemberInner outer = new MemberInner();
		// MemberInner.Inner inner = outer.new Inner();
		MemberInner.Inner inner = new MemberInner().new Inner();
		inner.printData();
	}
}
