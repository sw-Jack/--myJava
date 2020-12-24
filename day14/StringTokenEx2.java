// StringTokenizer 클래스 실습 : StringTokenizer와 split() 함수의 차이
import java.util.StringTokenizer;
public class StringTokenEx2 { 
	public static void main(String[] args) {
		String str = "학교, 집,,게임방";

		// StringTokenizer
		StringTokenizer tokens = new StringTokenizer(str, ",");
		for(int i=1; tokens.hasMoreTokens(); i++) {
			System.out.print("문자" + i + " = " + tokens.nextToken() + "\t");
		}
		System.out.println();
		System.out.println("===============================================================");

		// split() 함수
		String[] values = str.split(",");
		for(int i=0; i<values.length; i++) {
			System.out.print("문자" + (i+1) + " = " + values[i] + "\t");
		}
		System.out.println();
	}
}

// StringTokenizer : 무의미한 공백을 무시하고 제거
// split() 함수 : 공백도 인정, 빈 채로 출력