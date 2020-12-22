public class StaticExam {
	// ��� �ʵ�
	private int x;
	private static int y;
	static { // static �ʱ�ȭ ����
		y = 5;
}
	// ������
	public StaticExam() {
		x = 10;
	}
	// �޼���
	public int getX() {	// getter �� ���� ��� �޼��常�� ���������� static�� ������� ��� ����
		return x;
	}
	public static int getY() { // getter �� ���� ��� �޼��常�� ���������� static�� ������� ��� ����
		return y;
	}

	public static void main(String[] args) {
		// System.out.println("x : " + x);	// Error!
		System.out.println("y : " + getY());

		StaticExam se = new StaticExam();
		System.out.println("x : " + se.getX());
		System.out.println("y : " + y);
		

	}
}