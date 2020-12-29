package lee.java.exam08;
import java.awt.*;

// AWT - Choice
public class ChoiceEx extends Frame {

	private Label lab = new Label("»ýÀÏ");
	private Choice ch = new Choice();
	private Button bt = new Button();
	
	public ChoiceEx() {
		super("Choice");
		setLayout(new GridLayout(3,1));
		add(lab);
		for(int i=1; i<=12; i++) {
			ch.add(String.valueOf(i) + "¿ù");
		}
		add(ch);
		add(bt);
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		ChoiceEx choice = new ChoiceEx();
	}

}
