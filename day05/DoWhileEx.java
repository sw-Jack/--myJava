import java.io.*;
public class DoWhileEx { // ����� �޴� �Է� �����ϱ�
	public static void main(String[] args) throws IOException {

		int menu = 0;
		do {
			System.out.println("1. ȸ������");
			System.out.println("2. ȸ����ȸ");
			System.out.println("3. ȸ��Ż��");
			System.out.println("0. ���α׷�����");
			System.out.print("�޴� ���� : ");
			menu = System.in.read() - 48;
			System.in.read(); System.in.read();
			} while(menu != 1 && menu != 2 && menu != 3 && menu != 0);
		System.out.println("������ �޴� : " + menu);
	}
}