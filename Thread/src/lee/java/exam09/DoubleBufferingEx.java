package lee.java.exam09;

import java.awt.*;
import java.awt.event.*;

// 더블 버퍼링(Double Buffering) 예제 : 펙맨

public class DoubleBufferingEx extends Frame implements Runnable, KeyListener {
	private static final long serialVersionUID = 1L;
	
	private Image image;
	private int x, y, mx, my, sel;
	private Graphics bufferGraphics;
	private Image bufferImage;
	
	public DoubleBufferingEx() {
		super("더블 버퍼링 테스트");
		image = Toolkit.getDefaultToolkit().getImage("src/image/packman.jpg");
		x = 225;
		y = 225;
		mx = 0;
		my = 0;
		sel = 0;
		Thread th = new Thread(this);
		th.start();
		addKeyListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setBounds(200,200,500,500);
		setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void keyReleased(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			mx = -10;
			my = 0;
			sel = 0;
		} else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			mx = 10;
			my = 0;
			sel = 2;
		} else if(e.getKeyCode() == KeyEvent.VK_UP) {
			mx = 0;
			my = -10;
			sel = 4;
		} else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			mx = 0;
			my = 10;
			sel = 6;
		} else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}

	public void paint(Graphics g) {
		if(bufferImage != null) 
			g.drawImage(bufferImage, 0, 0, this);
	}
	
	public void update(Graphics g) {
		Dimension d = getSize();
		if(bufferGraphics == null) {
			bufferImage = createImage(d.width, d.height); // creating off-screen image
			bufferGraphics = bufferImage.getGraphics();
		}
		bufferGraphics.setColor(getBackground());
		bufferGraphics.fillRect(0, 0, 500, 500);
		bufferGraphics.drawImage(image, x, y, x+50, y+50, sel*50, 0, sel*50+50, 50, this);
		paint(g);
	}

	@Override
	public void run() {
		while(true) {
			x += mx;
			y += my;
			if(sel%2 == 0) sel++;
			else sel--;
			if(x <= -50) x = 500;
			else if(x >= 500) x = 0;
			else if(y <= -50) y = 500;
			else if(y >= 500) y = 0;
			try {
				repaint();
				Thread.sleep(100);
			} catch(Exception e) {}
		}
	}

	public static void main(String[] args) {
		new DoubleBufferingEx();
	}
}
