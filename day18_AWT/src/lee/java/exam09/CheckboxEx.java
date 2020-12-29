package lee.java.exam09;

import java.awt.*;

public class CheckboxEx extends Frame {

	private Label lab = new Label("좋아하는 과일은?");
	private Button bt = new Button("확인");
	private Checkbox[] cb = {new Checkbox("바나나"), new Checkbox("딸기"),
			new Checkbox("파인애플")};
	
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
