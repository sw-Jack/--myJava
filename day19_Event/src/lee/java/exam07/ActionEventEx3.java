package lee.java.exam07;
import java.awt.*;
import java.awt.event.*;

//Action Event Ȱ�� : Menu
public class ActionEventEx3 extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private MenuBar menuBar = new MenuBar();
	private Menu file = new Menu("File");
	private MenuItem now = new MenuItem("Now");
	private MenuItem exit = new MenuItem("Exit");
	
	public ActionEventEx3() {
		super("ActionEventEx3");
		setMenuBar(menuBar);
		menuBar.add(file);
		file.add(now);
		file.addSeparator(); // ���м�
		file.add(exit);
		exit.addActionListener(this);
		setSize(300,200);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

	public static void main(String[] args) {
		new ActionEventEx3();
	}

}
