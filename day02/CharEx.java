public class CharEx {
	public static void main(String[] args) {
		char ch1 = 'A';		// 0100 0001 = 65
		char ch2 = '\u0041';	// 0100 0001 = 65

		System.out.println("ch1 + ch2 = " + ch1 + ch2);
		System.out.println("ch1 + ch2 = " + (ch1+ch2));

		// ���ڴ� ������ �����ϸ� ���� ������ �����Ѵ�.
		System.out.println("ch1 + ch2 = " + (char)(ch1+ch2));

	}
}
