package lee.java.exam07;

import java.awt.*;

public class ListEx extends Frame {

	private Label lab = new Label("�ο� ���");
	private List lst = new List(4, true);
	private Button bt = new Button("Ȯ��");
	private String[] name;

	public ListEx(String[] a) {
		super("List Test");
		name = a;
		setLayout(new BorderLayout());
		for(int i=0; i<name.length; i++) {
			lst.add(name[i]);
		}
		add("North", lab);
		add("South", bt);
		add("Center", lst);
		lst.setFont(new Font("����ü", Font.BOLD, 30));
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// ���� : Run as Configurations
		ListEx lst = new ListEx(args);
	}
}
