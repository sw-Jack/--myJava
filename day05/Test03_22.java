import java.io.*;

// 금액 (10 ~ 100000) 을 입력 받아서 화폐의 갯수를 구하는 프로그램
// 만원, 천원, 백원, 십원의 갯수를 구핸다.
public class Test03_22 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("금액 : ");
		int money = Integer.parseInt(br.readLine());

		// 정수(byte, short, int, char) 간의 사칙 연산의 결과는 항상 정수(int)가 나온다.
		System.out.println("만원 : " + (money/10000) + "장");
		System.out.println("천원 : " + (money%10000/1000) + "장");
		System.out.println("백원 : " + (money%1000/100) + "장");
		System.out.println("십원 : " + (money%100/10) + "장");
	}
}
