// Random Ŭ���� �ǽ�
import java.util.*; // java.util.Random;
public class RandomEx {
	public static void main(String[] args) {
		String[] lesson = {"Java Beg", "JSP", "XML&Java", "EJB"};
		Random r1 = new Random();
		// nextInt(n) : 0 ~ (n-1) ������ ���� �߻�
		int idx = r1.nextInt(lesson.length); // 0 ~ 3 ���� �߻�
		System.out.println("���� ���� : " + lesson[idx]);
	}
}
