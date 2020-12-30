package lee.java.exam05;
import java.awt.*;
import java.awt.event.*;

public class ActionEventEx1 extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private TextField textField = new TextField(10);
	
	public ActionEventEx1() {
		super("ActionEventEx1");
		setLayout(new FlowLayout());
		add(textField);
		textField.addActionListener(this);
		setSize(300,200);
		setVisible(true);
	}
	
	// Action Event 메서드
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == textField) {
			String temp = textField.getText();
			System.out.println("메시지 : " + temp);
			textField.setText("");
		}
	}

	public static void main(String[] args) {
		new ActionEventEx1();
	}

}
