package lee.java.exam06;

import java.awt.*;
public class TextEx extends Frame {
	
	private TextField tf = new TextField("���� : ");
	private TextArea ta = new TextArea("�޸�", 5, 10);
	private Button bt = new Button("Ȯ��");
	private Label lab = new Label("����");
	
	public TextEx() {
		super("TextFieldEx");
		setLayout(new BorderLayout());
		add("North", tf);
		add("South", bt);
		add("Center", ta);
		add("West", lab);
		setSize(300,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		TextEx te = new TextEx();
	}
}
