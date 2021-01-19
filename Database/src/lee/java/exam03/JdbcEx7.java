package lee.java.exam03;
import java.sql.*;

// select ¿¹Á¦
public class JdbcEx7 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer(
				"select a.name, a.profno, a.position, b.dname ");
		sb.append("from professor a, department b ");
		sb.append("where a.deptno = b.deptno ");
		sb.append("and a.deptno = ?");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnUtil.getCOnConnection();
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, 203);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString("name") + "\t");
				System.out.print(rs.getInt("profno") + "\t");
				System.out.print(rs.getString("dname") + "\t");
				System.out.println(rs.getString("position") + "\t");

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
