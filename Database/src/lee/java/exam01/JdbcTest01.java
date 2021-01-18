package lee.java.exam01;
import java.sql.*; // import

// ���� ����
public class JdbcTest01 { 
	public static void main(String[] args) {
		// ����̹� �ε� with ���� ó��
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("[����̹� �˻� ����]");
		} catch(ClassNotFoundException e) {
			System.err.println("[����̹� �˻� ����]");
			System.exit(0);
		}
		
		// ������ ���̽� ����
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
													"jobclass", "jobclass");
			System.out.println("[������ ���̽� ���� ����]");
		} catch(SQLException e) {
			System.out.println("[������ ���̽� ���� ����]");
			System.exit(0);
		}
		
		// ������ �ۼ� : ����
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement(); // ������ �̸� ���� ����
			rs = stmt.executeQuery("select * from mytable"); // rs���� �������� ���� ���̺� ���� ����
			
			// ȭ�� ���
			while(rs.next()) { // Ŀ�� ������ ������ �����Ѵٸ� while ����
				int num = rs.getInt(1); 
				String name = rs.getString(2);
				int age = rs.getInt("age"); // �÷������� ������ �͵���
				String address = rs.getString("address");
				if(address == null) address = " "; // db���� address��  not null ��������Ƿ� null ���� ���� ����� ����� ���
				java.sql.Date birth = rs.getDate("birth");
				java.util.Date date = new java.util.Date(birth.getTime());
				// ���
				System.out.println(num + "\t" + name + "\t" + age + "\t" 
						+ address + "\t" + birth.toString() + "\t" + date.toString());			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("���� ����");
		} finally { // ��� �Ŀ� �ݵ�� close()
			try { if(rs != null) rs.close(); } catch(SQLException e) {}
			try { if(stmt != null) stmt.close(); } catch(SQLException e) {}
			try { if(conn != null) conn.close(); } catch(SQLException e) {}
		}
	}
}



















