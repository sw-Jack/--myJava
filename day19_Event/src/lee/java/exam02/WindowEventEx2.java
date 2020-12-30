package lee.java.exam02;
import java.awt.*;
import java.awt.event.*;

// 이벤트 리스너를 프레임 자체에서 구현하는 방법
public class WindowEventEx2 extends Frame implements WindowListener {
	private static final long serialVersionUID = 1L;

	public WindowEventEx2() {
		super("EventEx2");
		addWindowListener(this);
		setSize(300,200);
		setVisible(true);
	}


	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}		

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

	public static void main(String[] args) {
		new WindowEventEx2();
	}
}
