package lee.java.exam14;
import java.awt.*;

// AWT 활용 final 실습 - 개인정보 분석 프로그램
public class UsingAWT extends Frame {
	// [멤버]
	// 메뉴바
	private MenuBar menuBar = new MenuBar();
	// 메뉴
	private Menu file = new Menu("파일"); // 파일 메뉴
	private Menu help = new Menu("도움말"); // 도움말 메뉴
	// 메뉴 아이템
	private MenuItem newFile = new MenuItem("새 파일");
	private MenuItem loadFile = new MenuItem("불러오기");
	private MenuItem saveFile = new MenuItem("저장");
	private MenuItem saveasFile = new MenuItem("다른 이름으로 저장");
	private MenuItem closeFile = new MenuItem("종료");
	
	// <panel1>
	// 레이블
	private Label labInput = new Label("개인정보입력", Label.CENTER);
	private Label labName = new Label("이        름", Label.CENTER);
	private Label labIdnum = new Label("주민번호", Label.CENTER);
	private Label labPhone = new Label("전화번호", Label.CENTER);
	private Label labSex = new Label("성        별", Label.CENTER);
	private Label labHobby = new Label("취        미", Label.CENTER);
	
	private Label lab1 = new Label("-", Label.CENTER);
	private Label lab2 = new Label("-", Label.CENTER);
	private Label lab3 = new Label("-", Label.CENTER);
	// 텍스트 필드
	private TextField tfName = new TextField(20); 
	private TextField tfIdnumFront = new TextField(6);
	private TextField tfIdnumBack = new TextField(7);
	private TextField tfPhoneFront = new TextField(4);
	private TextField tfPhoneBack = new TextField(4);
	// 초이스
	Choice choicePhone = new Choice();
	// 체크박스 그룹
	CheckboxGroup checkboxGroupSex = new CheckboxGroup();
	// 체크박스
	Checkbox checkboxMan = new Checkbox("남성", checkboxGroupSex, true);
	Checkbox checkboxWoman = new Checkbox("여성", checkboxGroupSex, false);
	Checkbox[] checkboxHobby = {new Checkbox("독서"), new Checkbox("영화"),
			new Checkbox("음악"), new Checkbox("게임"), new Checkbox("쇼핑")};
	// 버튼
	String[] str = {"등록", "분석", "수정", "삭제", "지우기"};
	Button[] bts = new Button[str.length];
	//Button btEnroll = new Button("등록");
	//Button btAnalysis = new Button("분석");
	//Button btUpdate = new Button("수정");
	//Button btDelete = new Button("삭제");
	//Button btErase = new Button("지우기");
	
	// <panel2>
	// 레이블
	private Label labAllList = new Label("전체 목록", Label.CENTER);
	// 리스트
	private List list = new List(11, true);
	
	// <panel3>
	// 레이블
	private Label labAnalysisResult = new Label("개인정보분석", Label.CENTER);
	// 텍스트에리어
	TextArea textArea = new TextArea();
	
	
	// [생성자]
	public UsingAWT() {
		super("Friend Manager");
		setMenu();
		setPanel();
		setBackground(Color.cyan);
		setSize(550,500);
		setVisible(true);
	}
	
