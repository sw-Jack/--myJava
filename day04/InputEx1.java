import java.io.*;

public class InputEx1 {
	public static void main(String[] args) throws IOException {
		System.out.print("���� �Է� : ");
		// read(), read(byte[]), read(byte[], start, length)
		int i = System.in.read(); // System.in.read(); �� �ƽ�Ű�ڵ� ���, ���� System.in.read() - '0' �̳� System.in.read() - 48 : ���� �ϳ� or ���� �ϳ� �Է�
		System.out.println("ASCII Value : " + i);
	}
}
