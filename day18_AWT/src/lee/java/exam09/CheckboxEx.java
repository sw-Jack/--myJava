package lee.java.exam09;

import java.awt.*;

public class CheckboxEx extends Frame {

	private Label lab = new Label("�����ϴ� ������?");
	private Button bt = new Button("Ȯ��");
	private Checkbox[] cb = {new Checkbox("�ٳ���"), new Checkbox("����"),
			new Checkbox("���ξ���")};
	
	public CheckboxEx() {
		super("Checkobx");
		setLayout(new GridLayout(5,1));
		add(lab);
		for(int i=0; i<3; i++) {
			add(cb[i]);
		}
		add(bt);
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		CheckboxEx checkbox = new CheckboxEx();
	}

}
