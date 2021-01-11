package lee.java.exam13;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JOptionPaneEx extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JButton b1, b2, b3, b4;
	private String[] str = {"로그인", "회원가입"};
	
	public JOptionPaneEx() {
		super("JOptionPane 테스트");
		setLayout(new FlowLayout());
		b1 = new JButton("MessageDialog");
		b2 = new JButton("ConfirmDialog");
		b3 = new JButton("InputDialog");
		b4 = new JButton("OptionDialog");
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		pack();
		setLocation(300,300);
		setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			JOptionPane.showMessageDialog(this, "메세지 다이얼로그 박스", "메세지",
									JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == b2) {
			JOptionPane.showConfirmDialog(this, "확인 다이얼로그 박스", "확인",
									JOptionPane.YES_NO_CANCEL_OPTION);
		}
		else if(e.getSource() == b3) {
			JOptionPane.showInputDialog(this, "입력 다이얼로그 박스", "입력",
									JOptionPane.YES_NO_OPTION);
		}
		else if(e.getSource() == b4) {
			JOptionPane.showOptionDialog(this, "옵션 다이얼로그 박스", "옵션",
									JOptionPane.YES_NO_CANCEL_OPTION,
									JOptionPane.INFORMATION_MESSAGE,
									null, str, str[0]);
		}
		
	}

	public static void main(String[] args) {
		new JOptionPaneEx();
	}
}
