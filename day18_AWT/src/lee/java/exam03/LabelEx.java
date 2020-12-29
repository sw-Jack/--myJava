package lee.java.exam03;

import java.awt.*;

public class LabelEx extends Frame {
	
	// 멤버
	Label la1;
	Label la2;
	Label la3;
	Label la4;
	Font f1;
	Font f2;
	
	// 생성자
	LabelEx() {
		super("Label Exam");
		// 폰트
		f1 = new Font("굴림체", Font.BOLD, 20);
		f2 = new Font("바탕체", Font.ITALIC, 25);
		// 레이블
		la1 = new Label("안녕하세요!"); // 디폴트 LEFT
		la2 = new Label("손흥민입니다!", Label.CENTER);
		la3 = new Label("개발자입니다!", Label.RIGHT);
		la4 = new Label("구글 엔지니어가 되고 싶어요!");
		// 레이아웃 설정
		setLayout(new GridLayout(4,1)); // 4행 1열
		// 레이블 폰트 설정
		la1.setFont(f1);
		la2.setFont(f1);
		la3.setFont(f2);
		la4.setFont(f2);
		// 레이블 적용(추가)
		add(la1);
		add(la2);
		add(la3);
		add(la4);
		// 레이블 배경색 설정
		la1.setBackground(Color.red);
		la2.setBackground(Color.blue);
		la3.setBackground(Color.green);
		la4.setBackground(Color.pink);
		// 창 크기 및 보이기 설정
		setSize(300,200);
		setVisible(true);
	}

	public static void main(String[] args) {
		LabelEx label = new LabelEx();
	}
}
