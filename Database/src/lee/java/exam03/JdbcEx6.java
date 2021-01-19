package lee.java.exam03;
import java.sql.*;

// update 예제
public class JdbcEx6 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer(
				"update professor set sal = ? where name = ?");
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnUtil.getCOnConnection();
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, 500);
			pstmt.setString(2, "홍길동");
			int result = pstmt.executeUpdate();
			System.out.println(result + "개의 행이 변경되었습니다.");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(pstmt != null) pstmt.close(); } catch(SQLException e) {}
			try { if(conn != null) conn.close(); } catch(SQLException e) {}
		}
	}
}
