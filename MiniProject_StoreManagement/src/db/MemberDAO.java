package db;
import java.sql.*;

public class MemberDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null; // 동적 쿼리 
	private MemberVO memberVo;
	
	// 회원가입 db - insert
	public void memberInsert() {
		StringBuffer sql = new StringBuffer(
				"insert into member values(seq_member.nextval, ?, ?, ?, ?, ?)");
		try {
			conn = ConnectionUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, memberVo.getName());
			pstmt.setString(2, memberVo.getId());
			pstmt.setString(3, memberVo.getPw());
			pstmt.setString(4, memberVo.getPhoneNum());
			pstmt.setString(5, memberVo.getStoreCode());
			int result = pstmt.executeUpdate();
			System.out.println(result + "개의 행이 추가 되었습니다.");
			System.out.println("[회원가입 성공]");
		} catch(SQLException e) {
			System.err.println("[회원가입 실패]");
		} finally {
			try { if(pstmt != null && !pstmt.isClosed()) pstmt.close(); } catch(SQLException e) {}
			try { if(conn != null && !conn.isClosed()) conn.close(); } catch(SQLException e) {}
		}
	}
	
	// 로그인
	public boolean login(String inputId, String inputPw) {
		boolean isLog = false;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer(
				"select id, pw from member where id = ? and pw = ?");
		try {
			conn = ConnectionUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, inputId);
			pstmt.setString(2, inputPw);

			rs = pstmt.executeQuery();
			isLog = rs.next(); // 표에 데이터가 존재하면 isLog = true 즉, 로그인 허가
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(pstmt != null && !pstmt.isClosed()) pstmt.close(); } catch(SQLException e) {}
			try { if(conn != null && !conn.isClosed()) conn.close(); } catch(SQLException e) {}
		}
		return isLog; // 둘다 맞으면 로그인 허가로 true, 아니면 불허로 false 반환
	}
	
	// 아이디 중복 체크
	public boolean isDupId(String checkId) {
		boolean isDup = false;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer(
				"select id from member where id = ?");
		try {
			conn = ConnectionUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, checkId);
			rs = pstmt.executeQuery();
			isDup = rs.next(); // 표에 데이터가 존재하면 isDup = true 즉, 중복된 아이디가 존재한다는 의미
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(pstmt != null && !pstmt.isClosed()) pstmt.close(); } catch(SQLException e) {}
			try { if(conn != null && !conn.isClosed()) conn.close(); } catch(SQLException e) {}
		}
		return isDup; // 중복이면 true, 아니면 fasle 반환
	}
}
