package lee.java.exam09;

import java.awt.*;
import java.awt.event.*;

public class MouseEventEx extends Frame implements MouseListener {
	private static final long serialVersionUID = 1L;
	private Button btConfirm = new Button("확인");
	private Button btCancel = new Button("취소");
	
	public MouseEventEx() {
		super("MouseEventEx");
		setLayout(new FlowLayout());
		add(btConfirm);
		add(btCancel);
		setEvent();
		setSize(300,200);
		setVisible(true);
	}
	public void setEvent() {
		btConfirm.addMouseListener(this);
		btCancel.addMouseListener(this);	
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == btConfirm) 
			System.out.println("확인버튼");
		else if(e.getSource() == btCancel)
			System.out.println("취소버튼");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == btCancel) 
			System.out.println("취소버튼 눌렀당..");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource() == btCancel) 
			System.out.println("취소버튼 눌렀당 땟당..");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btCancel || e.getSource() == btConfirm)
			System.out.println("마우스가 버튼 위에 있지롱..");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == btCancel || e.getSource() == btConfirm)
			System.out.println("마우스가 버튼에서 내려왔당..");
	}

	public static void main(String[] args) {
		new MouseEventEx();
	}

}
