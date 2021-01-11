package lee.java.exam16;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class JColorChosserEx extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JMenuBar menuBar = new JMenuBar();
	JMenu menuSelect = new JMenu("선택");
	JMenuItem msColor = new JMenuItem("색상");
	JLabel labOutput =  new JLabel("출력창");
	JTextArea ta = new JTextArea();
	
	public JColorChosserEx() {
		super("JColorChooser 테스트");
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
			Color col = colorChooser.showDialog(this, "색상을 고르세요", Color.blue);
			labOutput.setText("선택한  색상은 " + col);
			ta.setBackground(col);
		}
	}

	public static void main(String[] args) {
		new JColorChosserEx();
	}
}
