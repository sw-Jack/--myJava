package lee.java.exam06;

import java.awt.*;
import java.awt.event.*;

// Action Event 활용 : Button
public class ActionEventEx2 extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Button bt = new Button("확인");
	
	public ActionEventEx2() {
		super("ActionEventEx2");
		bt.addActionListener(this);
		setLayout(new FlowLayout());
		add(bt);
		setSize(300,200);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

	public static void main(String[] args) {
		new ActionEventEx2();
	}

}
