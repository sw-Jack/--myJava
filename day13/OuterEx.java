// static inner Ŭ���� ����
public class OuterEx {
	// inner Ŭ�������� Outer Ŭ���� �̸��� $�� ���� ������ class���Ϸ� �����.
	public static class InnerEx { 
		static int x = 10;
		public static void main(String[] args) {
			OuterEx.InnerEx inner = new OuterEx.InnerEx();
			System.out.println("inner.x : " + inner.x);
			System.out.println("inner.x : " + OuterEx.InnerEx.x);
		}
	}
}
// �����Ϸ��� "java OuterEx$InnerEx"