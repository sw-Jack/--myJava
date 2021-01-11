package lee.java.exam17;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JToolBarEx extends JFrame {
	private static final long serialVersionUID = 1L;

	public JToolBarEx() {
		super("���� �׽�Ʈ");
		JToolBar toolBar = new JToolBar("����");
		toolBar.setMargin(new Insets(5,5,5,5));
		JPanel panel = new JPanel(new GridLayout(1,0));
		JButton bt1 = new JButton("Windows");
		JButton bt2 = new JButton("Linux");
		JButton bt3 = new JButton("Mac-OS");
		
		panel.add(bt1);
		panel.add(bt2);
		panel.add(bt3);
		
		toolBar.add(panel);
		
		add("North", toolBar);
		setBounds(300,300,300,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JToolBarEx();
	}
}
