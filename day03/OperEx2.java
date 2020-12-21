//import java.lang.*; 생략 : JVM이 알아서 해주기 때문에
public class OperEx2 {
	public static void main(String[] args) {
		short a, b;
		a = 10;
		b = 10;
		// 자바에서 정수(byte, short, int, char) 간의 사칙 연산의 결과는 반드시
		// 정수(int)가 나온다. 따라서 short c = a + b; 라고 하면 Error!
		short c = (short)(a + b); 
		System.out.println("c의 값 : " + c);
	}
}
