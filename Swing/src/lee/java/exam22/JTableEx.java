package lee.java.exam22;
import javax.swing.*;
import java.util.*;
public class JTableEx extends JFrame {
	private static final long serialVersionUID = 1L;
	
	JTableModel model; // ����� �� ���� Ŭ����
	JTable table;

	public JTableEx() {
		model = new JTableModel();
		table = new JTable(model);
		add(new JScrollPane(table));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,200,300,300);
		setVisible(true);
		// System.out.println(model.getRowCount() + "��" + model.getColumnCount() + "��");
	}

	public static void main(String[] args) {
		new JTableEx();
	}
}
