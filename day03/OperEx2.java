//import java.lang.*; ���� : JVM�� �˾Ƽ� ���ֱ� ������
public class OperEx2 {
	public static void main(String[] args) {
		short a, b;
		a = 10;
		b = 10;
		// �ڹٿ��� ����(byte, short, int, char) ���� ��Ģ ������ ����� �ݵ��
		// ����(int)�� ���´�. ���� short c = a + b; ��� �ϸ� Error!
		short c = (short)(a + b); 
		System.out.println("c�� �� : " + c);
	}
}
