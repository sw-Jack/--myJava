package lee.java.exam07;

import java.awt.BorderLayout;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class BorderEx2 extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JTextField jtf = new JTextField();
	private Icon icon2 = new ImageIcon("src/image/icon02.jpg");
	private Icon icon3 = new ImageIcon("src/image/icon03.jpg");
	private JButton jbt = new JButton("»Æ¿Œ", icon3);
	private JLabel jlab = new JLabel("Test", JLabel.CENTER);
	
	public BorderEx2() {
		super("BorderEx2");
		setLayout(new BorderLayout());
		add("North", jtf);
		TitledBorder tb = new TitledBorder(new EtchedBorder(), "ID",
				TitledBorder.LEFT, TitledBorder.TOP);
		jtf.setBorder(tb);
		add("Center", jbt);
		MatteBorder mb = new MatteBorder(30, 30, 30, 30,icon3);
		jbt.setBorder(mb);
		add("South", jlab);
		CompoundBorder cb = new CompoundBorder(new LineBorder(Color.red, 5), 
				new BevelBorder(BevelBorder.RAISED));
		jlab.setBorder(cb);
		setSize(300,350);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BorderEx2();
	}
}
