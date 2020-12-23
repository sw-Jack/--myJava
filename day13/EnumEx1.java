// 열거형 enum 예제
public class EnumEx1 {
	public enum Lesson {
		java, xml, EJB // 열거형 상수들
	}

	public static void main(String[] args) {
		Lesson lesson = Lesson.java;
		System.out.println("Lesson : " + lesson);
		System.out.println("xml : " + Lesson.xml);
	}
}