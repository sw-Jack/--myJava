package lee.java.exam12;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class MultiClient implements ActionListener {
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	
	// GUI
	private JFrame jFrame;
	private JTextField jTextField;
	private JTextArea jTextArea;
	private JLabel jlab1, jlab2;
	private JPanel jPanel1, jPanel2;
	private JButton jButton;
	
	private String ip;
	private String id;
	
	public MultiClient(String argIp, String argId) {
		System.out.println("[클라이언트]");
		
		ip = argIp;
		id = argId;
		
		// GUI
		jFrame = new JFrame("Latte Chatt");
		jTextField = new JTextField(30);
		jTextArea = new JTextArea("", 10, 50);
		jlab1 = new JLabel("Usage ID : [" + id + "]");
		jlab2 = new JLabel("IP : " + ip);
		jButton = new JButton("종료");
		jPanel1 = new JPanel();
		jPanel2 = new JPanel();
		jlab1.setBackground(Color.yellow);
		jlab2.setBackground(Color.green);
		jTextField.setBackground(Color.pink);
		
		jPanel1.setLayout(new BorderLayout());
		jPanel2.setLayout(new BorderLayout());
		jPanel1.add(jButton, BorderLayout.EAST);
		jPanel1.add(jTextField, BorderLayout.CENTER);
		jPanel2.add(jlab1, BorderLayout.CENTER);
		jPanel2.add(jlab2, BorderLayout.EAST);		
		jFrame.add(jPanel1, BorderLayout.SOUTH);
		jFrame.add(jPanel2, BorderLayout.NORTH);
		
		JScrollPane jsp = new JScrollPane(jTextArea,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	
		jFrame.add(jsp, BorderLayout.CENTER);
		
		jTextField.addActionListener(this);
		jButton.addActionListener(this);
		jFrame.addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent e) {
				try {
					oos.writeObject(id + "#exit");
				} catch(IOException ee) {
					ee.printStackTrace();
				}
				System.exit(0);
			}
			public void windowOpened(WindowEvent e) {
				jTextField.requestFocus();
			}
		});
		
		jTextField.setEditable(false);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension d = toolkit.getScreenSize();
		int scrHeight = d.height;
		int scrWidth = d.width;
		jFrame.pack();
		jFrame.setLocation((scrWidth-jFrame.getWidth())/2,
						(scrHeight-jFrame.getHeight())/2);
		jFrame.setResizable(false);
		jFrame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String msg = jTextField.getText();
		if(obj == jTextField) {
			if(msg == null || msg.length() == 0) {
				JOptionPane.showMessageDialog(jFrame, 
						"글을 쓰세요", "경고", JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					oos.writeObject(id + "#" + msg);
				} catch(IOException ee) {
					ee.printStackTrace();
				}
				jTextField.setText("");
			} 
		} else if(obj == jButton) {
			try {
				oos.writeObject(id + "#exit");
			} catch(IOException ee) {
				ee.printStackTrace();
			}
			System.exit(0);
		}
	}
	
	public void exit() {
		System.exit(0);
	}
	
	public void init() throws IOException {
		socket = new Socket(ip, 5000);
		System.out.println("#서버와 연결됨");
		oos = new ObjectOutputStream(socket.getOutputStream());
		ois = new ObjectInputStream(socket.getInputStream());
		MultiClientThread clientThread = new MultiClientThread(this);
		Thread thread = new Thread(clientThread);
		thread.start();
	}
	
	public ObjectInputStream getOis() { 
		return ois;
	}
	
	public JTextArea getJTextArea() {
		return jTextArea;
	}
	
	public String getId() {
		return id;
	}
	
	public static void main(String[] args) throws IOException {
		JFrame.setDefaultLookAndFeelDecorated(true);
		MultiClient multiClient = new MultiClient(args[0], args[1]);
		multiClient.init();
	}
}
