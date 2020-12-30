package lee.java.exam09;

import java.awt.*;
import java.awt.event.*;

public class MouseEventEx extends Frame implements MouseListener {
	private static final long serialVersionUID = 1L;
	private Button btConfirm = new Button("Ȯ��");
	private Button btCancel = new Button("���");
	
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
			System.out.println("Ȯ�ι�ư");
		else if(e.getSource() == btCancel)
			System.out.println("��ҹ�ư");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == btCancel) 
			System.out.println("��ҹ�ư ������..");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource() == btCancel) 
			System.out.println("��ҹ�ư ������ ����..");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btCancel || e.getSource() == btConfirm)
			System.out.println("���콺�� ��ư ���� ������..");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == btCancel || e.getSource() == btConfirm)
			System.out.println("���콺�� ��ư���� �����Դ�..");
	}

	public static void main(String[] args) {
		new MouseEventEx();
	}

}
