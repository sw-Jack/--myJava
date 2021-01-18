package lee.java.exam02;
import java.sql.*;
import java.util.Scanner;

// delete ���� 
public class JdbcEx3 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer(
				"delete department where dname = ?");
		Connection conn = null;
		PreparedStatement pstmt = null; // ���� ���� 
		
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
		
		// ������ �ۼ� : ���� ���� 
		try {
			 pstmt = conn.prepareStatement(sb.toString());
			 Scanner sc = new Scanner(System.in);
			 System.out.print("�а� : ");
			 String inputDname = sc.nextLine();
			 pstmt.setString(1, inputDname);
			 int result = pstmt.executeUpdate();
			 System.out.println(result + "���� ���� �����Ǿ����ϴ�.");
		} catch(SQLException e) {
			System.err.println("���� ����");
		} finally {
			try { if(pstmt != null) pstmt.close(); } catch(SQLException e) {}
			try { if(conn != null) conn.close(); } catch(SQLException e) {}
		}
	}
}
