package lee.java.exam03;

import java.awt.*;

public class LabelEx extends Frame {
	
	// ���
	Label la1;
	Label la2;
	Label la3;
	Label la4;
	Font f1;
	Font f2;
	
	// ������
	LabelEx() {
		super("Label Exam");
		// ��Ʈ
		f1 = new Font("����ü", Font.BOLD, 20);
		f2 = new Font("����ü", Font.ITALIC, 25);
		// ���̺�
		la1 = new Label("�ȳ��ϼ���!"); // ����Ʈ LEFT
		la2 = new Label("������Դϴ�!", Label.CENTER);
		la3 = new Label("�������Դϴ�!", Label.RIGHT);
		la4 = new Label("���� �����Ͼ �ǰ� �;��!");
		// ���̾ƿ� ����
		setLayout(new GridLayout(4,1)); // 4�� 1��
		// ���̺� ��Ʈ ����
		la1.setFont(f1);
		la2.setFont(f1);
		la3.setFont(f2);
		la4.setFont(f2);
		// ���̺� ����(�߰�)
		add(la1);
		add(la2);
		add(la3);
		add(la4);
		// ���̺� ���� ����
		la1.setBackground(Color.red);
		la2.setBackground(Color.blue);
		la3.setBackground(Color.green);
		la4.setBackground(Color.pink);
		// â ũ�� �� ���̱� ����
		setSize(300,200);
		setVisible(true);
	}

	public static void main(String[] args) {
		LabelEx label = new LabelEx();
	}
}
