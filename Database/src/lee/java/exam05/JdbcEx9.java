package lee.java.exam05;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

// ResultSetMetaData : MetaData�� �������� �������
public class JdbcEx9 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("SQL �Է� : ");
		String sql = br.readLine();
		Connection conn = ConnUtil.getCOnConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		// ���� ���� ��� ������ �ΰ� ������ ������ �ִ� ResultSetMetaData ���
		ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println("�÷��� ���� : " + rsmd.getColumnCount());
		
		int colCount = rsmd.getColumnCount(); // �÷� ����
		while(rs.next()) {
			for(int colNum=1; colNum<=colCount; colNum++) {
				int colType = rsmd.getColumnType(colNum);
				switch(colType) {
				case Types.NUMERIC : 
					System.out.print(rs.getInt(colNum) + "\t");
					break;
				case Types.VARCHAR : 
					System.out.print(rs.getString(colNum) + "\t");
					break;
				case Types.TIMESTAMP : 
					System.out.print(rs.getDate(colNum) + "\t");
					break;
				}
			}
			System.out.println();
		} 
		try { if(rs != null) rs.close(); } catch(SQLException e) {}
		try { if(pstmt != null) pstmt.close(); } catch(SQLException e) {}
		try { if(conn != null) conn.close(); } catch(SQLException e) {}
		try { if(br != null) br.close(); } catch(IOException e) {}
	}
}
