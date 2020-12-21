import java.io.*;

public class InputEx1 {
	public static void main(String[] args) throws IOException {
		System.out.print("문자 입력 : ");
		// read(), read(byte[]), read(byte[], start, length)
		int i = System.in.read(); // System.in.read(); 은 아스키코드 출력, 따라서 System.in.read() - '0' 이나 System.in.read() - 48 : 숫자 하나 or 문자 하나 입력
		System.out.println("ASCII Value : " + i);
	}
}
