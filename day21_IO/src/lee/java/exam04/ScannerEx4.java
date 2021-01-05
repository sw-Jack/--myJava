package lee.java.exam04;
import java.util.*;

// Scanner 활용 : String으로부터 읽어오기
public class ScannerEx4 {
	public static void main(String[] args) {
		String str = "1 and 2 and animal and lion and sheep";
		Scanner sc = new Scanner(str);
		sc = sc.useDelimiter("\\s*and\\s*");
		int firstToken = sc.nextInt();
		int secondToken = sc.nextInt();
		String thirdToken = sc.next();
		String fourthToken = sc.next();
		String fifthToken = sc.next();
		System.out.printf("%d, %d, %s, %s, %s", firstToken, secondToken,
				thirdToken, fourthToken, fifthToken);
		sc.close();
	}
}
