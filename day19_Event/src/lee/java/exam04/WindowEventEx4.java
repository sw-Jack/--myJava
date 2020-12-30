package lee.java.exam04;
import java.awt.*;
import java.awt.event.*;

// ���� �͸� Ŭ������ ���� �̺�Ʈ ������ �ۼ� �� �����ϴ� ���
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
