package lee.java.exam11;
import java.awt.*;

// 메뉴와 Panel 활용 예제
public class MenuEx extends Frame {
	// [멤버]
	// 메뉴바 생성
	private MenuBar menuBar = new MenuBar(); 
	// (메뉴바에 붙일) 메뉴 생성
	private Menu file = new Menu("파일"); 
	private Menu tool = new Menu("도구");
	private Menu view = new Menu("보기");
	private Menu help = new Menu("도움말");
	// (메뉴에 붙일) 메뉴 아이템 생성
	private MenuItem newFile = new MenuItem("새파일"); // 파일 아래
	private MenuItem openFile = new MenuItem("파일 열기"); // 파일 아래
	private MenuItem saveFile = new MenuItem("파일 저장"); // 파일 아래
	private MenuItem saveasFile  = new MenuItem("다른이름으로 저장"); // 파일 아래
	private MenuItem exitFile = new MenuItem("나가기"); // 파일 아래
	
	// 체크박스 메뉴 생성
	private Menu mColor = new Menu("색상");
	private Menu mSize = new Menu("크기");
	// (체크박스 메뉴에 붙일) 체크박스 메뉴 아이템 생성
	CheckboxMenuItem mcRed = new CheckboxMenuItem("빨강"); // 색상 아래
	CheckboxMenuItem mcGreen = new CheckboxMenuItem("초록"); // 색상 아래
	CheckboxMenuItem mcBlue = new CheckboxMenuItem("파랑"); // 색상 아래
	CheckboxMenuItem ms10 = new CheckboxMenuItem("10"); // 크기 아래
	CheckboxMenuItem ms20 = new CheckboxMenuItem("20"); // 크기 아래
	CheckboxMenuItem ms30 = new CheckboxMenuItem("30"); // 크기 아래
	
	// [생성자]
	public MenuEx() {
		// 창 제목(Title)
		super("Menu Test"); 
		// 메뉴바 적용
		setMenuBar(menuBar); 
		// 메뉴바에 메뉴 적용
		menuBar.add(file); // 파일
		menuBar.add(tool); // 도구	
		menuBar.add(view); // 보기
		menuBar.add(help); // 도움말
		// 체크박스 메뉴에 체크박스 메뉴 아이템 적용
		mColor.add(mcRed); // 색상 - 빨강
		mColor.add(mcGreen); // 색상 - 초록
		mColor.add(mcBlue); // 색상 - 파랑
		mSize.add(ms10); // 크기 - 10
		mSize.add(ms20); // 크기 - 20
		mSize.add(ms30);// 크기 - 30
		// 적용해놓은 메뉴 아래 체크박스 메뉴 적용
		tool.add(mColor); // 도구 - 색상
		tool.addSeparator(); // 구분선
		tool.add(mSize); // 도구 - 크기
		// 적용해놓은 메뉴 아래 메뉴 적용
		file.add(newFile); // 파일  - 새파일
		file.addSeparator();
		file.add(openFile); // 파일  - 파일 열기
		file.addSeparator();
		file.add(saveFile); // 파일  - 파일 저장
		file.addSeparator();
		file.add(saveasFile); // 파일  - 다른이름으로 저장
		file.addSeparator();
		file.add(exitFile); // 파일  - 나가기
 
		// 레이아웃 설정
		setLayout(new BorderLayout());
		add("North", new Label("메모장", Label.CENTER));
		add("Center", new TextArea());
		
		// 패널 생성 - 패널에 버튼 두개를 붙여 그룹짓고 그 패널을 다시 (메인)frame에 붙이는 경우 
		Panel panel = new Panel(new GridLayout(1,2));
		panel.add(new Button("확인"));
		panel.add(new Button("취소"));
		add("South", panel);
		setSize(300,200);
		setVisible(true);		
	}
	
	public static void main(String[] args) {
		MenuEx menuEx = new MenuEx();
	}

}
