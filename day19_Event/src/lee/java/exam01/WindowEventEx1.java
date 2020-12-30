package lee.java.exam01;
import java.awt.*;
import java.awt.event.*;

// 이벤트 리스너를 구현한 클래스를 따로 생성하고 난 후 연결하는 방법
public class WindowEventEx1 {
	public static void main(String[] args) {

		Frame frame = new Frame("EventEx1");
		WinEvent winEvent = new WinEvent();
		frame.addWindowListener(winEvent);
		frame.setSize(300,200);
		frame.setVisible(true);
	}

}
