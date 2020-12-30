package lee.java.exam10;

import java.awt.*;
import java.awt.event.*;

// MouseMotion Event Ȱ��  : ���콺 ��ǥ �� �˾Ƴ���
public class MouseMotionEventEx extends Frame implements MouseMotionListener {
	private static final long serialVersionUID = 1L;

	public MouseMotionEventEx() {
		super("MouseMotionEx");
		addMouseMotionListener(this);
		setSize(300,200);
		setVisible(true);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(e.getSource() == this) 
			System.out.println("X = " + e.getX() + ", Y = " + e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(e.getSource() == this) 
			System.out.println("X = " + e.getX() + ", Y = " + e.getY());
	}

	public static void main(String[] args) {
		new MouseMotionEventEx();
	}

}
