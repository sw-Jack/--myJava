package lee.java.exam04;
import java.awt.*;

// AWT - BorderLayout
public class BorderEx extends Frame {
	private static final long serialVersionUID = 1L; // 버전 up 권유
	// 멤버
	Label a, b, c, d, e;
	
	//생성자
	public BorderEx() {
		super("BorderLayout");
		
		setLayout(new BorderLayout(5,5));
		a = new Label("↑", Label.CENTER);
		b = new Label("↓", Label.CENTER);
		c = new Label("←", Label.CENTER);
		d = new Label("→", Label.CENTER);
		e = new Label("이동", Label.CENTER);
		
		setBackground(Color.gray);
		a.setBackground(Color.red);
		b.setBackground(Color.green);
		c.setBackground(Color.blue);
		d.setBackground(Color.magenta);
		e.setBackground(Color.yellow);
		
		a.setForeground(Color.white);
		b.setForeground(Color.white);
		c.setForeground(Color.white);
		d.setForeground(Color.white);
		e.setForeground(Color.white);
		
		add("North", a);
		add("South", b);
		add(c, BorderLayout.WEST);
		add(d, BorderLayout.EAST);
		add("Center", e);
		
		setLocation(300,300);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		BorderEx border = new BorderEx();
	}
}
