package lee.java.exam01;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JFrameEx extends JFrame {
	private static final long serialVersionUID = 1L;

	public JFrameEx() {
		super("JFrame �׽�Ʈ");
		JButton bt1 = new JButton("This is Swing North");
		JButton bt2 = new JButton("This is Swing Center");
		
		Container con = getContentPane(); // �ڹ� ���� ���� �̻󿡼��� �����̳� ��ü �������ص� ��
		con.add("North", bt1); // add("North", bt1);
		con.add("Center", bt2); // add("Center", bt2);
		
		setSize(200,200);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������ â ����  : �⺻���� �����Ǿ� ����
	}
	public static void main(String[] args) {
		new JFrameEx();
	}

}
