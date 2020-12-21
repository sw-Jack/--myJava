public class OperEx8 {
	public static void main(String[] args) {
		int i = 10;
		int j = 0;
		// 컴파일은 되지만 Runtime 에러 발생!
		// Runtime Error는 실행상 오류
		// 그 중에서 연산 오류 : 0으로 나누면 오류
		System.out.println("i / j = " + (i/j)); 
	}
}
