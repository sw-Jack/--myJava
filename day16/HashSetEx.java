// Set �������̽� - HashSet �ǽ�
import java.util.*;
class Adata {
	int x; int y;
	public Adata(int x, int y) {
		this.x = x; this.y = y;
	}

	public void disp() {
		System.out.println("x = " + x + ", y = "  + y);
	}
}

public class HashSetEx {
	public static void main(String[] args) {
		Adata ap = new Adata(10,20);
		Adata bp = new Adata(20,30);
		Adata cp = new Adata(30,40);
		HashSet hs = new HashSet();
		hs.add(ap); hs.add(bp); hs.add(cp);
		System.out.println("�ؽ� �ڵ� : " + hs.hashCode());
		System.out.println("�� ������ ũ�� : " + hs.size());
		Iterator it = hs.iterator();
		while(it.hasNext()) 
			((Adata)it.next()).disp();
	}
}