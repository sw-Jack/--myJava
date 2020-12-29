package lee.java.exam14;
import java.awt.*;

// AWT Ȱ�� final �ǽ� - �������� �м� ���α׷�
public class UsingAWT extends Frame {
	// [���]
	// �޴���
	private MenuBar menuBar = new MenuBar();
	// �޴�
	private Menu file = new Menu("����"); // ���� �޴�
	private Menu help = new Menu("����"); // ���� �޴�
	// �޴� ������
	private MenuItem newFile = new MenuItem("�� ����");
	private MenuItem loadFile = new MenuItem("�ҷ�����");
	private MenuItem saveFile = new MenuItem("����");
	private MenuItem saveasFile = new MenuItem("�ٸ� �̸����� ����");
	private MenuItem closeFile = new MenuItem("����");
	
	// <panel1>
	// ���̺�
	private Label labInput = new Label("���������Է�", Label.CENTER);
	private Label labName = new Label("��        ��", Label.CENTER);
	private Label labIdnum = new Label("�ֹι�ȣ", Label.CENTER);
	private Label labPhone = new Label("��ȭ��ȣ", Label.CENTER);
	private Label labSex = new Label("��        ��", Label.CENTER);
	private Label labHobby = new Label("��        ��", Label.CENTER);
	
	private Label lab1 = new Label("-", Label.CENTER);
	private Label lab2 = new Label("-", Label.CENTER);
	private Label lab3 = new Label("-", Label.CENTER);
	// �ؽ�Ʈ �ʵ�
	private TextField tfName = new TextField(20); 
	private TextField tfIdnumFront = new TextField(6);
	private TextField tfIdnumBack = new TextField(7);
	private TextField tfPhoneFront = new TextField(4);
	private TextField tfPhoneBack = new TextField(4);
	// ���̽�
	Choice choicePhone = new Choice();
	// üũ�ڽ� �׷�
	CheckboxGroup checkboxGroupSex = new CheckboxGroup();
	// üũ�ڽ�
	Checkbox checkboxMan = new Checkbox("����", checkboxGroupSex, true);
	Checkbox checkboxWoman = new Checkbox("����", checkboxGroupSex, false);
	Checkbox[] checkboxHobby = {new Checkbox("����"), new Checkbox("��ȭ"),
			new Checkbox("����"), new Checkbox("����"), new Checkbox("����")};
	// ��ư
	String[] str = {"���", "�м�", "����", "����", "�����"};
	Button[] bts = new Button[str.length];
	//Button btEnroll = new Button("���");
	//Button btAnalysis = new Button("�м�");
	//Button btUpdate = new Button("����");
	//Button btDelete = new Button("����");
	//Button btErase = new Button("�����");
	
	// <panel2>
	// ���̺�
	private Label labAllList = new Label("��ü ���", Label.CENTER);
	// ����Ʈ
	private List list = new List(11, true);
	
	// <panel3>
	// ���̺�
	private Label labAnalysisResult = new Label("���������м�", Label.CENTER);
	// �ؽ�Ʈ������
	TextArea textArea = new TextArea();
	
	
	// [������]
	public UsingAWT() {
		super("Friend Manager");
		setMenu();
		setPanel();
		setBackground(Color.cyan);
		setSize(550,500);
		setVisible(true);
	}
	
