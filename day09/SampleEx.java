class Sample {	// Sample.java -> Sample.class
	// ����ʵ�
	private int x;	// ����ȭ
	int y;
	// ������ - public Sample() { }
	// �޼���  - getter, setter -> �޼��带 ���� ����� �����ϴ� �� : ĸ��ȭ
	public int getX() { return x; }
	public void setX(int value) { x = value; }
}
public class SampleEx { // SampleEx.java -> SampleEx.class
	public static void main(String[] args) {
		Sample sp = new Sample();	// new�� �����Ǵ� ���� �ʱ�ȭ���� �ʾƵ� �ڵ����� 0���� �ʱ�ȭ��
		sp.setX(20);
		System.out.println(sp.getX());
		// �ڹٿ��� ���� ������� ���� ���� �����ڸ� ������. 
		// (���� ������ 4���� : private / public(������) / protected(���) / default(=package:���� ����))
	}
}
/*
	class Abata {
		int hat;  // 1.�������� 2.������ 3.������ ...
		}
*/