// 예외 전가 : throws
public class ExceptionEx7 {
	private static void test() throws Exception {	// 예외 전가
		System.out.println(6/0); // 예외 발생
	}
	 
	public static void main(String[] args) {
		try {
			test(); // try ~ catch 문으로 예외 처리해야함
		} catch(Exception e) {
			System.out.println("예외 발생");
		}
	}
}
