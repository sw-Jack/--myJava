// ���� ���� : throws
public class ExceptionEx7 {
	private static void test() throws Exception {	// ���� ����
		System.out.println(6/0); // ���� �߻�
	}
	 
	public static void main(String[] args) {
		try {
			test(); // try ~ catch ������ ���� ó���ؾ���
		} catch(Exception e) {
			System.out.println("���� �߻�");
		}
	}
}
