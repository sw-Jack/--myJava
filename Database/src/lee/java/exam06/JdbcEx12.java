package lee.java.exam06;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

// Properties - update
public class JdbcEx12 {
	public static void main(String[] args) throws SQLException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/department.properties"));
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnUtil.getCOnConnection();
			// department.properties�� ���ǵ� sql�� �����ͼ� PreparedStatement ��ü �����
			pstmt = conn.prepareStatement(prop.getProperty("department_update"));
			pstmt.setString(1, "6ȣ��");
			pstmt.setInt(2, 203);

			int result = pstmt.executeUpdate();
			System.out.println(result + "���� ���� ����Ǿ����ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(pstmt != null) pstmt.close(); } catch(SQLException e) {}
			try { if(conn != null) conn.close(); } catch(SQLException e) {}
		}
	}
}
