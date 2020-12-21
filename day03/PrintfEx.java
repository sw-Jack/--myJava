public class PrintfEx {
	public static void main(String[] args) {
		int a = 100;
		char b = 'A';
		float c = 12.346f;
		String d = "이승재";
		System.out.printf("a = %d입니다.\n", a);
		// %n 대신에 \n도 사용 가능
		System.out.printf("b = %c = %d %n", b, (int)b);
		System.out.printf("c = %6.2f %n", c);
		System.out.printf("d = %s입니다.", d);
	}
}
