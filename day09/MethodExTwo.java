public class MethodExTwo {
	int var1, var2;	// ��� ������
	// ������ 
	public int sum(int a, int b) {	// �޼ҵ�(��� �Լ�)
		return a + b;
		}
	public static void main(String[] args) {
		MethodExTwo me = new MethodExTwo();
		int res = me.sum(1000, -10);
		System.out.println("res = " + res);
	}
} // �޼���(���) �����޴� ��ȯ���� �ϳ��ۿ� �� �����޴´�.???