public class OverloadingEx1 {
	public void intLength(int a) {
		String s = String.valueOf(a);
		System.out.println("�Է��� ���� ���� : " + s.length());
	}
	public void floatLength(float f) {
		String s = String.valueOf(f);
		System.out.println("�Է��� ���� ���� : " + s.length());
	}
	public void stringLength(String str) {
		System.out.println("�Է��� ���� ���� : " + str.length());
	}
	public static void main(String[] args) {
		OverloadingEx1 oe1 = new OverloadingEx1();

		oe1.intLength(1000);
		oe1.floatLength(3.14f);
		oe1.stringLength("10000");
	}
}