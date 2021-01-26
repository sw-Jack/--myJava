package DB;
import java.sql.*;

// Connection Util 클래스
public class ConnectionUtil {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("[드라이버 검색 성공]");
		} catch(ClassNotFoundException e) {
			System.err.println("[드라이버 검색 실패]");
			System.exit(0); // 시스템 종료
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
