package lee.java.exam18;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javafx.scene.control.ProgressBar;

public class JProgressBarEx extends JFrame implements ActionListener, Runnable {
	private static final long serialVersionUID = 1L;
	
	private JProgressBar jpb =
						new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
	private JButton btStart = new JButton("Ω√¿€");
	private JButton btStop = new JButton("∏ÿ√„");
	
	private boolean bb = true;
	private static int ii;
	
	public JProgressBarEx() {
		super("Test");
		setLayout(new BorderLayout());
		add("North", new JLabel("Progress Bar", JLabel.CENTER));
		add("Center", jpb);
		
		jpb.setStringPainted(true);
		jpb.setString("0%");
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel.add(btStart);
		panel.add(btStop);
		add("South", panel);
		
		btStart.addActionListener(this);
		btStop.addActionListener(this);
		
		setSize(300,150);
		setVisible(true);
	}
		
	@Override
	public void run() {
		if(ii == 100) ii = 0;
		for(int i=ii; i<=100; i++) {
			if(!bb) break;
			try {
				Thread.sleep(50);
			} catch(InterruptedException e) {}
			jpb.setValue(i);
			ii = i;
			jpb.setString(i + "%");
		}
		btStart.setEnabled(true);
		btStop.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btStart) {
			bb = true;
			new Thread(this).start();
			btStart.setEnabled(false);
			btStop.setEnabled(true);
		}
		if(e.getSource() == btStop) {
			bb = false;
			btStart.setEnabled(true);
			btStop.setEnabled(false);
		}
	}

	public static void main(String[] args) {
		new JProgressBarEx();
	}
}