	// [메서드]
	// 패널 설정 및 적용 메서드
	public void setPanel() {
		// 총 판 panel
		Panel panel = new Panel(new BorderLayout());
		
		// <panel1>
		Panel panel1 = new Panel(new BorderLayout());
		// panel1의 북부
		panel1.add("North", labInput);
		
		// panel1의 중앙부 : panel1_C
		Panel panel1_C = new Panel(new BorderLayout());
		// panel1의 중앙부의 서부 : panel1_C_W
		Panel panel1_C_W = new Panel();
		panel1_C.add("West", panel1_C_W);
		
		// panel1의 중앙부의 중부 : panel1_C_C
		Panel panel1_C_C = new Panel(new GridLayout(5,1));
		panel1_C_C.add(labName);
		panel1_C_C.add(labIdnum);
		panel1_C_C.add(labPhone);
		panel1_C_C.add(labSex);
		panel1_C_C.add(labHobby);
		panel1_C.add("Center", panel1_C_C);
		// panel1의 중앙부의 동부 : panel1_C_E
		Panel panel1_C_E = new Panel(new GridLayout(5,1));
		// 이름 층 (1,1)
		Panel tfNamePanel = new Panel(new FlowLayout(FlowLayout.LEFT));
		tfNamePanel.add(tfName);
		panel1_C_E.add(tfNamePanel);
		// 주민번호 층 (2,1)
		Panel tfIdnumPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
		tfIdnumPanel.add(tfIdnumFront);
		tfIdnumPanel.add(lab1);
		tfIdnumPanel.add(tfIdnumBack);
		panel1_C_E.add(tfIdnumPanel);
		// 전화번호 층 (3,1)
		Panel tfPhonePanel = new Panel(new FlowLayout(FlowLayout.LEFT));
		choicePhone.add("010"); choicePhone.add("011"); choicePhone.add("016");
		choicePhone.add("017"); choicePhone.add("019");
		tfPhonePanel.add(choicePhone);
		tfPhonePanel.add(lab2);
		tfPhonePanel.add(tfPhoneFront);
		tfPhonePanel.add(lab3);
		tfPhonePanel.add(tfPhoneBack);
		panel1_C_E.add(tfPhonePanel);
		// 성별 층 (4,1)
		Panel checkboxGroupSexPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
		checkboxGroupSexPanel.add(checkboxMan);
		checkboxGroupSexPanel.add(checkboxWoman);
		panel1_C_E.add(checkboxGroupSexPanel);
		// 취미 층 (5,1)
		Panel checkboxHobbyPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
		for(int i=0; i<5; i++) {
			checkboxHobbyPanel.add(checkboxHobby[i]);
		}
		panel1_C_E.add(checkboxHobbyPanel);
		panel1_C.add("East", panel1_C_E); 
		panel1.add("Center", panel1_C);


		// panel1의 하부 
		Panel panel1_C_S = new Panel(new FlowLayout(FlowLayout.CENTER));
		for(int i=0; i<str.length; i++) {
			bts[i] = new Button(str[i]);
			panel1_C_S.add(bts[i]);
		}
		panel1.add("South", panel1_C_S);
		
		
		// 총 패널 panel에 panel1 적용
		panel.add("Center", panel1);
		
		// <panel2>
		Panel panel2 = new Panel(new BorderLayout());
		// panel2의 북부
		panel2.add("North", labAllList);
		// panel2의 남부
		list.setFont(new Font("굴림체", Font.BOLD, 15));
		panel2.add("South", list);
		// 총 패널 panel에 panel2 적용
		panel.add("East", panel2);
		
		// <panel3>
		Panel panel3 = new Panel(new BorderLayout());
		// panel3의 북부
		panel3.add("North", labAnalysisResult);
		// panel3의 남부
		panel3.add("South", textArea);
		// 총 패널 panel에 panel3 적용
		panel.add("South", panel3);
		
		// 프레임에 패널 적용
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
	// 메뉴 설정 및 적용 메서드
	public void setMenu() {
		setMenuBar(menuBar); // 메뉴바 적용(생성)
		menuBar.add(file); // 파일 메뉴 적용(생성)
		menuBar.add(help); // 도움말 메뉴 적용(생성)
		file.add(newFile); // 파일 - 새파일(메뉴 아이템 적용/생성)
		file.addSeparator(); // 구분선
		file.add(loadFile); // 파일 - 불러오기(메뉴 아이템 적용/생성)
		file.add(saveFile); // 파일 - 저장(메뉴 아이템 적용/생성)
		file.add(saveasFile); // 파일 - 다른이름으로 저장(메뉴 아이템 적용/생성)
		file.addSeparator(); // 구분선
		file.add(closeFile); // 파일 - 종료(메뉴 아이템 적용/생성)
	}
	// 메인 메서드
	public static void main(String[] args) {
		UsingAWT usingAWT = new UsingAWT();
	}
}
