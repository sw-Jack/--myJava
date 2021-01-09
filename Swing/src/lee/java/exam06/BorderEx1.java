package lee.java.exam06;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

public class BorderEx1 extends JFrame {
	private static final long serialVersionUID = 1L;

	private JButton[] jb = new JButton[6];
	
	public BorderEx1() {
		super("Test");
		setLayout(new GridLayout(3,2,5,5));
		for(int i=0; i<6; i++) {
			jb[i] = new JButton((i+1) + "¹ø ¹öÆ°");
			add(jb[i]);
		}
		EmptyBorder eb = new EmptyBorder(10,10,10,10);
		jb[0].setBorder(eb);
		
		LineBorder lb = new LineBorder(Color.red, 5);
		jb[1].setBorder(lb);
		
		EtchedBorder etb = new EtchedBorder();
		jb[2].setBorder(etb);
		
		BevelBorder bb = new BevelBorder(BevelBorder.RAISED);
		jb[3].setBorder(bb);
		
		SoftBevelBorder sbb = new SoftBevelBorder(SoftBevelBorder.LOWERED);
		jb[4].setBorder(sbb);
		
		MatteBorder mb = new MatteBorder(5, 10, 15, 20, Color.green);
		jb[5].setBorder(mb);
		setSize(300,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BorderEx1();
	}
}
