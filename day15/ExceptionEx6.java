// ���� ó�� �ǽ�
// finally�� ������ ���� ó��
public class ExceptionEx6 {
	int[] ss;
	public ExceptionEx6() {
		ss = new int[3]; // �Ӽ�(����ʵ�) �ʱ�ȭ
	}

	public void program() {
		for(int i=0; i<=ss.length; i++) {
			System.out.println("for���� ���� " + i + "��°");
			try {
				System.out.println(ss[i]);
			} catch(Exception e) {
				System.out.println("Exception �߻� : " + e.toString());
				return;
			} finally{ 
				System.out.println("finally ����");
			}
			System.out.println("for���� �� " + i + "��°"); // �տ��� ���� �߻��� �ش� ���� ���� Xx
		}
	}
	public static void main(String[] args) {
		ExceptionEx6 ref = new ExceptionEx6();
		ref.program();
		System.out.println("���α׷� ��!");
	}
}