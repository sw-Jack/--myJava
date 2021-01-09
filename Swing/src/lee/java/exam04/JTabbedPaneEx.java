package lee.java.exam04;

import java.awt.*;
import javax.swing.*;

public class JTabbedPaneEx extends JFrame {
	private static final long serialVersionUID = 1L;

	private ImageIcon icon1 = new ImageIcon("src/image/icon01.jpg");
	private ImageIcon icon2 = new ImageIcon("src/image/icon02.jpg");
	
	private JLabel jlab = new JLabel("��� ��", icon1, JLabel.CENTER);
	private JButton jbt = new JButton("��� ��ư", icon1);
	
	private JTabbedPane jtp = new JTabbedPane(SwingConstants.TOP);
	
	public JTabbedPaneEx() {
		super("JTabbedPaneEx");
		setLayout(new BorderLayout());
		jtp.addTab("��", icon2, jlab);
		jtp.addTab("��ư", icon2, jbt);
		add("Center", jtp);
		setSize(800,800);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JTabbedPaneEx();
	}

}
