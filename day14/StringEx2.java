// String 클래스 실습
public class StringEx2 {
	public static void main(String[] args) {
		String str = new String();
		str += "Hello";
		str += " Java";
		System.out.println("str : " + str);
	}
}

// String 객체는 편집되지 않는다
// str += "..."; 와 같은 코딩이 계속된다 해도 객체는 편집되지 않는다.
// 기존의 String 객체에 새로운 String 값을 더하면 기존의 객체가 수정되는 것이 아니고
// 새로운 객체를 참조하게 되는 것이다.
// 따라서 위의 예제에서 str은 하나의 객체로 보일 수 있지만 실제로는 5개의 String 객체가 생성되는 것이다.
