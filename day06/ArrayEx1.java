public class ArrayEx1 {
	public static void main(String[] args) {
		char[] ch;	// 배열 선언
		ch = new char[4];	// 배열 초기화
		
		// 배열 값 할당
		ch[0] = 'J';
		ch[1] = 'a';
		ch[2] = 'v';
		ch[3] = 'a';

		// 배열 내용 출력
		for(int i=0; i<ch.length; i++) 
			System.out.println("ch[" + i + "] : = " + ch[i]);
		//향상된 for 문
		int j=0;
		for(char temp : ch) { // ch가 있는 위치엔 Series 값이 온다.
			System.out.println("temp " + j + " : " + temp);
			j++;
		}
	}
}
