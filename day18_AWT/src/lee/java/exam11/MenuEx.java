package lee.java.exam11;
import java.awt.*;

// �޴��� Panel Ȱ�� ����
public class MenuEx extends Frame {
	// [���]
	// �޴��� ����
	private MenuBar menuBar = new MenuBar(); 
	// (�޴��ٿ� ����) �޴� ����
	private Menu file = new Menu("����"); 
	private Menu tool = new Menu("����");
	private Menu view = new Menu("����");
	private Menu help = new Menu("����");
	// (�޴��� ����) �޴� ������ ����
	private MenuItem newFile = new MenuItem("������"); // ���� �Ʒ�
	private MenuItem openFile = new MenuItem("���� ����"); // ���� �Ʒ�
	private MenuItem saveFile = new MenuItem("���� ����"); // ���� �Ʒ�
	private MenuItem saveasFile  = new MenuItem("�ٸ��̸����� ����"); // ���� �Ʒ�
	private MenuItem exitFile = new MenuItem("������"); // ���� �Ʒ�
	
	// üũ�ڽ� �޴� ����
	private Menu mColor = new Menu("����");
	private Menu mSize = new Menu("ũ��");
	// (üũ�ڽ� �޴��� ����) üũ�ڽ� �޴� ������ ����
	CheckboxMenuItem mcRed = new CheckboxMenuItem("����"); // ���� �Ʒ�
	CheckboxMenuItem mcGreen = new CheckboxMenuItem("�ʷ�"); // ���� �Ʒ�
	CheckboxMenuItem mcBlue = new CheckboxMenuItem("�Ķ�"); // ���� �Ʒ�
	CheckboxMenuItem ms10 = new CheckboxMenuItem("10"); // ũ�� �Ʒ�
	CheckboxMenuItem ms20 = new CheckboxMenuItem("20"); // ũ�� �Ʒ�
	CheckboxMenuItem ms30 = new CheckboxMenuItem("30"); // ũ�� �Ʒ�
	
	// [������]
	public MenuEx() {
		// â ����(Title)
		super("Menu Test"); 
		// �޴��� ����
		setMenuBar(menuBar); 
		// �޴��ٿ� �޴� ����
		menuBar.add(file); // ����
		menuBar.add(tool); // ����	
		menuBar.add(view); // ����
		menuBar.add(help); // ����
		// üũ�ڽ� �޴��� üũ�ڽ� �޴� ������ ����
		mColor.add(mcRed); // ���� - ����
		mColor.add(mcGreen); // ���� - �ʷ�
		mColor.add(mcBlue); // ���� - �Ķ�
		mSize.add(ms10); // ũ�� - 10
		mSize.add(ms20); // ũ�� - 20
		mSize.add(ms30);// ũ�� - 30
		// �����س��� �޴� �Ʒ� üũ�ڽ� �޴� ����
		tool.add(mColor); // ���� - ����
		tool.addSeparator(); // ���м�
		tool.add(mSize); // ���� - ũ��
		// �����س��� �޴� �Ʒ� �޴� ����
		file.add(newFile); // ����  - ������
		file.addSeparator();
		file.add(openFile); // ����  - ���� ����
		file.addSeparator();
		file.add(saveFile); // ����  - ���� ����
		file.addSeparator();
		file.add(saveasFile); // ����  - �ٸ��̸����� ����
		file.addSeparator();
		file.add(exitFile); // ����  - ������
 
		// ���̾ƿ� ����
		setLayout(new BorderLayout());
		add("North", new Label("�޸���", Label.CENTER));
		add("Center", new TextArea());
		
		// �г� ���� - �гο� ��ư �ΰ��� �ٿ� �׷����� �� �г��� �ٽ� (����)frame�� ���̴� ��� 
		Panel panel = new Panel(new GridLayout(1,2));
		panel.add(new Button("Ȯ��"));
		panel.add(new Button("���"));
		add("South", panel);
		setSize(300,200);
		setVisible(true);		
	}
	
	public static void main(String[] args) {
		MenuEx menuEx = new MenuEx();
	}

}
