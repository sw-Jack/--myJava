class AClass {
}
interface CInter {
}
class BClass extends AClass implements CInter { // ���� �ͳ����� extends, �ٸ� �ͳ����� implements
}
public class ABCEx {
	public static void main(String[] args) {
		BClass bp = new BClass();

		// instanceof ����� : ������ ��ü�� �����ʿ� ����� Ŭ������ ����ȯ�� ��������?
		System.out.println(bp instanceof Object); // ��ü bp�� Ŭ������?
		System.out.println(bp instanceof AClass);
		System.out.println(bp instanceof BClass);
		System.out.println(bp instanceof CInter);
	}
}