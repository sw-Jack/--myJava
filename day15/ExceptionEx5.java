// 예외 처리 실습
// 예외 처리 순서 : 다중 catch문
public class ExceptionEx5 { 
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);

		try {
			System.out.println(3);
			// ArithmeticException 발생 
			System.out.println(0/0);
			System.out.println(4); // 실행 X
		} catch(ArithmeticException ae) {	// 하위 클래스
			if(ae instanceof ArithmeticException) 
				System.out.println("true");
			System.out.println("ArithmeticException");
		} catch(Exception e) {				// 상위 클래스
			System.out.println("Exception");
		}
		System.out.println(6);
	}
}
// catch 구문은 예외 하위 클래스가 위에 오고 상위 클래스일수록 아래에 와야 한다. (다형성)