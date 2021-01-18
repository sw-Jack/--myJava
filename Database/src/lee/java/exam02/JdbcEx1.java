package lee.java.exam02;
import java.sql.*;

// Insert 예제
public class JdbcEx1 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null; // 정적 쿼리
		
		// 드라이버 로드
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
			System.err.println("[데이터 베이스 연결 실패]");
			System.exit(0);
		}
		
		// 쿼리문 작성 : 정적 쿼리
		try {
			stmt = conn.createStatement();
			StringBuffer sb = new StringBuffer("insert into department values");
			sb.append("(203, '제어계측공학과', 200, '7호관')");
			// 쿼리 실행
			int result = stmt.executeUpdate(sb.toString()); // 쿼리문이 적용된 행이 존재하면 1, 그렇지 않으면 0 반환
			System.out.println(result + "개의 행이 추가되었습니다.");
		} catch(SQLException e) {
			e.printStackTrace();
			System.err.println("쿼리 오류");
		} finally {
			try { if(stmt != null) stmt.close(); } catch(SQLException e) {}
			try { if(conn != null) conn.close(); } catch(SQLException e) {}
		}
	}
}
