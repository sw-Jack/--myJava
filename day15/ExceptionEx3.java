// ���� ó�� �ǽ�
// ���� ó�� ������ ���� ����
public class ExceptionEx3 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
        try {
			System.out.println(3);
			// ArithmeticException �κ� : 0���� ����
			System.out.println(0/0); // ���� �߻� -> ���ܸ� ó���� catch�� �Ѿ
			System.out.println(4); // ���� �κ� ���� �߻����� �ش� �� ���� X
		} catch(ArithmeticException ae) {
			System.out.println(5);
		}
		System.out.println(6);
	}
}
        