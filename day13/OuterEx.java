// static inner 클래스 예제
public class OuterEx {
	// inner 클래스들은 Outer 클래스 이름에 $를 붙인 형태의 class파일로 저장됨.
	public static class InnerEx { 
		static int x = 10;
		public static void main(String[] args) {
			OuterEx.InnerEx inner = new OuterEx.InnerEx();
			System.out.println("inner.x : " + inner.x);
			System.out.println("inner.x : " + OuterEx.InnerEx.x);
		}
	}
}
// 실행하려면 "java OuterEx$InnerEx"