	// [�޼���]
	// �г� ���� �� ���� �޼���
	public void setPanel() {
		// �� �� panel
		Panel panel = new Panel(new BorderLayout());
		
		// <panel1>
		Panel panel1 = new Panel(new BorderLayout());
		// panel1�� �Ϻ�
		panel1.add("North", labInput);
		
		// panel1�� �߾Ӻ� : panel1_C
		Panel panel1_C = new Panel(new BorderLayout());
		// panel1�� �߾Ӻ��� ���� : panel1_C_W
		Panel panel1_C_W = new Panel();
		panel1_C.add("West", panel1_C_W);
		
		// panel1�� �߾Ӻ��� �ߺ� : panel1_C_C
		Panel panel1_C_C = new Panel(new GridLayout(5,1));
		panel1_C_C.add(labName);
		panel1_C_C.add(labIdnum);
		panel1_C_C.add(labPhone);
		panel1_C_C.add(labSex);
		panel1_C_C.add(labHobby);
		panel1_C.add("Center", panel1_C_C);
		// panel1�� �߾Ӻ��� ���� : panel1_C_E
		Panel panel1_C_E = new Panel(new GridLayout(5,1));
		// �̸� �� (1,1)
		Panel tfNamePanel = new Panel(new FlowLayout(FlowLayout.LEFT));
		tfNamePanel.add(tfName);
		panel1_C_E.add(tfNamePanel);
		// �ֹι�ȣ �� (2,1)
		Panel tfIdnumPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
		tfIdnumPanel.add(tfIdnumFront);
		tfIdnumPanel.add(lab1);
		tfIdnumPanel.add(tfIdnumBack);
		panel1_C_E.add(tfIdnumPanel);
		// ��ȭ��ȣ �� (3,1)
		Panel tfPhonePanel = new Panel(new FlowLayout(FlowLayout.LEFT));
		choicePhone.add("010"); choicePhone.add("011"); choicePhone.add("016");
		choicePhone.add("017"); choicePhone.add("019");
		tfPhonePanel.add(choicePhone);
		tfPhonePanel.add(lab2);
		tfPhonePanel.add(tfPhoneFront);
		tfPhonePanel.add(lab3);
		tfPhonePanel.add(tfPhoneBack);
		panel1_C_E.add(tfPhonePanel);
		// ���� �� (4,1)
		Panel checkboxGroupSexPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
		checkboxGroupSexPanel.add(checkboxMan);
		checkboxGroupSexPanel.add(checkboxWoman);
		panel1_C_E.add(checkboxGroupSexPanel);
		// ��� �� (5,1)
		Panel checkboxHobbyPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
		for(int i=0; i<5; i++) {
			checkboxHobbyPanel.add(checkboxHobby[i]);
		}
		panel1_C_E.add(checkboxHobbyPanel);
		panel1_C.add("East", panel1_C_E); 
		panel1.add("Center", panel1_C);


		// panel1�� �Ϻ� 
		Panel panel1_C_S = new Panel(new FlowLayout(FlowLayout.CENTER));
		for(int i=0; i<str.length; i++) {
			bts[i] = new Button(str[i]);
			panel1_C_S.add(bts[i]);
		}
		panel1.add("South", panel1_C_S);
		
		
		// �� �г� panel�� panel1 ����
		panel.add("Center", panel1);
		
		// <panel2>
		Panel panel2 = new Panel(new BorderLayout());
		// panel2�� �Ϻ�
		panel2.add("North", labAllList);
		// panel2�� ����
		list.setFont(new Font("����ü", Font.BOLD, 15));
		panel2.add("South", list);
		// �� �г� panel�� panel2 ����
		panel.add("East", panel2);
		
		// <panel3>
		Panel panel3 = new Panel(new BorderLayout());
		// panel3�� �Ϻ�
		panel3.add("North", labAnalysisResult);
		// panel3�� ����
		panel3.add("South", textArea);
		// �� �г� panel�� panel3 ����
		panel.add("South", panel3);
		
		// �����ӿ� �г� ����
		Panel pE = new Panel();
		Panel pW = new Panel();
		Panel pS = new Panel();
		Panel pN = new Panel();
		add("East", pE);
		add("West", pW);
		add("South", pS);
		add("North", pN);
		add("Center", panel);
	}
	// �޴� ���� �� ���� �޼���
	public void setMenu() {
		setMenuBar(menuBar); // �޴��� ����(����)
		menuBar.add(file); // ���� �޴� ����(����)
		menuBar.add(help); // ���� �޴� ����(����)
		file.add(newFile); // ���� - ������(�޴� ������ ����/����)
		file.addSeparator(); // ���м�
		file.add(loadFile); // ���� - �ҷ�����(�޴� ������ ����/����)
		file.add(saveFile); // ���� - ����(�޴� ������ ����/����)
		file.add(saveasFile); // ���� - �ٸ��̸����� ����(�޴� ������ ����/����)
		file.addSeparator(); // ���м�
		file.add(closeFile); // ���� - ����(�޴� ������ ����/����)
	}
	// ���� �޼���
	public static void main(String[] args) {
		UsingAWT usingAWT = new UsingAWT();
	}
}
