package lee.java.exam01;
import java.sql.*;
import java.util.Scanner;

// ���� ����
public class JdbcTest02 { 
	public static void main(String[] args) {
		// ����̹� �ε�
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
			System.err.println("[������ ���̽� ���� ����]");
			System.exit(0);
		}
		
		// ������ �ۼ�
		System.out.print("���� : ");
		Scanner sc = new Scanner(System.in);
		int inputAge = sc.nextInt();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from mytable where age > ?"); // ���� ������ �������� �̸� ��
			pstmt.setInt(1, inputAge);
			rs = pstmt.executeQuery();
			
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
						+ address + "\t" + birth.toString() + "\t" + date.toString());			
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.err.println("���� ����");
		} finally { // ��� �Ŀ� �ݵ�� close()
			try { if(rs != null) rs.close(); } catch(SQLException e) {}
			try { if(pstmt != null) pstmt.close(); } catch(SQLException e) {}
			try { if(conn != null) conn.close(); } catch(SQLException e) {}
		}
	} 
}
