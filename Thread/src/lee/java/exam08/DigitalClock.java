package lee.java.exam08;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class DigitalClock extends Frame implements Runnable, ActionListener {

	private Button btStart = new Button("시작");
	
	public DigitalClock() {
		 super("디지털 시계");
		 setLayout(new BorderLayout());
		 add("South", btStart);
		 btStart.addActionListener(this);
		 addWindowListener(new WindowAdapter() {
			 @Override
			 public void windowClosing(WindowEvent e) {
				 System.exit(0);
			 }
		 });
		 setSize(600,200);
		 setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btStart) {
			Thread th = new Thread(this); 
			btStart.setEnabled(false);
			th.start();
		}
	}

	public void paint(Graphics g) {
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		g.setFont(new Font("굴림체", Font.BOLD, 30));
		g.drawString(date.toString(), 50, 100);
	}
	
	@Override
	public void run() {
		while(true) {
			repaint();
			try {
				Thread.sleep(1000); // 1초 간격
			} catch(InterruptedException e) {}
		}
	}

	public static void main(String[] args) {
		new DigitalClock();
	}

}
