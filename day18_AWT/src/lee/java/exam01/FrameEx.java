package lee.java.exam01;
import java.awt.Button;
import java.awt.Frame;

// AWT - Frame
/**
 *	��ü�� �߻����Ѽ� �������� �����ϴ� ���
 */
public class FrameEx {

	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setTitle("Test");
		
		Button bt1 = new Button("OK");
		frame.add(bt1);
		Button bt2 = new Button("Cancel");
		frame.add(bt2);	// �ϳ��� �������� �ϳ��� ������Ʈ�� ���� �� �ִ�. ���� bt2�� ǥ��
		
		frame.setSize(300,200);
		frame.setVisible(true);

	}

}
