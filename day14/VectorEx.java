// Vector Ŭ���� �ǽ�
// vector : ���� ������ �Է� �ޱ�
// object�� ���� �迭�� �߰� ����. ������ Ŭ���� ������ ȿ������.
import java.util.*;
class AA {
	// �������
	int a;
	// ������ 
	AA(int a) {
		this.a = a;
	}
}
public class VectorEx {
	public static void main(String[] args) {
		Vector vc = new Vector();
		vc.add(new AA(10));	
		vc.add(new AA(20));
		vc.add(new AA(30));
		vc.add(new AA(10));
		vc.add(new AA(40));
		vc.add(new AA(50));
		vc.add(1, new AA(15));
	
		for(int i=0; i<vc.size(); i++) {
			AA ap = (AA)vc.elementAt(i);
			System.out.println(ap.a);
		}

		vc.removeElementAt(4);	// �ε��� 4 ���� ����
		for(int i=0; i<vc.size(); i++) {
			AA ap = (AA)vc.elementAt(i);
			System.out.println("���� �� : " + ap.a);
		}
	}
}