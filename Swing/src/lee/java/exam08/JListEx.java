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
		model.addElement("사과");
		model.addElement("배");
		model.addElement("딸기");
		model.addElement("바나나");
		list2.setSelectedIndex(1);
		Vector vListData = new Vector();
		JList<String> list3 = new JList<String>(vListData);
		JScrollPane scroll = new JScrollPane(list3);
		vListData.add("축구");
		vListData.add("야구");
		vListData.add("농구");
		vListData.add("배구");
		vListData.add("테니스");
		vListData.add("수영");
		vListData.add("육상");
		vListData.add("태권도");
		vListData.add("유도");
		
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
		model.addElement(new Student("100", "홍길동", "전산과"));
		model.addElement(new Student("200", "손오공", "건축과"));
		model.addElement(new Student("300", "싸오정", "무용과"));
		model.addElement(new Student("400", "저팔계", "토목과"));
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
