// 예외 처리 실습
// 예외 처리 구문의 실행 순서
public class ExceptionEx3 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
        try {
			System.out.println(3);
			// ArithmeticException 부분 : 0으로 나눔
			System.out.println(0/0); // 예외 발생 -> 예외를 처리할 catch로 넘어감
			System.out.println(4); // 이전 부분 예외 발생으로 해당 줄 실행 X
		} catch(ArithmeticException ae) {
			System.out.println(5);
		}
		System.out.println(6);
	}
}
        