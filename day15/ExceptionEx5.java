// ���� ó�� �ǽ�
// ���� ó�� ���� : ���� catch��
public class ExceptionEx5 { 
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);

		try {
			System.out.println(3);
			// ArithmeticException �߻� 
			System.out.println(0/0);
			System.out.println(4); // ���� X
		} catch(ArithmeticException ae) {	// ���� Ŭ����
			if(ae instanceof ArithmeticException) 
				System.out.println("true");
			System.out.println("ArithmeticException");
		} catch(Exception e) {				// ���� Ŭ����
			System.out.println("Exception");
		}
		System.out.println(6);
	}
}
// catch ������ ���� ���� Ŭ������ ���� ���� ���� Ŭ�����ϼ��� �Ʒ��� �;� �Ѵ�. (������)