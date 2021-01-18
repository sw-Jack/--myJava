package lee.java.exam02;
import java.sql.*;

// update ���� 
public class JdbcEx2 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer(
				"update department set dname = '���ڰ���а�' where deptno = 203");
		Connection conn = null;
		Statement stmt = null; // ���� ����
		
		// ����̹� ����
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("[����̹� �˻� ����]");
		} catch(ClassNotFoundException e) {
			System.err.println("[����̹� �˻� ����]");
			System.exit(0);
		}
		
		// ������ ���̽� ���� 
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
														"jobclass", "jobclass");
			System.out.println("[������ ���̽� ���� ����]");
		} catch(SQLException e) {
			System.err.println("[������ ���̽� ���� ����]");
			System.exit(0);
		}
		
		// ������ �ۼ� : ���� ���� 
		try {
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sb.toString());
			System.out.println(result + "���� ���� ����Ǿ����ϴ�.");
		} catch(SQLException e) {
			System.err.println("���� ����");
		} finally {
			try { if(stmt != null) stmt.close(); } catch(SQLException e) {}
			try { if(conn != null) conn.close(); } catch(SQLException e) {}
		}
	}
}
