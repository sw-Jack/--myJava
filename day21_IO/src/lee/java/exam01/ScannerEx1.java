package lee.java.exam01;
import java.util.*;

// Scanner 활용 예제 : 키보드로부터 숫자 입력 받기
public class ScannerEx1 {
	public static void main(String[] args) {
		System.out.print("숫자 입력 : ");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		System.out.printf("스캔 : %d", number);
		sc.close(); // Scanner도 반드시 닫아줘야 하는 것이 맞다!
	}
}
