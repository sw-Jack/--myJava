package lee.java.exam10;
import java.awt.*;

// AWT - CheckboxGroup
public class CheckboxGroupEx extends Frame {

	GridLayout gl = new GridLayout(4,1);
	Label lab = new Label("������?");
	CheckboxGroup cg = new CheckboxGroup();
	Checkbox man = new Checkbox("����", cg, true);
	Checkbox woman = new Checkbox("����", cg, false);
	Button bt = new Button("Ȯ��");
	
	public CheckboxGroupEx() {
		super("CheckboxGroup");
		setLayout(gl);
		add(lab);
		add(man);
		add(woman);
		add(bt);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		CheckboxGroupEx cg = new CheckboxGroupEx();
	}

}
