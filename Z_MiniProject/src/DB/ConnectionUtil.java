package DB;
import java.sql.*;

// Connection Util Ŭ����
public class ConnectionUtil {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("[����̹� �˻� ����]");
		} catch(ClassNotFoundException e) {
			System.err.println("[����̹� �˻� ����]");
			System.exit(0); // �ý��� ����
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", // oracle 11g version
				"manager",
				"manager"
				);
	}
}
