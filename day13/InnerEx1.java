// member inner 클래스 예제
class OuterEx {
	public class InnerEx {
		int x = 5;
	}
}
public class InnerEx1 {
	public static void main(String[] args) {
		// 외부 클래스 먼저 생성하고,
		OuterEx outer = new OuterEx();
		// 외부를 통해서 내부 클래스를 생성한다.
		OuterEx.InnerEx inner = outer.new InnerEx();
		System.out.println("inner.x : " + inner.x);
	}
}