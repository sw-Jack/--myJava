package lee.java.exam01;
import java.util.*;

// Scanner Ȱ�� ���� : Ű����κ��� ���� �Է� �ޱ�
public class ScannerEx1 {
	public static void main(String[] args) {
		System.out.print("���� �Է� : ");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		System.out.printf("��ĵ : %d", number);
		sc.close(); // Scanner�� �ݵ�� �ݾ���� �ϴ� ���� �´�!
	}
}
