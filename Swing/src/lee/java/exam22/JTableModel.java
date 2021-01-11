package lee.java.exam22;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class JTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;

	Object[][] data = {
			{"One", "손흥민", new Integer(1111), "토트넘"},
			{"Two", "박지성", new Integer(2222), "맨유"},
			{"Three", "황의조", new Integer(3333), "보르도"},
			{"Four", "황희찬", new Integer(4444), "라이프치히"}
			};
	String[] name = {"아이디", "이름", "비밀번호", "소속"};
	
	@Override
	public int getRowCount() { // 행 개수 (필수*)
		return data.length;
	}

	@Override
	public int getColumnCount() { // 열 개수 (필수*)
		return name.length;
	}

	@Override
	public Object getValueAt(int r, int c) { // 실제 데이터 추출 (필수*)
		return data[r][c];
	}
	
	public boolean isCellEditable(int r, int c) { // 편집 가능
		return (c != 0) ? true : false;
	}
	
	public String getColumnName(int c) { // 테이블의 타이틀명 부여
		return name[c];
	}
	
	public void setValueAt(Object obj, int r, int c) { // 필드값 변경
		data[r][c] = obj;
	}
}
