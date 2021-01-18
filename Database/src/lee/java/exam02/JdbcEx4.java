package lee.java.exam02;
import java.sql.*;

// select ���� 
public class JdbcEx4 {
	public static void main(String[] args) {
		StringBuffer sb =new StringBuffer(
				"select deptno, dname, college, loc from department");
		Connection conn = null;
		Statement stmt = null; // ���� ����
		ResultSet rs = null;
		
		// ����̹� ����
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("[����̹� ���� ����]");
		} catch(ClassNotFoundException e) {
			System.err.println("[����̹� ���� ����]");
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
		
		// ������ �ۼ� : ���� ���� -> ������ ���̺� �����ͼ� �ܼ� â�� ����
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sb.toString());
			
			// "select deptno, dname, college, loc from department");
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				int college = rs.getInt("college");
				String loc = rs.getString("loc");
				System.out.println(deptno + "\t" + dname + "\t" + college 
												+ "\t" + loc);
			}
		} catch(SQLException e) {
			System.err.println("���� ����");
		} finally {
			try { if(rs != null) rs.close(); } catch(SQLException e) {}
			try { if(stmt != null) stmt.close(); } catch(SQLException e) {}
			try { if(conn != null) conn.close(); } catch(SQLException e) {}
		}
	}
}
