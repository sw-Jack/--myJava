package lee.java.exam12;
import java.awt.*;

// //AWT - Dialog
public class DialogEx extends Frame {
	// [멤버]
	// Dialog 객체 소유자 : this, Dialog Title : "조회서비스", 모달리스(false)
	private Dialog dialog = new Dialog(this, "조회서비스", false);
	// 레이블 생성
	private Label lab = new Label("  비밀번호 찾기");
	private Label lab1 = new Label("이름", Label.RIGHT);
	private Label lab2 = new Label("주민번호", Label.RIGHT);
	private Label lab3 = new Label("-", Label.CENTER);

	// 텍스트 필드 생성
	private TextField tf1 = new TextField(20); // 이름 텍스트
	private TextField tf2 = new TextField(6); // 주민번호 앞자리  텍스트
	private TextField tf3 = new TextField(7); // 주민번호 뒷자리 텍스트
	// 버튼 생성
	private Button bt1 = new Button("찾기");
	private Button bt2 = new Button("취소");
	
	// [생성자]
	public DialogEx() {
		super("DialogEx");
		// Dialog 적용
		setDialog();
		setSize(300,200); // Frame 에 적용 
		dialog.setVisible(true); // Frame 에 적용 
	}
	
	// [메서드]
	public void setDialog() {
		// 상부
		dialog.setLayout(new BorderLayout());
		dialog.add("North", lab); // 상부 적용
		
		// 중부
		// panel1 이 중부 판
		Panel panel1 = new Panel(new BorderLayout());
		
		Panel panel2 = new Panel(new GridLayout(2,1));
		panel2.add(lab1);
		panel2.add(lab2);
		panel1.add("West", panel2); // 전체 중 중부 판인 panel1의 West에 panel2 부착
		
		Panel panel3 = new Panel(new GridLayout(2,1));
		Panel tfPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
		tfPanel.add(tf1);
		panel3.add(tfPanel);
		
		Panel panel4 = new Panel(new FlowLayout(FlowLayout.LEFT));
		panel4.add(tf2);
		panel4.add(lab3);
		panel4.add(tf3);
		panel3.add(panel4);
		
		panel1.add("Center", panel3); // 전체 중 중부 판인 panel1의 Center에 panel3 부착
		dialog.add("Center", panel1); // 중부 적용
		
		// 하부
		Panel panel = new Panel(new FlowLayout());
		panel.add(bt1);
		panel.add(bt2);
		dialog.add("South", panel); // 하부 적용
		
		dialog.setSize(260,130); // Dialog 에 적용 
		dialog.setResizable(false); // Dialog 에 적용
	}
	
	public static void main(String[] args) {
		DialogEx dialogEx = new DialogEx();
	}
}
