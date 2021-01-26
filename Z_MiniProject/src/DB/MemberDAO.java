package DB;
import java.sql.*;
import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MemberDAO {

	private Connection conn;
	private PreparedStatement pstmt; // 동적 쿼리 
	private Statement stmt; // 정적 쿼리
	private MemberVO memberVO;
	private ArrayList<MemberVO> memberList;
	
	// 생성자
	public MemberDAO() {
		conn = null;
		pstmt = null; // 동적 쿼리 
		stmt = null; // 정적 쿼리
		memberList = new ArrayList<MemberVO>(); 
	}


	// 회원가입 db - insert
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
			System.out.println(result + "개의 행이 추가 되었습니다.");
			if(result > 0) {
				isDone = true;
				memberList.add(memberVO); // 회원 목록에 추가 
				System.out.println("[회원가입 성공]");
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
	
	// 로그인 허가 여부
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
	
	// 등록된 회원 정보 가져오기
	public ArrayList<MemberVO> getMemberList() {
		return memberList;
	}
}
