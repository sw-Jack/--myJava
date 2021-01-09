package lee.java.exam03;

import java.awt.*; 
import javax.swing.*;

public class JButtonEx extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private Icon icon1 = new ImageIcon("src/image/icon02.jpg");
	private Icon icon2 = new ImageIcon("src/image/icon03.jpg");
	private Icon icon3 = new ImageIcon("src/image/icon04.jpg");
	private Icon icon4 = new ImageIcon("src/image/icon05.jpg");
	
	private JRadioButton[] jrb = new JRadioButton[4];
	
	private ButtonGroup bg = new ButtonGroup();
	
	public JButtonEx() {
		super("Test");
		setLayout(new GridLayout(2,2));
		for(int i=0; i<4; i++) {
			jrb[i] = new JRadioButton((i+1) + "�� ��ư", icon1);
			add(jrb[i]);
			jrb[i].setToolTipText((i+1) + "��° ��ư�̴�. ����...");
			jrb[i].setMnemonic(i + 49);
			jrb[i].setRolloverIcon(icon2); // ���콺 �÷����� ��
			jrb[i].setPressedIcon(icon3); // ���콺 ������ ���� ��
			jrb[i].setSelectedIcon(icon4); // ���콺 Ŭ������ ��
			bg.add(jrb[i]);
		}
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JButtonEx();
	}

}
