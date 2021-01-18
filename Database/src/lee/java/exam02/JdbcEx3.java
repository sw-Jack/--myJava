package lee.java.exam02;
import java.sql.*;
import java.util.Scanner;

// delete 예제 
public class JdbcEx3 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer(
				"delete department where dname = ?");
		Connection conn = null;
		PreparedStatement pstmt = null; // 동적 쿼리 
		
		// 드라이버 연결
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("[드라이버 연결 성공]");
		} catch(ClassNotFoundException e) {
			System.err.println("[드라이버 연결 실패]");
			System.exit(0);
		}
		
		// 데이터 베이스 연결 
		try { 
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
													"jobclass", "jobclass");
			System.out.println("[데이터 베이스 연결 성공]"); 
		} catch(SQLException e) {
			System.err.println("[데이터 베이스 연결 실패]");
			System.exit(0);
		}
		
		// 쿼리문 작성 : 동적 쿼리 
		try {
			 pstmt = conn.prepareStatement(sb.toString());
			 Scanner sc = new Scanner(System.in);
			 System.out.print("학과 : ");
			 String inputDname = sc.nextLine();
			 pstmt.setString(1, inputDname);
			 int result = pstmt.executeUpdate();
			 System.out.println(result + "개의 행이 삭제되었습니다.");
		} catch(SQLException e) {
			System.err.println("쿼리 오류");
		} finally {
			try { if(pstmt != null) pstmt.close(); } catch(SQLException e) {}
			try { if(conn != null) conn.close(); } catch(SQLException e) {}
		}
	}
}
