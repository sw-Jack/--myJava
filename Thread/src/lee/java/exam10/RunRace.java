package lee.java.exam10;

import java.awt.*;
import java.awt.event.*;

// <경마 게임> - 게임을 실행시킬 main Frame 
public class RunRace extends Frame implements ActionListener {

	private Button bt = new Button("출발");
	private int count;
	private Racer[] racer;
	
	public RunRace(int k, String[] hn) {
		super("말 경주");
		count = k;
		setLayout(new BorderLayout());
		racer = new Racer[count];
		Panel p = new Panel(new GridLayout(count, 1));
		for(int i=0; i<count; i++) {
			racer[i] = new Racer(hn[i+1]);
			p.add(racer[i]);
		}
		add("Center", p);
		Panel p1 = new Panel(new FlowLayout(FlowLayout.RIGHT));
		p1.add(bt);
		bt.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		add("South", p1);
		setSize(600,400);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bt) {
			Thread[] th = new Thread[count];
			for(int i=0; i<count; i++) {
				th[i] = new Thread(racer[i]);
				th[i].setName(racer[i].return_name());
				th[i].setPriority((int)(Math.random() * 10) + 1);
			}
			for(int i=0; i<count; i++) {
				th[i].start();
			}
		}
	}

	public static void main(String[] args) {
		if(args.length < 2) {
			System.out.println("[Usage] \"java RunRace count name1, ... \"");
			System.exit(0);
		}
		int xx = Integer.parseInt(args[0]);
		if(xx+1 != args.length) {
			System.out.println("[Error] count is not equal to name count!");
			System.exit(0);
		}
		RunRace r = new RunRace(xx,args);
	}
}
