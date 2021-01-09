package lee.java.exam10;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class JSliderEx extends JFrame {
	private static final long serialVersionUID = 1L;

	 JSlider red = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
	 JSlider green = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
	 JSlider blue = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
	 JLabel rgb = new JLabel("RGB(0,0,0)", JLabel.CENTER);
	 JPanel p1 = new JPanel(new BorderLayout());
	 JPanel west = new JPanel(new GridLayout(0,1)); // 0은 가변 길이를 뜻함 
	 JPanel center = new JPanel(new GridLayout(0,1));
	 JPanel p2 = new JPanel();
	 int r, g, b;
	 
	 public JSliderEx() {
		 super("JSlider 테스트");
		 red.setMajorTickSpacing(50);
		 red.setMinorTickSpacing(5);
		 red.setPaintTicks(true);
		 red.setPaintLabels(true);
		 
		 green.setMajorTickSpacing(50);
		 green.setMinorTickSpacing(5);
		 green.setPaintTicks(true);
		 green.setPaintLabels(true);
		 
		 blue.setMajorTickSpacing(50);
		 blue.setMinorTickSpacing(5);
		 blue.setPaintTicks(true);
		 blue.setPaintLabels(true);
		 
		 JLabel redLab = new JLabel("RED");
		 JLabel greenLab = new JLabel("GREEN");
		 JLabel blueLab = new JLabel("BLUE");
		 
		 redLab.setForeground(Color.red);
		 greenLab.setForeground(Color.green);
		 blueLab.setForeground(Color.blue);
		 rgb.setFont(new Font("돋움체", Font.BOLD, 24));
		 
		 west.add(redLab); 
		 west.add(greenLab);
		 west.add(blueLab);
		 center.add(red);
		 center.add(green);
		 center.add(blue);
		 p1.add("West", west);
		 p1.add("Center", center);
		 add("North", rgb); 
		 add("South", p1);
		 add("Center", p2);
		 setBounds(400, 300, 500, 400);
		 setVisible(true);
		 red.addChangeListener(new Sevent());
		 green.addChangeListener(new Sevent());
		 blue.addChangeListener(new Sevent());

	 }
	 
	 class Sevent implements ChangeListener {
		 public void stateChanged(ChangeEvent e) {
			 JSlider source = (JSlider)e.getSource();
			 if(e.getSource() == red) {
				 r = source.getValue();
			 }
			 if(e.getSource() == green) {
				 g = source.getValue();
			 }
			 if(e.getSource() == blue) {
				 b = source.getValue();
			 }
			 p2.setBackground(new Color(r, g, b));
			 rgb.setText("RGB(" + r + "," + g + "," + b + ")");
		 }
	 }
	
	public static void main(String[] args) {
		new JSliderEx();
	}
}
