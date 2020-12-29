package lee.java.exam02;

import java.awt.Button;
import java.awt.Frame;
/**
 *	Frame 클래스를 상속받아서 만드는 방법
 */
public class MyFrame extends Frame {
	private static final long serialVersionUID = 1L;
	private Button bt1 = new Button("확인");
	private Button bt2 = new Button("취소");

	public MyFrame() {
		super("연습");
		add(bt1);
		add(bt2); // 하나의 영역에는 하나의 컴포넌트만 넣을 수 있다. 따라서 bt2만 표시
		setSize(300,200);
		setVisible(true);
	}

	public static void main(String[] args) {
		MyFrame myframe = new MyFrame();
	}

}
