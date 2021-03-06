class Sample {	// Sample.java -> Sample.class
	// 멤버필드
	private int x;	// 은닉화
	int y;
	// 생성자 - public Sample() { }
	// 메서드  - getter, setter -> 메서드를 통해 기능을 제공하는 것 : 캡슐화
	public int getX() { return x; }
	public void setX(int value) { x = value; }
}
public class SampleEx { // SampleEx.java -> SampleEx.class
	public static void main(String[] args) {
		Sample sp = new Sample();	// new로 생성되는 값은 초기화하지 않아도 자동으로 0으로 초기화됨
		sp.setX(20);
		System.out.println(sp.getX());
		// 자바에서 포함 멤버들이 각각 접근 지정자를 가진다. 
		// (접근 지정자 4가지 : private / public(누구나) / protected(상속) / default(=package:같은 폴더))
	}
}
/*
	class Abata {
		int hat;  // 1.밀집모자 2.빵모자 3.베레모 ...
		}
*/
