]// �߻� Ŭ����
abstract class Diagram {
	// �߻� �޼��尡 �ֱ� ������ �ش� Ŭ������ �߻� Ŭ����
	abstract void draw();
}
class Triangle extends Diagram {
	void draw() {
		System.out.println("�ﰢ���� �׸���.");
	}
}
class Rectangle extends Diagram {
	void draw() {
		System.out.println("�簢���� �׸���.");
	}
}
class Circle extends Diagram {
	void draw() {
		System.out.println("���� �׸���.");
	}
}

public class UseDraw {
	public static void main(String[] args) {
		Diagram[] ref = new Diagram[3];
		ref[0] = new Triangle();
		ref[1] = new Rectangle();
		ref[2] = new Circle();
		for(int i=0; i<ref.length; i++) 
			ref[i].draw();
	}
}