package lee.java.exam02;
import java.sql.*;

// update 예제 
public class JdbcEx2 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer(
				"update department set dname = '전자계산학과' where deptno = 203");
		Connection conn = null;
		Statement stmt = null; // 정적 쿼리
		
		// 드라이버 연결
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("[드라이버 검색 성공]");
		} catch(ClassNotFoundException e) {
			System.err.println("[드라이버 검색 실패]");
			System.exit(0);
		}
		
		// 데이터 베이스 연결 
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
														"jobclass", "jobclass");
			System.out.println("[데이터 베이스 연결 성공]");
		} catch(SQLException e) {
			System.err.println("[데이터 베이스 연겶 실패]");
			System.exit(0);
		}
		
		// 쿼리문 작성 : 정적 쿼리 
		try {
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sb.toString());
			System.out.println(result + "개의 행이 변경되었습니다.");
		} catch(SQLException e) {
			System.err.println("쿼리 오류");
		} finally {
			try { if(stmt != null) stmt.close(); } catch(SQLException e) {}
			try { if(conn != null) conn.close(); } catch(SQLException e) {}
		}
	}
}
