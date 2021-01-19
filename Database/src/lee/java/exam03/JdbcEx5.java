package lee.java.exam03;
import java.sql.*;

// insert 예제
public class JdbcEx5 {
	public static void main(String[] args) {
		// 동적 쿼리 사용
		StringBuffer sb = new StringBuffer(
				"insert into professor values");
		sb.append("(?, ?, ?, ?, ?, sysdate, ?, ?)");
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnUtil.getCOnConnection();
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, 9920);
			pstmt.setString(2, "홍길동");
			pstmt.setString(3, "gildong");
			pstmt.setString(4, "전임교수");
			pstmt.setInt(5, 450);
			pstmt.setInt(6, 40);
			pstmt.setInt(7, 203);
			int result = pstmt.executeUpdate();
			System.out.println(result + "개의 행이 추가되었습니다.");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(pstmt != null) pstmt.close(); } catch(SQLException e) {}
			try { if(conn != null) conn.close(); } catch(SQLException e) {}
		}
	}
}
