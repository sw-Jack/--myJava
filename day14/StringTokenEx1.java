// StringTokenizer 클래스 실습
import java.util.StringTokenizer;
public class StringTokenEx1 {
	// 멤버변수 StringTokenize 객체 st
	StringTokenizer st;

	// 생성자
	public StringTokenEx1(String str) {
		System.out.println("str : " + str);
		st = new StringTokenizer(str);
	}
	public StringTokenEx1(String str, String delim) { // delim : 구분자
		System.out.println("str : " + str);
		st = new StringTokenizer(str, delim);
	}
	
	// 메서드
	public void print() {
		System.out.println("Tokent count : " + st.countTokens()); // countTokens() : token된 자원의 수 반환
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
		System.out.println("===============================================");
	}

	public static void main(String[] args) {
		StringTokenEx1 st1 = new StringTokenEx1("Happy day");
		st1.print();
		StringTokenEx1 st2 = new StringTokenEx1("2005/08/15", "/");
		st2.print();
	}
}