public class StringMethodEx {
	public static void main(String[] args) {
		
		String str = "Welcome To Ja va ";

		// str.charAt(idx); str�� idx�� �ش��ϴ� ���� ���� // ���鵵 ����
		char ch1 = str.charAt(0);
		char ch2 = str.charAt(5);
		
		// str.length(); str ���ڿ��� ���� // ���鵵 ����
		int len = str.length();

		// str.toLowerCase(); �ҹ��ڷ� ��ȯ
		// str.toUpperCase(); �빮�ڷ� ��ȯ
		String low = str.toLowerCase();
		String up = str.toUpperCase();
		
		// String.valueOf(����); ���ڸ� ���ڿ�(Ÿ��)�� ��ȯ
		String exStr = String.valueOf(10);

		// str.trim(); �����̳� ȭ��Ʈ �ڵ� ����
		String exTrim = str.trim();
		
		//str.substring(a,b); str���� �ε��� a ~ b-1 ���� ����
		String exStrSub = str.substring(0,4);

		System.out.println("str : " + str);
		System.out.println("ch1 : " + ch1 + ", " + "ch2 : " + ch2);
		System.out.println("len : " + ", " + len);
		System.out.println("low : " + low + ", " + "up : " + up);
		System.out.println("exStr : " + exStr);
		System.out.println("exTrim : " + exTrim);
		System.out.println("exStrSub : " + exStrSub);
	}
}
