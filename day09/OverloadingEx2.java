public class OverloadingEx2 {
	public void getLength(int n) {
		String s = String.valueOf(n);	// String.valueOf(n) : ���ڿ��� ����ȯ
		getLength(s);
	}
	void getLength(float n) {
		String s = String.valueOf(n);
		getLength(s);
	}
	private int getLength(String str) {
		System.out.println("�Է��� ���� ���� : " + str.length());
		return 0;
	}
	public static void main(String[] args) {
		OverloadingEx2 oe2 = new OverloadingEx2();
		oe2.getLength(1000);
		oe2.getLength(3.14f);
		oe2.getLength("10000");
	}
}