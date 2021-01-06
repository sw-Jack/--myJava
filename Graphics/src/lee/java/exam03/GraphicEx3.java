package lee.java.exam03;
import java.awt.*;
import java.awt.event.*;

public class GraphicEx3 extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Image im;
	private Button bt1 = new Button("확대");
	private Button bt2 = new Button("축소");
	private int w = 160;
	private int h = 240;
	
	public GraphicEx3() {
		super("Graphic Test");
		im = Toolkit.getDefaultToolkit().getImage("src/image/superCar.jpg");
		setLayout(new BorderLayout());
		add("North", new Label("이미지 파일", Label.CENTER));
		Panel p = new Panel(new FlowLayout(FlowLayout.RIGHT));
		p.add(bt1);
		p.add(bt2);
		bt2.setEnabled(false);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		add("South", p);
		setSize(400, 550);
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		g.drawImage(im, 40, 50, w, h, this);
		System.out.println("new");
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bt1) { // 확대
			bt1.setEnabled(false);
			bt2.setEnabled(true);
			w = 320;
			h = 480;
			repaint();
		}
		if(e.getSource() == bt2) { // 축소
			bt1.setEnabled(true);
			bt2.setEnabled(false);
			w = 160;
			h = 240;
			repaint();
		}
	}
	
	public static void main(String[] args) {
		GraphicEx3 gs = new GraphicEx3();
	}
}
