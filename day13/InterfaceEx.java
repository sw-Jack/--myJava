interface InterEx {
	// �������̽��� ����� �߻� �޼���θ� ������
	// ���
	static final int A = 100; 
	//  �߻� �޼���
	abstract int getA(); // abstract ������ ���� ����
}
public class InterfaceEx implements InterEx {
	public int getA() {
		return A;
	}
	public static void main(String[] args) {
		InterfaceEx if1 = new InterfaceEx();
		System.out.println("getA() : " + if1.getA());
	}
}