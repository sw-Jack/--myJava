import java.io.*;

// �ݾ� (10 ~ 100000) �� �Է� �޾Ƽ� ȭ���� ������ ���ϴ� ���α׷�
// ����, õ��, ���, �ʿ��� ������ ���ڴ�.
public class Test03_22 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("�ݾ� : ");
		int money = Integer.parseInt(br.readLine());

		// ����(byte, short, int, char) ���� ��Ģ ������ ����� �׻� ����(int)�� ���´�.
		System.out.println("���� : " + (money/10000) + "��");
		System.out.println("õ�� : " + (money%10000/1000) + "��");
		System.out.println("��� : " + (money%1000/100) + "��");
		System.out.println("�ʿ� : " + (money%100/10) + "��");
	}
}
