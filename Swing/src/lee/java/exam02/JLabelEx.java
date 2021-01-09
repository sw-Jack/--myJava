package lee.java.exam02;
import java.awt.*;
import javax.swing.*;

public class JLabelEx extends JFrame {
	private static final long serialVersionUID = 1L;

	private Icon icon = new ImageIcon("src/image/icon01.jpg");
	private JLabel jlab1 = new JLabel(icon);
	private JLabel jlab2 = new JLabel("TestIcon1", JLabel.CENTER);
	private JLabel jlab3 = new JLabel("TestIcon2", icon, SwingConstants.RIGHT);
	
	public JLabelEx() {
		super("JLabelEx");
		setLayout(new GridLayout(3,1));
		add(jlab1);
		add(jlab2);
		jlab2.setIcon(icon);
		add(jlab3);
		setSize(600,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JLabelEx();
	}

}
