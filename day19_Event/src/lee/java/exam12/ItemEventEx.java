package lee.java.exam12;

import java.awt.*;
import java.awt.event.*;

public class ItemEventEx extends Frame 
implements ItemListener, ActionListener, WindowListener {
	private static final long serialVersionUID = 1L;
	
	private Label labBloodType = new Label("������ : ", Label.RIGHT);
	private Label labBirthDate = new Label("������� : ", Label.RIGHT);
	private Label labArea = new Label("���� : ", Label.RIGHT);
	
	private TextField tfBloodType = new TextField();
	private Choice chBloodType = new Choice();
	
	private TextField tfBirthDate = new TextField();
	private Choice chYear = new Choice();
	private Choice chMonth = new Choice();
	private Choice chDay = new Choice();

	
	private TextField tfArea = new TextField();
	private List list = new List(3, false); // 3��, ���߼��� X
	
	private Button btEnd = new Button("������");
	
	public ItemEventEx() {
		super("ItemEventEx");
		setForm();
		tfBloodType.setEditable(false);
		tfBirthDate.setEditable(false);
		tfArea.setEditable(false);
		
		chBloodType.addItemListener(this);
		chDay.addItemListener(this);
		list.addItemListener(this);
		list.addActionListener(this);
		btEnd.addActionListener(this);
		addWindowListener(this);
		setSize(300,200);
		setVisible(true);
		chBloodType.requestFocus();
	}
	
	private void setForm() {
		setLayout(new GridLayout(2,1));
		Panel panel = new Panel(new BorderLayout());
		Panel panel1 = new Panel(new GridLayout(3,1));
		panel1.add(labBloodType);
		panel1.add(labBirthDate);
		panel1.add(labArea);
		panel.add("West", panel1);
		
		Panel panel2 = new Panel(new GridLayout(3,1));
		panel2.add(tfBloodType);
		panel2.add(tfBirthDate);
		panel2.add(tfArea);
		panel.add("Center", panel2);
		
		Panel panel3 = new Panel(new GridLayout(4,1));
		panel3.add(chBloodType);
		panel3.add(chYear);
		panel3.add(chMonth);
		panel3.add(chDay);
		chBloodType.add("A��");
		chBloodType.add("B��");
		chBloodType.add("AB��");
		chBloodType.add("O��");
		
		for(int i=1980; i<=2010; i++) chYear.add(i + "��");
		for(int i=1; i<=12; i++) chMonth.add(i + "��");
		for(int i=1; i<=31; i++) chDay.add(i + "��");
		panel.add("East", panel3);
		add(panel); // �߾� ��
		
		Panel panel4 = new Panel(new BorderLayout());
		panel4.add("Center", list);
		list.add("����"); list.add("�뱸");
		list.add("�λ�"); list.add("����");
		list.add("����"); list.add("���");
		list.add("��õ"); list.add("����");
		panel4.add("East", btEnd);
		add(panel4);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == list) {
			int i = list.getSelectedIndex();
			list.remove(i);
		} else if(e.getSource() == btEnd) {
			System.exit(0);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == chBloodType) {
			String tempBlood = chBloodType.getSelectedItem();
			tfBloodType.setText(tempBlood);
		} else if(e.getSource() == chDay) {
			String tempYear = chYear.getSelectedItem();
			String tempMonth = chMonth.getSelectedItem();
			String tempDay = chDay.getSelectedItem();
			tfBirthDate.setText(tempYear + tempMonth + tempDay);
		} else if(e.getSource() == list) {
			String tempList = list.getSelectedItem();
			tfArea.setText(tempList + "����");
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
			System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

	public static void main(String[] args) {
		new ItemEventEx();
	}
}
