package lee.java.exam15;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class JFileChooserEx extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JButton openButton, saveButton;
	private JTextArea log;
	private JFileChooser fc;
	
	public JFileChooserEx() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("FileChooser Å×½ºÆ®");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		log = new JTextArea(5, 20);
		log.setMargin(new Insets(5,5,5,5));
		JScrollPane logScrollPane = new JScrollPane(log);
		fc = new JFileChooser();
		openButton = new JButton("Open");
		saveButton = new JButton("save");
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(openButton);
		buttonPanel.add(saveButton);
		add(buttonPanel, BorderLayout.NORTH);
		add(logScrollPane, BorderLayout.CENTER);
		frame.add(this);
		frame.pack();
		frame.setLocation(300,300);
		frame.setVisible(true);
		openButton.addActionListener(this);
		saveButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == openButton) {
			int returnVal = fc.showOpenDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				log.setText(file.getName() + "\n");
			}
		} else if(e.getSource() == saveButton) {
			int returnVal = fc.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				log.setText(file.getName() + "\n");
			}
		}
	}

	public static void main(String[] args) {
		new JFileChooserEx();
	}
}
