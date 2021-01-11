package lee.java.exam22;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class JTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;

	Object[][] data = {
			{"One", "�����", new Integer(1111), "��Ʈ��"},
			{"Two", "������", new Integer(2222), "����"},
			{"Three", "Ȳ����", new Integer(3333), "������"},
			{"Four", "Ȳ����", new Integer(4444), "������ġ��"}
			};
	String[] name = {"���̵�", "�̸�", "��й�ȣ", "�Ҽ�"};
	
	@Override
	public int getRowCount() { // �� ���� (�ʼ�*)
		return data.length;
	}

	@Override
	public int getColumnCount() { // �� ���� (�ʼ�*)
		return name.length;
	}

	@Override
	public Object getValueAt(int r, int c) { // ���� ������ ���� (�ʼ�*)
		return data[r][c];
	}
	
	public boolean isCellEditable(int r, int c) { // ���� ����
		return (c != 0) ? true : false;
	}
	
	public String getColumnName(int c) { // ���̺��� Ÿ��Ʋ�� �ο�
		return name[c];
	}
	
	public void setValueAt(Object obj, int r, int c) { // �ʵ尪 ����
		data[r][c] = obj;
	}
}
