import java.io.*;

public class InputEx1 {
	public static void main(String[] args) throws IOException {
		System.out.print("문자 입력 : ");
		// read(), read(byte[]), read(byte[], start, length)
		int i = System.in.read(); // 1byte 입력 받기
		System.out.println("ASCII Value : " + i);
	}
}
