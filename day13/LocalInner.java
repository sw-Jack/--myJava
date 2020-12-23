// local inner 클래스 예제
public class LocalInner {
	// 멤버 변수
	int a = 100; 
	// 메서드
	public void innerTest(int k) {
		int b = 200; // 지역변수
		final int c = k; // 상수
		
		// 로컬 이너 클래스 (일반 메서드 내)
		class Inner {
			// Local Inner 클래스는 외부 클래스의 멤버 변수와 
			// 상수들만의 접근이 가능하다.
			public void getData() {
				System.out.println("int a : " + a); // 외부 클래스의 멤버 변수 사용 가능
				System.out.println("int b : " + b); // 신버전에 의해 지역변수도 사용 가능해짐
				System.out.println("final int c : " + c); // 상수 사용 가능
				
			}
		}
		
		Inner i = new Inner(); // 메서드 내에서 Local Inner 클래스 생성
		i.getData(); // 생성된 reference를 통해 메서드 호출
	}

	// main 메서드
	public static void main(String[] args) {
		LocalInner outer = new LocalInner();
		outer.innerTest(1000);
	}
}