package lee.java.exam01;
import java.awt.*;
import java.awt.event.*;

// �̺�Ʈ �����ʸ� ������ Ŭ������ ���� �����ϰ� �� �� �����ϴ� ���
public class WindowEventEx1 {
	public static void main(String[] args) {

		Frame frame = new Frame("EventEx1");
		WinEvent winEvent = new WinEvent();
		frame.addWindowListener(winEvent);
		frame.setSize(300,200);
		frame.setVisible(true);
	}

}
