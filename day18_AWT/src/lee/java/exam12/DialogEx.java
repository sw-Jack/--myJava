package lee.java.exam12;
import java.awt.*;

// //AWT - Dialog
public class DialogEx extends Frame {
	// [���]
	// Dialog ��ü ������ : this, Dialog Title : "��ȸ����", ��޸���(false)
	private Dialog dialog = new Dialog(this, "��ȸ����", false);
	// ���̺� ����
	private Label lab = new Label("  ��й�ȣ ã��");
	private Label lab1 = new Label("�̸�", Label.RIGHT);
	private Label lab2 = new Label("�ֹι�ȣ", Label.RIGHT);
	private Label lab3 = new Label("-", Label.CENTER);

	// �ؽ�Ʈ �ʵ� ����
	private TextField tf1 = new TextField(20); // �̸� �ؽ�Ʈ
	private TextField tf2 = new TextField(6); // �ֹι�ȣ ���ڸ�  �ؽ�Ʈ
	private TextField tf3 = new TextField(7); // �ֹι�ȣ ���ڸ� �ؽ�Ʈ
	// ��ư ����
	private Button bt1 = new Button("ã��");
	private Button bt2 = new Button("���");
	
	// [������]
	public DialogEx() {
		super("DialogEx");
		// Dialog ����
		setDialog();
		setSize(300,200); // Frame �� ���� 
		dialog.setVisible(true); // Frame �� ���� 
	}
	
	// [�޼���]
	public void setDialog() {
		// ���
		dialog.setLayout(new BorderLayout());
		dialog.add("North", lab); // ��� ����
		
		// �ߺ�
		// panel1 �� �ߺ� ��
		Panel panel1 = new Panel(new BorderLayout());
		
		Panel panel2 = new Panel(new GridLayout(2,1));
		panel2.add(lab1);
		panel2.add(lab2);
		panel1.add("West", panel2); // ��ü �� �ߺ� ���� panel1�� West�� panel2 ����
		
		Panel panel3 = new Panel(new GridLayout(2,1));
		Panel tfPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
		tfPanel.add(tf1);
		panel3.add(tfPanel);
		
		Panel panel4 = new Panel(new FlowLayout(FlowLayout.LEFT));
		panel4.add(tf2);
		panel4.add(lab3);
		panel4.add(tf3);
		panel3.add(panel4);
		
		panel1.add("Center", panel3); // ��ü �� �ߺ� ���� panel1�� Center�� panel3 ����
		dialog.add("Center", panel1); // �ߺ� ����
		
		// �Ϻ�
		Panel panel = new Panel(new FlowLayout());
		panel.add(bt1);
		panel.add(bt2);
		dialog.add("South", panel); // �Ϻ� ����
		
		dialog.setSize(260,130); // Dialog �� ���� 
		dialog.setResizable(false); // Dialog �� ����
	}
	
	public static void main(String[] args) {
		DialogEx dialogEx = new DialogEx();
	}
}
