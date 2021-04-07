package JAVAP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OracleConnection {
	
	private DBConnectionMgr pool;
	
	public OracleConnection() {
		pool = DBConnectionMgr.getInstance(); 
	}

	public void getList() {
		//java.sql ÆÐÅ°Áö
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "select * from books,bmembers,brental";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String msg = rs.getString(1)+"\t";
				msg+=rs.getString(2)+"\t";
				msg+=rs.getString(3)+"\t";
				msg+=rs.getString(4);
				System.out.println(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
	}
	
	public static void main(String[] args) {
		OracleConnection ora = new OracleConnection();
		ora.getList();
	}
}





