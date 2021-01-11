package lee.java.exam12;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JInternalFrameEx extends JFrame 
										implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JDesktopPane desktop = new JDesktopPane();
	private JMenuItem openItem = new JMenuItem("New");
	private JMenuItem closeItem = new JMenuItem("Close");
	private JMenuItem exitItem = new JMenuItem("Exit");
	private int cnt = 1;
	
	public JInternalFrameEx () {
		super("JInternalFrame테스트");
		buildGUI();
		setBounds(300, 200, 500, 400);
		setVisible(true);
	}
	
	public void buildGUI() {
		add(desktop, BorderLayout.CENTER);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		fileMenu.add(openItem);
		fileMenu.add(closeItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		openItem.addActionListener(this);
		closeItem.addActionListener(this);
		exitItem.addActionListener(this);
	}
	
	public void openFrame() {
		JInternalFrame iframe = new JInternalFrame("새문서"+cnt, true, true, true, true);
		JLabel imageLabel = new JLabel("새문서");
		iframe.getContentPane().setBackground(Color.white);
		iframe.getContentPane().add(imageLabel);
		if(cnt == 1) iframe.setSize(200, 200);
		else iframe.setBounds((cnt-1)*20, (cnt-1)*20, 200, 200);
		cnt++;
		desktop.add(iframe);
		iframe.setVisible(true);
	}

	public void closeFrame() {
		JInternalFrame iframe = desktop.getSelectedFrame();
		if(iframe == null) return;
		iframe.setVisible(true);
		iframe.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == openItem) openFrame();
		else if(obj == closeItem) closeFrame();
		else if(obj == exitItem) {
			setVisible(true);
			dispose();
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new JInternalFrameEx();
	}
}
