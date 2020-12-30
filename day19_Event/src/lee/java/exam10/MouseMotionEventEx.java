package lee.java.exam10;

import java.awt.*;
import java.awt.event.*;

// MouseMotion Event 활용  : 마우스 좌표 값 알아내기
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
