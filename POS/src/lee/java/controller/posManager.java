package lee.java.controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class posManager extends Frame implements ActionListener {
	// [멤버]
	private static final long serialVersionUID = 1L;

	// panel_N
	// Panel_N_W **
	private CardLayout card1 = new CardLayout();
	private String[] strCard1 = { "메인", "관리자" };
	private Button[] btCard1 = new Button[strCard1.length];
	// Panel_N_C
	// Panel_N_E

	// panel_C
	// Panel_C_N **(테이블 & 메뉴)
	// Panel_C_C **
	// Panel_C_C_W **
	private String[] strTable = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	private Button[] btTable = new Button[strTable.length];
	// Panel_C_C_C **
	// Panel_C_C_C_N
	private CardLayout card2 = new CardLayout();
	private Panel panel_C_right_C_C = new Panel(card2);
	private String[] strCard2 = { "고기", "식사", "주류", "음료" };
	private Button[] btCard2 = new Button[strCard2.length];
	// Panel_C_C_C_C
	private Panel[] panelsCard2 = new Panel[strCard2.length];
	private Label labCowChadol = new Label("차돌박이", Label.LEFT); // 1
	private Label labCowGalbi = new Label("생갈비", Label.LEFT); // 2
	private Label labPigGalbi = new Label("돼지갈비", Label.LEFT); // 3
	private Label labPigSamgyub = new Label("삼겹살", Label.LEFT); // 4
	private Label labKimChijjigae = new Label("김치찌개", Label.LEFT); // 5
	private Label labDoyenJangjjigae = new Label("된장찌개", Label.LEFT); // 6
	private Label labRice = new Label("공기밥", Label.LEFT); // 7
	private Label labSoju = new Label("소주", Label.LEFT); // 8
	private Label labBeer = new Label("맥주", Label.LEFT); // 9
	private Label labCoke = new Label("콜라", Label.LEFT); // 10
	private Label labCyder = new Label("사이다", Label.LEFT); // 11
	// tempPanel_C_E
	private Button btCowChadolAdd = new Button("추가");
	private Button btCowChadolDel = new Button("삭제"); // 1

	private Button btCowGalbiAdd = new Button("추가");
	private Button btCowGalbiDel = new Button("삭제"); // 2

	private Button btPigGalbiAdd = new Button("추가");
	private Button btPigGalbiDel = new Button("삭제"); // 3

	private Button btPigSamgyubAdd = new Button("추가");
	private Button btPigSamgyubDel = new Button("삭제"); // 4

	private Button btKimChijjigaeAdd = new Button("추가");
	private Button btKimChijjigaeDel = new Button("삭제"); // 5

	private Button btDoyenJangjjigaeAdd = new Button("추가");
	private Button btDoyenJangjjigaeDel = new Button("삭제"); // 6

	private Button btRiceAdd = new Button("추가");
	private Button btRiceDel = new Button("삭제"); // 7

	private Button btSojuAdd = new Button("추가");
	private Button btSojuDel = new Button("삭제"); // 8

	private Button btBeerAdd = new Button("추가");
	private Button btBeerDel = new Button("삭제"); // 9

	private Button btCokeAdd = new Button("추가");
	private Button btCokeDel = new Button("삭제"); // 10

	private Button btCyderAdd = new Button("추가");
	private Button btCyderDel = new Button("삭제"); // 11
	// Panel_C_C_C_S
	Button btCompleteOrder = new Button("주문완료");

	// panel_S
	// panel_S_N **(주문 내역 & 결제 내역)
	// panel_S_C
	// panel_S_C_C **
	private Label labOrderList = new Label("주문 내역", Label.CENTER);
	private List list = new List(11, true); // toString
	// panel_S_C_E **
	// panel_S_C_E_C
	private Label labCalcList = new Label("계산 내역", Label.CENTER);
	private Label labTotalOrder = new Label("주문 총액  :", Label.CENTER);
	private Label labTotalPay = new Label("결제 금액  :", Label.CENTER);
	private Label labPoint = new Label("* 포인트 사용  :", Label.CENTER);
	private Label labSymbol = new Label(" : ", Label.CENTER);
	private TextField tfTotalOrder = new TextField(35);
	private TextField tfPoint = new TextField(30);
	private TextField tfTotalPay = new TextField(35);

	// panel_S_C_E_S
	private Button btPay = new Button("결제");
	private Button btCancel = new Button("지우기");

	// [생성자]
	public posManager() {
		super("Store Manager");
		setEvent();
		setGUI();
		card2.show(panel_C_right_C_C, "0");
		setSize(1000, 950);
		setVisible(true);

	}

	// [메서드]
	public void setEvent() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	// 화면 구현
	public void setGUI() {
		// --------------------------------------------------------------------------------------------------------------
		// [총 판넬]
		Panel mainPanel = new Panel(new BorderLayout(3, 3));
		// --------------------------------------------------------------------------------------------------------------

		// --------------------------------------------------------------------------------------------------------------
		// [panel_N]
		Panel panel_N = new Panel(new BorderLayout(3, 3));
		// panel_N_W
		Panel panel_N_W = new Panel(new GridLayout(1, 2));
		for (int i = 0; i < strCard1.length; i++) {
			btCard1[i] = new Button(strCard1[i]);
			panel_N_W.add(btCard1[i]);
		}
		panel_N.add("West", panel_N_W);
		// panel_N_C
		panel_N.add("Center", new Label());
		// panel_N_E
		panel_N.add("East", new Label());
		mainPanel.add("North", panel_N);
		// --------------------------------------------------------------------------------------------------------------

		// --------------------------------------------------------------------------------------------------------------
		// [panel_C]
		Panel panel_C = new Panel(new GridLayout(1, 2, 5, 5)); // panel_C 자체를 반반으로 나눔 (left / right)
		// panel_C_left
		Panel panel_C_left = new Panel(new BorderLayout(5, 5));
		// panel_C_left_N
		Label labTable = new Label("테이블", Label.CENTER);
		labTable.setFont(new Font("Serif", Font.BOLD, 20));
		panel_C_left.add("North", labTable);
		// panel_C_left_C
		Panel panel_C_left_C = new Panel(new GridLayout(3, 3, 5, 5));
		for (int i = 0; i < strTable.length; i++) {
			btTable[i] = new Button(strTable[i]);
			btTable[i].setFont(new Font("Serif", Font.BOLD, 15));
			panel_C_left_C.add(btTable[i]);
		}
		panel_C_left.add("Center", panel_C_left_C);
		panel_C_left.add("East", new Label());
		panel_C_left.add("West", new Label());
		panel_C_left.add("South", new Label());
		panel_C.add(panel_C_left);

		// panel_C_right
		Panel panel_C_right = new Panel(new BorderLayout(5, 5));

		// panel_C_right_N
		Label labMenu = new Label("메뉴", Label.CENTER);
		labMenu.setFont(new Font("Serif", Font.BOLD, 20));
		panel_C_right.add("North", labMenu);

		// panel_C_right_C
		Panel panel_C_right_C = new Panel(new BorderLayout(5, 5));
		panel_C_right_C.setBackground(Color.WHITE);
		// panel_C_right_C_N
		Panel panel_C_right_C_N = new Panel(new GridLayout(1, 4));
		for (int i = 0; i < strCard2.length; i++) {
			btCard2[i] = new Button(strCard2[i]);
			btCard2[i].setFont(new Font("Serif", Font.BOLD, 13));
			btCard2[i].addActionListener(this);
			panel_C_right_C_N.add(btCard2[i]);
		}
		panel_C_right_C.add("North", panel_C_right_C_N);
		// panel_C_right_C_C
		for (int i = 0; i < panelsCard2.length; i++) {
			panelsCard2[i] = new Panel();
			panel_C_right_C_C.add("" + i, panelsCard2[i]);
		}
		// 고기 card
		Panel meat = new Panel(new BorderLayout(10, 10));
		Panel meat_C = new Panel(new GridLayout(4, 1, 5, 5));
		meat_C.add(labCowChadol);
		meat_C.add(labCowGalbi);
		meat_C.add(labPigGalbi);
		meat_C.add(labPigSamgyub);

		Panel meat_E = new Panel(new GridLayout(4, 2, 5, 5));
		meat_E.add(btCowChadolAdd);
		meat_E.add(btCowChadolDel);
		meat_E.add(btCowGalbiAdd);
		meat_E.add(btCowGalbiDel);
		meat_E.add(btPigGalbiAdd);
		meat_E.add(btPigGalbiDel);
		meat_E.add(btPigSamgyubAdd);
		meat_E.add(btPigSamgyubDel);

		meat.add("Center", meat_C);
		meat.add("East", meat_E);
		panelsCard2[0].add(meat);
		panel_C_right_C_C.add("" + 0, panelsCard2[0]);

		// 식사 card
		Panel meal = new Panel(new BorderLayout(3, 3));
		Panel meal_C = new Panel(new GridLayout(3, 1, 5, 5));
		meal_C.add(labKimChijjigae);
		meal_C.add(labDoyenJangjjigae);
		meal_C.add(labRice);

		Panel meal_E = new Panel(new GridLayout(3, 2, 5, 5));
		meal_E.add(btKimChijjigaeAdd);
		meal_E.add(btKimChijjigaeDel);
		meal_E.add(btDoyenJangjjigaeAdd);
		meal_E.add(btDoyenJangjjigaeDel);
		meal_E.add(btRiceAdd);
		meal_E.add(btRiceDel);

		meal.add("Center", meal_C);
		meal.add("East", meal_E);
		panelsCard2[1].add(meal);
		panel_C_right_C_C.add("" + 1, panelsCard2[1]);

		// 주류 card
		Panel alchol = new Panel(new BorderLayout(3, 3));
		Panel alchol_C = new Panel(new GridLayout(2, 1, 5, 5));
		alchol_C.add(labSoju);
		alchol_C.add(labBeer);

		Panel alchol_E = new Panel(new GridLayout(2, 2, 5, 5));
		alchol_E.add(btSojuAdd);
		alchol_E.add(btSojuDel);
		alchol_E.add(btBeerAdd);
		alchol_E.add(btBeerDel);

		alchol.add("Center", alchol_C);
		alchol.add("East", alchol_E);
		panelsCard2[2].add(alchol);
		panel_C_right_C_C.add("" + 2, panelsCard2[2]);

		// 음료 card
		Panel drink = new Panel(new BorderLayout(3, 3));
		Panel drink_C = new Panel(new GridLayout(2, 1, 5, 5));
		drink_C.add(labCoke);
		drink_C.add(labCyder);

		Panel drink_E = new Panel(new GridLayout(2, 2, 5, 5));
		drink_E.add(btCokeAdd);
		drink_E.add(btCokeDel);
		drink_E.add(btCyderAdd);
		drink_E.add(btCyderDel);

		drink.add("Center", drink_C);
		drink.add("East", drink_E);
		panelsCard2[3].add(drink);
		panel_C_right_C_C.add("" + 3, panelsCard2[3]);

		panel_C_right_C.add("Center", panel_C_right_C_C);
		panel_C_right_C.setFont(new Font("Serif", Font.BOLD, 16));
		panel_C_right.add("Center", panel_C_right_C);

		// panel_C_right_S
		Panel panel_C_right_S = new Panel(new GridLayout(3, 1, 7, 7));
		panel_C_right_S.add(new Panel());
		panel_C_right_S.add(btCompleteOrder);
		panel_C_right_S.add(new Panel());
		panel_C_right.add("South", panel_C_right_S);

		// 나머지
		panel_C_right.add("East", new Label());
		panel_C_right.add("West", new Label());

		panel_C.add(panel_C_right);
		mainPanel.add("Center", panel_C);
		// --------------------------------------------------------------------------------------------------------------

		// --------------------------------------------------------------------------------------------------------------
		// [panel_S]
		Panel panel_S = new Panel(new BorderLayout(5, 5));
		// panel_S_C
		Panel panel_S_C = new Panel(new GridLayout(1, 2, 5, 5));

		// panel_S_C_left
		Panel panel_S_C_left = new Panel(new BorderLayout(5, 5));
		// panel_S_C_left_N
		labOrderList.setFont(new Font("Serif", Font.BOLD, 20));
		panel_S_C_left.add("North", labOrderList);
		// panel_S_C_left_C
		panel_S_C_left.add("Center", list);
		panel_S_C.add(panel_S_C_left);
		panel_S.add(panel_S_C);

		// panel_S_C_right
		Panel panel_S_C_right = new Panel(new BorderLayout(5, 5));
		// panel_S_C_right_N
		labCalcList.setFont(new Font("Serif", Font.BOLD, 20));
		panel_S_C_right.add("North", labCalcList);

		// panel_S_C_right_C
		Panel panel_S_C_right_C = new Panel(new GridLayout(3, 3));
		panel_S_C_right_C.setBackground(Color.WHITE);
		Panel panel_S_C_right_C_1 = new Panel(new FlowLayout(FlowLayout.LEFT));
		panel_S_C_right_C_1.add(labTotalOrder);
		// panel_S_C_right_C_1.add(labSymbol);
		panel_S_C_right_C_1.add(tfTotalOrder);
		panel_S_C_right_C.add(panel_S_C_right_C_1);

		Panel panel_S_C_right_C_2 = new Panel(new FlowLayout(FlowLayout.LEFT));
		panel_S_C_right_C_2.add(labPoint);
		// panel_S_C_right_C_2.add(labSymbol);
		panel_S_C_right_C_2.add(tfPoint);
		panel_S_C_right_C.add(panel_S_C_right_C_2);

		Panel panel_S_C_right_C_3 = new Panel(new FlowLayout(FlowLayout.LEFT));
		panel_S_C_right_C_3.add(labTotalPay);
		// panel_S_C_right_C_3.add(labSymbol);
		panel_S_C_right_C_3.add(tfTotalPay);
		panel_S_C_right_C.add(panel_S_C_right_C_3);
		panel_S_C_right.add("Center", panel_S_C_right_C);

		// panel_S_C_right_S
		Panel panel_S_C_right_S = new Panel(new FlowLayout(FlowLayout.CENTER));
		panel_S_C_right_S.add(btPay);
		panel_S_C_right_S.add(btCancel);
		panel_S_C_right.add("South", panel_S_C_right_S);
		panel_S_C.add(panel_S_C_right);

		// --------------------------------------------------------------------------------------------------------------
		panel_S.add("Center", panel_S_C);
		panel_S.add("North", new Panel());
		panel_S.add("West", new Panel());
		panel_S.add("East", new Panel());
		panel_S.add("South", new Panel());

		mainPanel.add("South", panel_S);
		// --------------------------------------------------------------------------------------------------------------

		// 마무리
		pack();
		mainPanel.setBackground(Color.cyan);
		add(mainPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < btCard2.length; i++) {
			if (e.getSource() == btCard2[i]) {
				card2.show(panel_C_right_C_C, "" + i);
			}
		}
		
		
	}

	// 메인
	public static void main(String[] args) {
		new posManager();
	}
}
