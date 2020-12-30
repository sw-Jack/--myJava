package lee.java.exam14;

import java.awt.*;
import java.awt.event.*;

public class KeyEventEx extends Frame implements KeyListener {
	private static final long serialVersionUID = 1L;
	private Label labIdnum = new Label("�ֹι�ȣ", Label.RIGHT);
	private Label labSymbol = new Label("-", Label.CENTER);
	private TextField tfIdnumFront = new TextField(10);
	private TextField tfIdnumRear = new TextField(10);
	private Button btConfirm = new Button("Ȯ��");
	
	public KeyEventEx() {
		super("KeyEventEx");
		setForm();
		setEvent();
		pack();
		setVisible(true);
	}
	
	public void setEvent() {
		tfIdnumFront.addKeyListener(this);
		tfIdnumRear.addKeyListener(this);
	}
	
	public void setForm() {
		setLayout(new BorderLayout());
		add("West", labIdnum);
		Panel panel1 = new Panel(new FlowLayout(FlowLayout.LEFT));
		panel1.add("West", tfIdnumFront);
		panel1.add("Center", labSymbol);
		panel1.add("East", tfIdnumRear);
		add("Center", panel1);
		
		Panel panel2 = new Panel(new FlowLayout(FlowLayout.RIGHT));
		panel2.add(btConfirm);
		add("South", panel2);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getSource() == tfIdnumFront) {
			// �� ĭ���� 6�ڸ��� �Է��ߴٸ�
			if(tfIdnumFront.getText().trim().length() == 6) {
				// ���� ĭ���� Ŀ�� �̵�
				tfIdnumRear.requestFocus();
			}
		}
		if(e.getSource() == tfIdnumRear) {
			// �� ĭ���� 7�ڸ��� �Է��ߴٸ�
			if(tfIdnumRear.getText().trim().length() == 7) {
				// ��ư���� Ŀ�� �̵�
				btConfirm.requestFocus();
			}
		}
	}

	public static void main(String[] args) {
		new KeyEventEx();
	}

}
