import java.io.*;

public class InputEx1 {
	public static void main(String[] args) throws IOException {
		System.out.print("���� �Է� : ");
		// read(), read(byte[]), read(byte[], start, length)
		int i = System.in.read(); // 1byte �Է� �ޱ�
		System.out.println("ASCII Value : " + i);
	}
}
