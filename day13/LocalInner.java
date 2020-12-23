// local inner Ŭ���� ����
public class LocalInner {
	// ��� ����
	int a = 100; 
	// �޼���
	public void innerTest(int k) {
		int b = 200; // ��������
		final int c = k; // ���
		
		// ���� �̳� Ŭ���� (�Ϲ� �޼��� ��)
		class Inner {
			// Local Inner Ŭ������ �ܺ� Ŭ������ ��� ������ 
			// ����鸸�� ������ �����ϴ�.
			public void getData() {
				System.out.println("int a : " + a); // �ܺ� Ŭ������ ��� ���� ��� ����
				System.out.println("int b : " + b); // �Ź����� ���� ���������� ��� ��������
				System.out.println("final int c : " + c); // ��� ��� ����
				
			}
		}
		
		Inner i = new Inner(); // �޼��� ������ Local Inner Ŭ���� ����
		i.getData(); // ������ reference�� ���� �޼��� ȣ��
	}

	// main �޼���
	public static void main(String[] args) {
		LocalInner outer = new LocalInner();
		outer.innerTest(1000);
	}
}