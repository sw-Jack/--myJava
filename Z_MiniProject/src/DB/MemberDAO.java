package DB;
import java.sql.*;
import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MemberDAO {

	private Connection conn;
	private PreparedStatement pstmt; // ���� ���� 
	private Statement stmt; // ���� ����
	private MemberVO memberVO;
	private ArrayList<MemberVO> memberList;
	
	// ������
	public MemberDAO() {
		conn = null;
		pstmt = null; // ���� ���� 
		stmt = null; // ���� ����
		memberList = new ArrayList<MemberVO>(); 
	}


	// ȸ������ db - insert
	public boolean memberInsert(String name, String id, String pw, String phoneNum, String storeCode) {
		boolean isDone = false;
		memberVO = new MemberVO(name, id, pw, phoneNum, storeCode);
		StringBuffer sql = new StringBuffer(
				"insert into member values(seq_member.nextval, ?, ?, ?, ?, ?)");
		try {
			conn = ConnectionUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, memberVO.getName());
			pstmt.setString(2, memberVO.getId());
			pstmt.setString(3, memberVO.getPw());
			pstmt.setString(4, memberVO.getPhoneNum());
			pstmt.setString(5, memberVO.getStoreCode());
			/*
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.setString(4, phoneNum);
			pstmt.setString(5, storeCode);
			*/
			int result = pstmt.executeUpdate();
			System.out.println(result + "���� ���� �߰� �Ǿ����ϴ�.");
			if(result > 0) {
				isDone = true;
				memberList.add(memberVO); // ȸ�� ��Ͽ� �߰� 
				System.out.println("[ȸ������ ����]");
			} else {
				isDone = false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(pstmt != null && !pstmt.isClosed()) pstmt.close(); } catch(SQLException e) {}
			try { if(conn != null && !conn.isClosed()) conn.close(); } catch(SQLException e) {}
		}
		return isDone;
	}
	
	// �α��� �㰡 ����
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
	
	// ��ϵ� ȸ�� ���� ��������
	public ArrayList<MemberVO> getMemberList() {
		return memberList;
	}
}
