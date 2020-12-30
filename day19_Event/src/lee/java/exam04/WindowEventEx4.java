package lee.java.exam04;
import java.awt.*;
import java.awt.event.*;

// 내부 익명 클래스를 통해 이벤트 리스너 작성 및 생성하는 방법
public class WindowEventEx4 extends Frame {
	private static final long serialVersionUID = 1L;

	public WindowEventEx4() {
		super("WindowEventEx4");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setSize(300,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new WindowEventEx4();
	}

}
