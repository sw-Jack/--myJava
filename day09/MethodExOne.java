class MethodEx {
	// ����ʵ�
	// ������ - default ������ public MethodEx() { }
	// �޼���
	public int sum(int i, int j) {
		return i + j;
	}
	public int sub(int i, int j) {
		return i - j;
	}
	public int mul(int i, int j) {
		return i * j;
	}
	public int div(int i, int j) {
		return i / j;
	}
}
	
public class MethodExOne {  
	public static void main(String[] args) {
		MethodEx ref = new MethodEx();	// ��ü ����, ��ü.�޼���
		int i = 10;
		int j = 10;
		
		System.out.println("���� �� : " + ref.sum(i,j));
		System.out.println("�� �� : " + ref.sub(i,j));
		System.out.println("���� �� : " + ref.mul(i,j));
		System.out.println("���� �� : " + ref.div(i,j));
	}
}
