package lee.java.exam02;
import java.sql.*;

// select 예제 
public class JdbcEx4 {
	public static void main(String[] args) {
		StringBuffer sb =new StringBuffer(
				"select deptno, dname, college, loc from department");
		Connection conn = null;
		Statement stmt = null; // 동적 쿼리
		ResultSet rs = null;
		
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
		
		// 쿼리문 작성 : 동적 쿼리 -> 데이터 테이블 가져와서 콘솔 창에 띄우기
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
			System.err.println("쿼리 오류");
		} finally {
			try { if(rs != null) rs.close(); } catch(SQLException e) {}
			try { if(stmt != null) stmt.close(); } catch(SQLException e) {}
			try { if(conn != null) conn.close(); } catch(SQLException e) {}
		}
	}
}
