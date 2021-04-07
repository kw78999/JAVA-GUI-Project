package JAVAP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

//DB와 연동에 필요한 모든 기능
public class BrentalMgr {
	
	//DB 연결 객체 10개 만들어 놓음.
	private DBConnectionMgr pool;
	private PreparedStatement pstmt;
	private String sql;
	
	public BrentalMgr() {
		pool = DBConnectionMgr.getInstance();
	}

	//리스트 : 
	//제네릭 : Vector에 저장되는 타입을 MemberBean 지정(옵션)
	public Vector<BrentalBean> getListBRental(){
		//DB연결 실행 공식
		Connection con = null;//DB연결 객체
		PreparedStatement pstmt = null;//sql문 만드는 객체
		ResultSet rs = null;//select문 실행 결과값 리턴 객체
		String sql = null;
		Vector<BrentalBean> vlist = new Vector<BrentalBean>();
		try {
			//pool 객체에서 빌려옴
			con = pool.getConnection();
			//sql문 선언
			sql = "select * from BRENTAL order by 1";
			//DB에 실행하기 위해 pstmt문 생성
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();//DB 실행 후 결과값 리턴
			while(rs.next()/*현재 cursor에서 다음 cursor로 이동*/) {
				BrentalBean bean = new BrentalBean();
				bean.setRID(rs.getInt("RID"));
				bean.setRMID(rs.getInt("RMID"));
				bean.setRNAME(rs.getString("RNAME"));
				bean.setBMID(rs.getInt("BMID"));
				bean.setBTITLE(rs.getString("BTITLE"));
				bean.setRENTAL(rs.getString("RENTAL"));
				bean.setENDRENTAL(rs.getString("ENDRENTAL"));
				
				//레코드를 저장시킨 빈즈를 Vector에 저장
				vlist.addElement(bean);
			}//---while
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//con은 반납, pstmt이랑 rs는 close 해야함.
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	//대출번호 검색 
	public BrentalBean  getett(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		BrentalBean bean  = new BrentalBean();
		try {
			con = pool.getConnection();
			sql = "select * from Brental where RID=?";
			//매개변수 idx를 첫번째 ?에 세팅
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setRID(rs.getInt(1));
				bean.setRMID(rs.getInt(2));
				bean.setRNAME(rs.getString(3));
				bean.setBMID(rs.getInt(4));
				bean.setBTITLE(rs.getString(5));
				bean.setRENTAL(rs.getString(6));
				bean.setENDRENTAL(rs.getString(7));	
			}
		} catch (Exception e) {
			e.printStackTrace();
			MDialog md = new MDialog(SwingProject.frame, "오류",true	, "검색 결과가 없습니다");
			md.setVisible(true);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	public BrentalBean  getett3(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		BrentalBean bean  = new BrentalBean();
		try {
			con = pool.getConnection();
			sql = "select * from Brental where BMID=?";
			//매개변수 idx를 첫번째 ?에 세팅
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setRID(rs.getInt(1));
				bean.setRMID(rs.getInt(2));
				bean.setRNAME(rs.getString(3));
				bean.setBMID(rs.getInt(4));
				bean.setBTITLE(rs.getString(5));
				bean.setRENTAL(rs.getString(6));
				bean.setENDRENTAL(rs.getString(7));	
			}
		} catch (Exception e) {
			e.printStackTrace();
			MDialog md = new MDialog(SwingProject.frame, "오류",true	, "검색 결과가 없습니다");
			md.setVisible(true);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	//회원번호 검색 
	public Vector<BrentalBean>  getett2(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector <BrentalBean> vlist = new Vector<BrentalBean>();
	
		try {
			con = pool.getConnection();
			sql = "select * from Brental where RMID=?";
			//매개변수 idx를 첫번째 ?에 세팅
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BrentalBean bean  = new BrentalBean();
				bean.setRID(rs.getInt(1));
				bean.setRMID(rs.getInt(2));
				bean.setRNAME(rs.getString(3));
				bean.setBMID(rs.getInt(4));
				bean.setBTITLE(rs.getString(5));
				bean.setRENTAL(rs.getString(6));
				bean.setENDRENTAL(rs.getString(7));

				vlist.addElement(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	//입력
	public boolean insertBrental(BrentalBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "insert into Brental(RMID,RNAME,BMID,BTITLE,RENTAL,ENDRENTAL)"
					+ "values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bean.getRMID());
			pstmt.setString(2,bean.getRNAME());
			pstmt.setInt(3, bean.getBMID());
			pstmt.setString(4, bean.getBTITLE());
			pstmt.setString(5, bean.getRENTAL());
			pstmt.setString(6, bean.getENDRENTAL());
			
			int cnt = pstmt.executeUpdate();//insert,update,delete
			if(cnt==1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}

	//수정
	public boolean updateBRENTAL(BrentalBean bean) {
		Connection con = null;
		pstmt = null;
		setSql(null);
		boolean flag = false;
		try {
			con = pool.getConnection();
			setSql("update BRENTAL set RMID=? ,RNAME =? ,BMID=? ,BTITLE=?,RENTAL=? ,ENDRENTAL=?"
					+ "where RID=?");
			pstmt.setInt(1, bean.getRMID());
			pstmt.setString(2, bean.getRNAME());
			pstmt.setInt(3, bean.getBMID());
			pstmt.setString(4, bean.getBTITLE());
			pstmt.setString(5, bean.getRENTAL());
			pstmt.setString(6, bean.getENDRENTAL());
			pstmt.setInt(7, bean.getRID());
			int cnt = pstmt.executeUpdate();//insert,update,delete
			if(cnt==1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	//삭제
	public boolean deleterental(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "delete from BRENTAL where RID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			int cnt = pstmt.executeUpdate();
			if(cnt==1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
		
	}
	public Vector<BrentalBean> getListRental() {
		return null;
	} 
}















