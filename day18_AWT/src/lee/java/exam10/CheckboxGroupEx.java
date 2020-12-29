package lee.java.exam10;
import java.awt.*;

// AWT - CheckboxGroup
public class CheckboxGroupEx extends Frame {

	GridLayout gl = new GridLayout(4,1);
	Label lab = new Label("성별은?");
	CheckboxGroup cg = new CheckboxGroup();
	Checkbox man = new Checkbox("남성", cg, true);
	Checkbox woman = new Checkbox("여성", cg, false);
	Button bt = new Button("확인");
	
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
