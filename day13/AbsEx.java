abstract class AbsEx1 {
	int a = 100; // ����
	final String str = "abstract test"; // ���
	public String getStr() { // �Ϲ� �޼���
		return str;
	}

	// �߻� �޼���� ��ü(body)�� ����.
	abstract public int getA();4
}
abstract class AbsEx2 extends AbsEx1 {
	public int getA() { // �θ� Ŭ����(AbsEx1)�� �߻� �޼��� ������
		return a;
	}
	// �߻� �޼���
	abstract public String getStr(); 
}
public class AbsEx extends AbsEx2 {
	public String getStr() { // AbsEx2�� �߻� �޼��� ������
		return str; // str�� AbsEx1�� ���
	}

	// main �޼���
	public static void main(String[] args) {
		AbsEx abs = new AbsEx();
		
		System.out.println("abs.getA() : " + abs.getA());
		System.out.println("abs.getStr() : " + abs.getStr());
	}
}