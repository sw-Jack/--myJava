// member inner Ŭ���� ����
class OuterEx {
	public class InnerEx {
		int x = 5;
	}
}
public class InnerEx1 {
	public static void main(String[] args) {
		// �ܺ� Ŭ���� ���� �����ϰ�,
		OuterEx outer = new OuterEx();
		// �ܺθ� ���ؼ� ���� Ŭ������ �����Ѵ�.
		OuterEx.InnerEx inner = outer.new InnerEx();
		System.out.println("inner.x : " + inner.x);
	}
}