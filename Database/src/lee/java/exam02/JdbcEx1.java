package lee.java.exam02;
import java.sql.*;

// Insert ����
public class JdbcEx1 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null; // ���� ����
		
		// ����̹� �ε�
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
			StringBuffer sb = new StringBuffer("insert into department values");
			sb.append("(203, '����������а�', 200, '7ȣ��')");
			// ���� ����
			int result = stmt.executeUpdate(sb.toString()); // �������� ����� ���� �����ϸ� 1, �׷��� ������ 0 ��ȯ
			System.out.println(result + "���� ���� �߰��Ǿ����ϴ�.");
		} catch(SQLException e) {
			e.printStackTrace();
			System.err.println("���� ����");
		} finally {
			try { if(stmt != null) stmt.close(); } catch(SQLException e) {}
			try { if(conn != null) conn.close(); } catch(SQLException e) {}
		}
	}
}
