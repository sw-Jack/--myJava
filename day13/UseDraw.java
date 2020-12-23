]// 추상 클래스
abstract class Diagram {
	// 추상 메서드가 있기 때문에 해당 클래스는 추상 클래스
	abstract void draw();
}
class Triangle extends Diagram {
	void draw() {
		System.out.println("삼각형을 그린다.");
	}
}
class Rectangle extends Diagram {
	void draw() {
		System.out.println("사각형을 그린다.");
	}
}
class Circle extends Diagram {
	void draw() {
		System.out.println("원을 그린다.");
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