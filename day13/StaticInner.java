// static inner Ŭ���� ����
public class StaticInner {
	// ��� ����
	int a = 10;
	private int b = 100;
	static int c = 200;

	// static inner Ŭ����
	static class Inner {
		// ��¿ �� ���� �̳� Ŭ������ static���� �����ؾ� �ϴ� ��찡 �ִ�.
		// �̴� �̳� Ŭ������ ����� �� static ����� �ϳ��� ������ ���� ��찡 �ش�ȴ�.
		static int d = 1000; // static ����
		public void printData() {
			System.out.println("static int c : " + c);
			System.out.println("static int d : " + d);
			// System.out.println("int a : " + a); // Error
			// System.out.println("private int b : " + b); // Error
		}
	}

	// main �޼���
	public static void main(String[] args) {
		// �� �ٸ� ������ ��ü���� static inner Ŭ���� ����
		StaticInner.Inner inner = new StaticInner.Inner();
		inner.printData();
	}
}
