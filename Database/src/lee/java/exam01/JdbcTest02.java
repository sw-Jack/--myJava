package lee.java.exam01;
import java.sql.*;
import java.util.Scanner;

// 동적 쿼리
public class JdbcTest02 { 
	public static void main(String[] args) {
		// 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("[드라이버 검색 성공]");
		} catch(ClassNotFoundException e) {
			System.err.println("[드라이버 검색 실패]");
			System.exit(0);
		}
		
		// 데이터 베이스 연결
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
															"jobclass", "jobclass");
			System.out.println("[데이터 베이스 연결 성공]");
		} catch(SQLException e) {
			System.err.println("[데이터 베이스 연결 실패]");
			System.exit(0);
		}
		
		// 쿼리문 작성
		System.out.print("나이 : ");
		Scanner sc = new Scanner(System.in);
		int inputAge = sc.nextInt();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from mytable where age > ?"); // 동적 쿼리는 쿼리문을 미리 줌
			pstmt.setInt(1, inputAge);
			rs = pstmt.executeQuery();
			
			while(rs.next()) { // 커서 다음에 정보가 존재한다면 while 실행
				int num = rs.getInt(1); 
				String name = rs.getString(2);
				int age = rs.getInt("age"); // 컬럼명으로 가지고 와도됨
				String address = rs.getString("address");
				if(address == null) address = " "; // db에서 address는  not null 허용했으므로 null 값이 왔을 경우의 출력을 고려
				java.sql.Date birth = rs.getDate("birth");
				java.util.Date date = new java.util.Date(birth.getTime());
				// 출력
				System.out.println(num + "\t" + name + "\t" + age + "\t" 
						+ address + "\t" + birth.toString() + "\t" + date.toString());			
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.err.println("쿼리 오류");
		} finally { // 사용 후엔 반드시 close()
			try { if(rs != null) rs.close(); } catch(SQLException e) {}
			try { if(pstmt != null) pstmt.close(); } catch(SQLException e) {}
			try { if(conn != null) conn.close(); } catch(SQLException e) {}
		}
	} 
}
