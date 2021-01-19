package lee.java.exam06;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

// Properties - select
public class JdbcEx11 {
	public static void main(String[] args) throws SQLException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/department.properties"));
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnUtil.getCOnConnection();
			// department.properties에 정의된 sql문 가져와서 PreparedStatement 객체 만들기
			pstmt = conn.prepareStatement(prop.getProperty("department_select"));
			pstmt.setInt(1, 255);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getInt(3) + "\t");
				System.out.print(rs.getString(4) + "\t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch(SQLException e) {}
			try { if(pstmt != null) pstmt.close(); } catch(SQLException e) {}
			try { if(conn != null) conn.close(); } catch(SQLException e) {}
		}
	}
}
