package lee.java.exam04;
import java.sql.*;

// Transaction Ʈ����� : ���� ���� �۾��� �ϳ��� ������ �۾� ������ ���� �ִ� ��
// -> �ϳ��� �۾� ���� ���� ��ü �۾����� ��� �ùٸ��� ����ǰų� (all) 
// or
// -> ��ü �۾��� ��� ������� �ʵ��� (nothing)
public class JdbcEx8 {
	public static void main(String[] args) {
		StringBuffer sqlInsert = 
				new StringBuffer("insert into department values(?, ?, ?, ?)");
		StringBuffer sqlUpdate = 
				new StringBuffer("update department set dname = ?, loc = ? where deptno = ?");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// [transaction ���� ]
			conn = ConnUtil.getCOnConnection();
			// autoCommit ��� ��Ȱ��ȭ
			conn.setAutoCommit(false);
			// 1�� �۾� ����-------------------------------------------------------------
			pstmt = conn.prepareStatement(sqlInsert.toString());
			pstmt.setInt(1, 255);
			pstmt.setString(2, "�ٹ����а�");
			pstmt.setInt(3, 200);
			pstmt.setString(4, "9ȣ��");
			pstmt.executeUpdate();
			// 1�� �۾� ����-------------------------------------------------------------
			// 2�� �۾� ����-------------------------------------------------------------
			pstmt = conn.prepareStatement(sqlUpdate.toString());
			pstmt.setString(1, "������а�");
			pstmt.setString(2, "9ȣ��");
			pstmt.setInt(3, 255);
			pstmt.executeUpdate();
			pstmt.executeUpdate();
			// 2�� �۾� ����-------------------------------------------------------------
			// ������ ���������� ����� ��� db�� �ݿ� -> commit
			conn.commit();
			System.out.println("commit�� ����Ǿ����ϴ�.");
		} catch(SQLException e) { // commit ������ ������ �߻��� ���, commit�� ������ ���
			try {
				conn.rollback(); // rollback ����
				System.out.println("commit ����, rollback�� ����Ǿ����ϴ�.");
			} catch(SQLException ee) {
				ee.printStackTrace();
			} finally {
				try { if(pstmt != null) pstmt.close(); } catch(SQLException eee) {}
				try { if(conn != null) conn.close(); } catch(SQLException eee) {}
			}
		}
	}
}
