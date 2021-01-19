package lee.java.exam06;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

// Properties - delete
public class JdbcEx13 {
	public static void main(String[] args) throws SQLException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/department.properties"));
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnUtil.getCOnConnection();
			// department.properties에 정의된 sql문 가져와서 PreparedStatement 객체 만들기
			pstmt = conn.prepareStatement(prop.getProperty("department_delete"));
			pstmt.setString(1, "산업공학과");
			
			int result = pstmt.executeUpdate();
			System.out.println(result + "개의 행이 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(pstmt != null) pstmt.close(); } catch(SQLException e) {}
			try { if(conn != null) conn.close(); } catch(SQLException e) {}
		}
	}
}
