package db;
import java.sql.*;

public class MemberDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null; // ���� ���� 
	private MemberVO memberVo;
	
	// ȸ������ db - insert
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
			System.out.println(result + "���� ���� �߰� �Ǿ����ϴ�.");
			System.out.println("[ȸ������ ����]");
		} catch(SQLException e) {
			System.err.println("[ȸ������ ����]");
		} finally {
			try { if(pstmt != null && !pstmt.isClosed()) pstmt.close(); } catch(SQLException e) {}
			try { if(conn != null && !conn.isClosed()) conn.close(); } catch(SQLException e) {}
		}
	}
	
	// �α���
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
			isLog = rs.next(); // ǥ�� �����Ͱ� �����ϸ� isLog = true ��, �α��� �㰡
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(pstmt != null && !pstmt.isClosed()) pstmt.close(); } catch(SQLException e) {}
			try { if(conn != null && !conn.isClosed()) conn.close(); } catch(SQLException e) {}
		}
		return isLog; // �Ѵ� ������ �α��� �㰡�� true, �ƴϸ� ����� false ��ȯ
	}
	
	// ���̵� �ߺ� üũ
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
			isDup = rs.next(); // ǥ�� �����Ͱ� �����ϸ� isDup = true ��, �ߺ��� ���̵� �����Ѵٴ� �ǹ�
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(pstmt != null && !pstmt.isClosed()) pstmt.close(); } catch(SQLException e) {}
			try { if(conn != null && !conn.isClosed()) conn.close(); } catch(SQLException e) {}
		}
		return isDup; // �ߺ��̸� true, �ƴϸ� fasle ��ȯ
	}
}
