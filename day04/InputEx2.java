import java.io.*;

public class InputEx2 {
	public static void main(String[] args) throws IOException {
		int num1;
		int num2;

		// 엔터 아스키 : \r \n => carriage return
		System.out.print("숫자 1 = ");
		num1 = System.in.read() - 48; // 0 \r \n
		//System.in.read(); System.in.read(); // 엔터값을 처리
		System.out.print("숫자 2 = ");
		num2 = System.in.read() - '0'; // 5 \r \n
		// System.out.println(num1 + " , " + num2);
		System.out.println("숫자 " + (num1 > num2 ? num1 : num2) + "가 더 크네요");
	}
}
