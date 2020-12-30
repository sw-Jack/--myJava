package lee.java.exam08;
import java.awt.*;
import java.awt.event.*;

//Action Event 활용 : Menu
public class ActionEventEx4 extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Button[] bts = new Button[4];
	private Panel[] panels = new Panel[4];
	private Color[] colors = 
		{Color.red, Color.green, Color.blue, Color.yellow};
	private CardLayout cardLayout = new CardLayout();
	private Panel panel;
	
	public ActionEventEx4() {
		super("ActionEventEx4");
		setLayout(new BorderLayout());
		Panel p = new Panel(new GridLayout(1,4));
		for(int i=0; i<bts.length; i++) {
			bts[i] = new Button((i+1) + "번 버튼");
			bts[i].addActionListener(this); // Action Button
			p.add(bts[i]);
		}
		add("North", p);
		panel = new Panel(cardLayout);
		for(int i=0; i<panels.length; i++) {
			panels[i] = new Panel();
			panels[i].setBackground(colors[i]);
			panel.add("" + i, panels[i]); // panel.add(String.valueOf(i), panels[i]);
		}
		add("Center", panel);
		cardLayout.show(panel, "0");
		setSize(300,200);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<4; i++) {
			if(e.getSource() == bts[i]) { // 버튼에서 이벤트가 발생한다면
				// cardLayout.show(panel, String.valueOf(i));
				cardLayout.show(panel, "" + i); // '문자 + 숫자 = 문자' 활용
			}
		}
	}

	public static void main(String[] args) {
		new ActionEventEx4();
	}

}
