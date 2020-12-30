package lee.java.exam13;

import java.awt.*;
import java.awt.event.*;

public class FocusEventEx extends Frame implements FocusListener {
	private static final long serialVersionUID = 1L;
	private TextField[] tfs = new TextField[3];
	
	public FocusEventEx() {
		super("FocusEx");
		setForm();
		setSize(200,100);
		setVisible(true);
	}
	
	public void setForm() {
		setLayout(new BorderLayout());
		Panel panel1 = new Panel(new GridLayout(3,1));
		panel1.add(new Label("이름"));
		panel1.add(new Label("전화"));
		panel1.add(new Label("주소"));
		add("West", panel1);
		
		Panel panel2 = new Panel(new GridLayout(3,1));
		for(int i=0; i<tfs.length; i++) {
			tfs[i] = new TextField();
			panel2.add(tfs[i]); 
			tfs[i].addFocusListener(this);
		}
		add("Center", panel2);
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource() == tfs[1]) {
			if(tfs[0].getText().trim().length() == 0) {
				tfs[0].setText("");
				try {
					Thread.sleep(3000);
				} catch(InterruptedException ie) {}
				tfs[0].requestFocus();
			}
		}
		if(e.getSource() == tfs[2]) {
			if(tfs[1].getText().trim().length() == 0) {
				tfs[1].setText("");
				try {
					Thread.sleep(3000); // 3초 중지
				} catch(InterruptedException ie) {}
				tfs[1].requestFocus();
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {}

	public static void main(String[] args) {
		new FocusEventEx();
	}

}
