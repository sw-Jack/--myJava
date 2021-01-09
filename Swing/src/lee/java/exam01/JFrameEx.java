package lee.java.exam01;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JFrameEx extends JFrame {
	private static final long serialVersionUID = 1L;

	public JFrameEx() {
		super("JFrame 테스트");
		JButton bt1 = new JButton("This is Swing North");
		JButton bt2 = new JButton("This is Swing Center");
		
		Container con = getContentPane(); // 자바 일정 버전 이상에서는 컨테이너 객체 생성안해도 됨
		con.add("North", bt1); // add("North", bt1);
		con.add("Center", bt2); // add("Center", bt2);
		
		setSize(200,200);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우 창 종료  : 기본으로 설정되어 있음
	}
	public static void main(String[] args) {
		new JFrameEx();
	}

}
