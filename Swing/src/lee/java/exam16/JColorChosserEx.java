package lee.java.exam16;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class JColorChosserEx extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JMenuBar menuBar = new JMenuBar();
	JMenu menuSelect = new JMenu("����");
	JMenuItem msColor = new JMenuItem("����");
	JLabel labOutput =  new JLabel("���â");
	JTextArea ta = new JTextArea();
	
	public JColorChosserEx() {
		super("JColorChooser �׽�Ʈ");
		menuSelect.add(msColor);
		menuBar.add(menuSelect);
		setJMenuBar(menuBar);
		add("North", labOutput);
		add("Center", ta);
		setBounds(300,300,300,200);
		setVisible(true);
		msColor.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == msColor) {
			JColorChooser colorChooser = new JColorChooser();
			Color col = colorChooser.showDialog(this, "������ ������", Color.blue);
			labOutput.setText("������  ������ " + col);
			ta.setBackground(col);
		}
	}

	public static void main(String[] args) {
		new JColorChosserEx();
	}
}
