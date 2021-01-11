package lee.java.exam11;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JSplitEx extends JFrame {
	private static final long serialVersionUID = 1L;
	private JSplitPane splitPane, splitPane1;
	public JSplitEx() {
		super("JSplit 테스트");
		JTextArea jta1 = new JTextArea("첫번째", 20, 10);
		JScrollPane jta1ScrollPane = new JScrollPane(jta1);
		JTextArea jta2 = new JTextArea("두번째", 20, 10);
		JScrollPane jta2ScrollPane = new JScrollPane(jta2);
		splitPane = new JSplitPane(
				JSplitPane.VERTICAL_SPLIT, jta1ScrollPane, jta2ScrollPane);
		JTextArea jta3 = new JTextArea("세번째", 20, 10);
		JScrollPane jta3ScrollPane = new JScrollPane(jta3);
		splitPane1 = new JSplitPane(
				JSplitPane.HORIZONTAL_SPLIT, splitPane, jta3ScrollPane);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(100);
		splitPane.setPreferredSize(new Dimension(200, 200));
		splitPane1.setPreferredSize(new Dimension(400, 200));
		add(splitPane1);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JSplitEx();
	}
}
