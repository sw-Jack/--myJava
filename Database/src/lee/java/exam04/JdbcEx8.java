package lee.java.exam04;
import java.sql.*;

// Transaction 트랜잭션 : 여러 개의 작업을 하나의 논리적인 작업 단위로 묶어 주는 것
// -> 하나의 작업 단위 내의 전체 작업들이 모두 올바르게 수행되거나 (all) 
// or
// -> 전체 작업이 모두 수행되지 않도록 (nothing)
public class JdbcEx8 {
	public static void main(String[] args) {
		StringBuffer sqlInsert = 
				new StringBuffer("insert into department values(?, ?, ?, ?)");
		StringBuffer sqlUpdate = 
				new StringBuffer("update department set dname = ?, loc = ? where deptno = ?");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// [transaction 시작 ]
			conn = ConnUtil.getCOnConnection();
			// autoCommit 기능 비활성화
			conn.setAutoCommit(false);
			// 1번 작업 시작-------------------------------------------------------------
			pstmt = conn.prepareStatement(sqlInsert.toString());
			pstmt.setInt(1, 255);
			pstmt.setString(2, "핵물리학과");
			pstmt.setInt(3, 200);
			pstmt.setString(4, "9호관");
			pstmt.executeUpdate();
			// 1번 작업 종료-------------------------------------------------------------
			// 2번 작업 시작-------------------------------------------------------------
			pstmt = conn.prepareStatement(sqlUpdate.toString());
			pstmt.setString(1, "생명공학과");
			pstmt.setString(2, "9호관");
			pstmt.setInt(3, 255);
			pstmt.executeUpdate();
			pstmt.executeUpdate();
			// 2번 작업 종료-------------------------------------------------------------
			// 쿼리가 정상적으로 실행된 경우 db에 반영 -> commit
			conn.commit();
			System.out.println("commit이 수행되었습니다.");
		} catch(SQLException e) { // commit 이전에 에러가 발생한 경우, commit에 실패한 경우
			try {
				conn.rollback(); // rollback 수행
				System.out.println("commit 실패, rollback이 수행되었습니다.");
			} catch(SQLException ee) {
				ee.printStackTrace();
			} finally {
				try { if(pstmt != null) pstmt.close(); } catch(SQLException eee) {}
				try { if(conn != null) conn.close(); } catch(SQLException eee) {}
			}
		}
	}
}
