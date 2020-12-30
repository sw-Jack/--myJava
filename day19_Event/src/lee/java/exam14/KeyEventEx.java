package lee.java.exam14;

import java.awt.*;
import java.awt.event.*;

public class KeyEventEx extends Frame implements KeyListener {
	private static final long serialVersionUID = 1L;
	private Label labIdnum = new Label("주민번호", Label.RIGHT);
	private Label labSymbol = new Label("-", Label.CENTER);
	private TextField tfIdnumFront = new TextField(10);
	private TextField tfIdnumRear = new TextField(10);
	private Button btConfirm = new Button("확인");
	
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
			// 앞 칸에서 6자리를 입력했다면
			if(tfIdnumFront.getText().trim().length() == 6) {
				// 다음 칸으로 커서 이동
				tfIdnumRear.requestFocus();
			}
		}
		if(e.getSource() == tfIdnumRear) {
			// 뒷 칸에서 7자리를 입력했다면
			if(tfIdnumRear.getText().trim().length() == 7) {
				// 버튼으로 커서 이동
				btConfirm.requestFocus();
			}
		}
	}

	public static void main(String[] args) {
		new KeyEventEx();
	}

}
