import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class RunTimeApplet extends Applet {
	private static int initNum = 0;
	private static int startNum = 0;
	private static int stopNum = 0;
	private static int paintNum = 0;
	private Label lab = new Label("다음과 같이 실행");

	public void init() { // 생성자 대신
		setLayout(new  BorderLayout());
		setBackground(Color.white);
		add("North", lab);
		initNum++;
	}

	public void start() { // 이벤트, 스레드 처리
		startNum++;
	}

	public void paint(Graphics g) {
		paintNum++;
		g.setFont(new Font("TimeRoman", Font.BOLD, 20));
		g.setColor(Color.black);
		g.drawString("init", 30, 80);		
		g.drawString("start", 30, 150);		
		g.drawString("paint", 30, 220);		
		g.drawString("stop", 30, 290);		
		// 선 그리기
		g.setColor(Color.black);
		g.drawLine(100, 50, 100, 340);
		g.drawLine(100, 340, 380, 340);
        // 세부 눈금 그리기
		g.setColor(Color.lightGray);
		for(int i=125; i<380; i+=25) {
			g.drawLine(i, 50, i, 340);
		}
		// 막대 그래프 그리기
		// init 그리기
		g.setColor(Color.red);
		g.fillRect(100, 70, initNum*25, 30);
		// start 그리기
		g.setColor(Color.green);
		g.fillRect(100, 140, startNum*25, 30);
		// paint 그리기
		g.setColor(Color.blue);
		g.fillRect(100, 210, paintNum*25, 30);
		// stop 그리기
		g.setColor(Color.magenta);
		g.fillRect(100, 280, stopNum*25, 30);
	}
	
	public void stop() {
		stopNum++;
	}

	public void destroy() {
	}
}

				
