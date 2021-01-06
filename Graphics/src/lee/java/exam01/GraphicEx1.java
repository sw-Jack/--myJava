package lee.java.exam01;

import java.awt.*;
import java.awt.event.*;

public class GraphicEx1 extends Frame 
	implements MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;
	private int x; private int y;
	private int w; private int h;
	
	public GraphicEx1() {
		super("GraphicEx");
		addMouseListener(this);
		addMouseMotionListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setSize(500,400);
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		if(w>x && h>y)
			g.drawOval(x, y, w-x, h-y);
		else if(w>x && h<y)
			g.drawOval(x, h, w-x, y-h);
		else if(w<x && h<y)
			g.fillOval(w, h, x-w, y-h);
		else if(w<x && h>y)
			g.drawOval(w, y, x-w, h-y);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(e.getSource() == this) {
			w = e.getX();
			h = e.getY();
			repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == this) {
			x = e.getX();
			y = e.getY();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource() == this) {
			w = e.getX();
			h = e.getY();
			repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
	public static void main(String[] args) {
		new GraphicEx1();
	}
}
 