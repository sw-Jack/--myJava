public class StringMethodEx {
	public static void main(String[] args) {
		
		String str = "Welcome To Ja va ";

		// str.charAt(idx); str의 idx에 해당하는 문자 추출 // 공백도 인정
		char ch1 = str.charAt(0);
		char ch2 = str.charAt(5);
		
		// str.length(); str 문자열의 길이 // 공백도 인정
		int len = str.length();

		// str.toLowerCase(); 소문자로 변환
		// str.toUpperCase(); 대문자로 변환
		String low = str.toLowerCase();
		String up = str.toUpperCase();
		
		// String.valueOf(숫자); 숫자를 문자열(타입)로 변환
		String exStr = String.valueOf(10);

		// str.trim(); 공백이나 화이트 코드 제거
		String exTrim = str.trim();
		
		//str.substring(a,b); str에서 인덱스 a ~ b-1 까지 추출
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
