package lee.java.exam01;
import java.awt.Button;
import java.awt.Frame;

// AWT - Frame
/**
 *	객체를 발생시켜서 프레임을 생성하는 방법
 */
public class FrameEx {

	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setTitle("Test");
		
		Button bt1 = new Button("OK");
		frame.add(bt1);
		Button bt2 = new Button("Cancel");
		frame.add(bt2);	// 하나의 영역에는 하나의 컴포넌트만 넣을 수 있다. 따라서 bt2만 표시
		
		frame.setSize(300,200);
		frame.setVisible(true);

	}

}
