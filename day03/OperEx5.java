public class OperEx5 {
	public static void main(String[] args) {
		boolean a;
		boolean b;
		// if((a = 4 > 3) || (b = 5 > 7)) { // short circuit ���� : && || �� ���� �� �����ڴ�
										 // �տ��� ������ ����� �������� ��� ���� ���ʿ��� ������ 
										 // �������� ����. ���� b�� �ʱ�ȭ���� �ʱ� ������ Error!!
										 
		if((a = 4 > 3) | (b = 5 > 7)) {  // ���� �̷� �� %& | �� ���� ��Ʈ �����ڸ� ����ؾ��� 
			System.out.println("a = " + a);
			System.out.println("b = " + b);
			}
	}
}
