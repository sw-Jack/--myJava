// Random 클래스 실습
import java.util.*; // java.util.Random;
public class RandomEx {
	public static void main(String[] args) {
		String[] lesson = {"Java Beg", "JSP", "XML&Java", "EJB"};
		Random r1 = new Random();
		// nextInt(n) : 0 ~ (n-1) 범위의 난수 발생
		int idx = r1.nextInt(lesson.length); // 0 ~ 3 난수 발생
		System.out.println("선택 과목 : " + lesson[idx]);
	}
}
