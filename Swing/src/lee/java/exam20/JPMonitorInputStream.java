package lee.java.exam20;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;


public class JPMonitorInputStream extends JFrame implements ActionListener, Runnable {
	private static final long serialVersionUID = 1L;
	
	private JTextArea jta = new JTextArea();
	private JScrollPane jsp = new JScrollPane();
	private JButton btLoading = new JButton("로딩");
	private JButton btClosing = new JButton("종료");
	
	private JFileChooser fileChooser = new JFileChooser();
	private File file;
	private ProgressMonitorInputStream pmis;
	private BufferedInputStream bis;
	
	public JPMonitorInputStream() {
		super("Test");
		setForm();
		btLoading.addActionListener(this);
		btClosing.addActionListener(this);
	}
	
	public void setForm() {
		add("Center", jsp);
		jsp.setBorder(new TitledBorder("Loading ..."));
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel.add(btLoading); 
		panel.add(btClosing);
		add("South", panel);
		setSize(300,200);
		setVisible(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(d.width/2 - 150, d.height/2 -100);

	}
	
	@Override
	public void run() {
		ProgressMonitor pm = pmis.getProgressMonitor();
		pm.setNote("Started");
		int temp = 0;
		int kk = 0;
		jta.setText("");
		long size = file.length();
		jta.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		try {
			while((temp = pmis.read()) != -1) {
				pm.setNote((int)(kk / (float)size * 100) + "%");
				pm.setProgress(kk++);
				jta.append("" + (char)temp);
				try {
					Thread.sleep(10);
				} catch(InterruptedException e) {}
			}
		} catch(IOException e) {}
		pm.close();
		jta.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btLoading) {
			fileChooser.showOpenDialog(this);
			file = fileChooser.getSelectedFile();
			if(file == null) return;
			try {
				pmis = new ProgressMonitorInputStream(
					this, "Loading" + file.getName() + "...", new FileInputStream(file));										
			} catch(IOException ee) {
				System.err.println("[IOError] " + ee);
			}
			new Thread(this).start();
		}
		if(e.getSource() == btClosing)
			System.exit(0);
	}

	public static void main(String[] args) {
		new JPMonitorInputStream();
	}
}
