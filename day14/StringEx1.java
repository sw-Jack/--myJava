// String 클래스 실습
// '==' 연산자는 객체의 주소값 비교 
// 따라서 객체의 값비교는 equals() 메서드를 이용한다,
public class StringEx1 {
	public static void main(String[] args) {
		String s1 = "Twinkle";
		String s2 = "Twinkle";	
		if(s1 == s2)	
			System.out.println("s1과 s2는 같다.");
		else
			System.out.println("s1과 s2는 같지 않다.");

		String s3 = new String("Little Star");
		String s4 = new String("Little Star");
		if(s3 == s4)	// 주소 비교 : new에 의해 각각 자신의 메모리 생성
			System.out.println("s3와 s4는 같다.");
		else
			System.out.println("s3과 s4는 같지 않다.");
	}
}
		