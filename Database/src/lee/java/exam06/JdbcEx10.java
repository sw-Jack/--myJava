package lee.java.exam06;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

// Properties - insert
public class JdbcEx10 {
	public static void main(String[] args) throws SQLException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/department.properties"));
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnUtil.getCOnConnection();
			// department.properties�� ���ǵ� sql�� �����ͼ� PreparedStatement ��ü �����
			pstmt = conn.prepareStatement(prop.getProperty("department_insert"));
			pstmt.setInt(1, 100);
			pstmt.setString(2, "������а�");
			pstmt.setInt(3, 200);
			pstmt.setString(4, "5ȣ��");
			int result = pstmt.executeUpdate();
			System.out.println(result + "���� ���� �߰��Ǿ����ϴ�.");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(pstmt != null) pstmt.close(); } catch(SQLException e) {}
			try { if(conn != null) conn.close(); } catch(SQLException e) {}
		}
	}
}
