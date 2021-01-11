package lee.java.exam14;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class JPopupEx extends JFrame implements MouseListener {
	private static final long serialVersionUID = 1L;

	private JTextField jtf = new JTextField("None");
	private JPopupMenu jpm = new JPopupMenu();
	private JMenuItem jmi1 = new JMenuItem("Copy");
	private JMenuItem jmi2 = new JMenuItem("Cut");
	private JMenuItem jmi3 = new JMenuItem("Paste");
	
	public JPopupEx() {
		super("JpopupEx");
		jpm.add(jmi1);
		jmi1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jtf.setText("Copy");
			}
		});
		jpm.add(jmi2);
		jmi2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jtf.setText("Cut");
			}
		});
		jpm.add(new JSeparator());
		jpm.add(jmi3);
		jmi3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jtf.setText("Paste");
			}
		});
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add("North", jtf);
		this.addMouseListener(this);
		setSize(300,200);
		setVisible(true);
		jtf.setEditable(false);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) { // 오른쪽 마우스 클릭
		if(e.getSource() == this) {
			if(e.isPopupTrigger()) {
				jpm.show(e.getComponent(), e.getX(), e.getY());
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	public static void main(String[] args) {
		new JPopupEx();
	}
}
