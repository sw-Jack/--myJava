package lee.java.exam08;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class JListEx extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public JListEx() {
		super("JList Test");
		setLayout(new FlowLayout());
		String[] listData = {"Son", "Heung", "Min", "EPL", "TottenHam"};
		JList<String> list1 = new JList<String>(listData);
		list1.setSelectedIndex(1);
		JList<String> list2 = new JList<String>(new DefaultListModel());
		DefaultListModel model = (DefaultListModel)list2.getModel();
		model.addElement("���");
		model.addElement("��");
		model.addElement("����");
		model.addElement("�ٳ���");
		list2.setSelectedIndex(1);
		Vector vListData = new Vector();
		JList<String> list3 = new JList<String>(vListData);
		JScrollPane scroll = new JScrollPane(list3);
		vListData.add("�౸");
		vListData.add("�߱�");
		vListData.add("��");
		vListData.add("�豸");
		vListData.add("�״Ͻ�");
		vListData.add("����");
		vListData.add("����");
		vListData.add("�±ǵ�");
		vListData.add("����");
		
		class Student {
			String id;
			String name;
			String department;
			public Student(String id, String name, String department) {
				this.id = id;
				this.name = name;
				this.department = department;
			}
			public String toString() {
				return name;
			}
		}
		JList<String> list4 = new JList<String>(new DefaultListModel());
		list4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model = (DefaultListModel)list4.getModel();
		model.addElement(new Student("100", "ȫ�浿", "�����"));
		model.addElement(new Student("200", "�տ���", "�����"));
		model.addElement(new Student("300", "�ο���", "�����"));
		model.addElement(new Student("400", "���Ȱ�", "����"));
		list4.setSelectedIndex(1);
		add(list1);
		add(list2);
		add(scroll);
		add(list4);
		setBounds(300,200,300,200);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JListEx();
	}
}
