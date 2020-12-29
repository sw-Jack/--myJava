package lee.java.exam06;

import java.awt.*;
public class TextEx extends Frame {
	
	private TextField tf = new TextField("제목 : ");
	private TextArea ta = new TextArea("메모", 5, 10);
	private Button bt = new Button("확인");
	private Label lab = new Label("내용");
	
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
