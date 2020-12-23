class AClass {
}
interface CInter {
}
class BClass extends AClass implements CInter { // 같은 것끼리는 extends, 다른 것끼리는 implements
}
public class ABCEx {
	public static void main(String[] args) {
		BClass bp = new BClass();

		// instanceof 예약어 : 왼쪽의 객체가 오른쪽에 명시한 클래스로 형변환이 가능한지?
		System.out.println(bp instanceof Object); // 객체 bp가 클래스니?
		System.out.println(bp instanceof AClass);
		System.out.println(bp instanceof BClass);
		System.out.println(bp instanceof CInter);
	}
}