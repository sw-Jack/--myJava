package lee.java.exam02;

import java.awt.Button;
import java.awt.Frame;
/**
 *	Frame Ŭ������ ��ӹ޾Ƽ� ����� ���
 */
public class MyFrame extends Frame {
	private static final long serialVersionUID = 1L;
	private Button bt1 = new Button("Ȯ��");
	private Button bt2 = new Button("���");

	public MyFrame() {
		super("����");
		add(bt1);
		add(bt2); // �ϳ��� �������� �ϳ��� ������Ʈ�� ���� �� �ִ�. ���� bt2�� ǥ��
		setSize(300,200);
		setVisible(true);
	}

	public static void main(String[] args) {
		MyFrame myframe = new MyFrame();
	}

}
