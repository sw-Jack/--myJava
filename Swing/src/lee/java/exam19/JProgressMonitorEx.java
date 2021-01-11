package lee.java.exam19;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class JProgressMonitorEx extends JFrame implements ActionListener, Runnable {
	private static final long serialVersionUID = 1L;

	private Icon icon = new ImageIcon("src/image/horse.gif");
	private JButton btStart = new JButton("Ω√¿€", icon);
	private JButton btStop = new JButton("∏ÿ√„", icon);
	private ProgressMonitor PgMonitor;
	private Thread currentThread;
	private boolean bb = true;
	private static int kk = 0;
	
	public JProgressMonitorEx() {
		super("Test");
		setLayout(new BorderLayout());
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel.add(btStart);
		panel.add(btStop);
		btStart.addActionListener(this);
		btStop.addActionListener(this);
		add("South", panel);
		pack();
		setVisible(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension d1 = getSize();
		btStop.setEnabled(false);
		setLocation(d.width/2-d1.width/2, d.height/2-d1.height/2);
		setSize(600,400);
	}
	
	@Override
	public void run() {
		PgMonitor = new ProgressMonitor(this, "ProgressMonitor", 
											"Not Started", 0, 100);
		PgMonitor.setNote("Started");
		if(kk == 100) kk = 0;
		for(int i=kk; i<=100; i++) {
			if(PgMonitor.isCanceled()) break;
			if(!bb) break;
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {}
			PgMonitor.setProgress(i);
			PgMonitor.setNote(i + "%");
			kk = i;
		}
		btStart.setEnabled(true);
		btStop.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btStart) {
			btStart.setEnabled(false);
			btStop.setEnabled(true);
			currentThread = new Thread(this);
			bb = true;
			currentThread.start();
		}
		if(e.getSource() == btStop) {
			btStop.setEnabled(true);
			btStart.setEnabled(false);
			bb = false;
			currentThread = null;
		}
	}

	public static void main(String[] args) {
		new JProgressMonitorEx();
	}
}
