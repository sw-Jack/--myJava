// ������ enum ����
public class EnumEx1 {
	public enum Lesson {
		java, xml, EJB // ������ �����
	}

	public static void main(String[] args) {
		Lesson lesson = Lesson.java;
		System.out.println("Lesson : " + lesson);
		System.out.println("xml : " + Lesson.xml);
	}
}