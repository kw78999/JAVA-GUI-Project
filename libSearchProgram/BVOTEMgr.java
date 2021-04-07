package libSearchProgram;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

//DB와 연동에 필요한 모든 기능
public class BVOTEMgr {
	
	//DB 연결 객체 10개 만들어 놓음.
	private DBConnectionMgr pool;
	private PreparedStatement pstmt;
	private String sql;
	
	public BVOTEMgr() {
		pool = DBConnectionMgr.getInstance();
	}

	//리스트 : 
	//제네릭 : Vector에 저장되는 타입을 MemberBean 지정(옵션)
	public Vector<BVOTEBean> getListVote(){
		//DB연결 실행 공식
		Connection con = null;//DB연결 객체
		PreparedStatement pstmt = null;//sql문 만드는 객체
		ResultSet rs = null;//select문 실행 결과값 리턴 객체
		String sql = null;
		Vector<BVOTEBean> vlist = new Vector<BVOTEBean>();
		try {
			//pool 객체에서 빌려옴
			con = pool.getConnection();
			//sql문 선언
			sql = "select * from BVOTE order by VLIKE DESC";
			//DB에 실행하기 위해 pstmt문 생성
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();//DB 실행 후 결과값 리턴
			while(rs.next()/*현재 cursor에서 다음 cursor로 이동*/) {
				BVOTEBean bean = new BVOTEBean();
				bean.setVTITLE(rs.getString("VTITLE"));
				bean.setVAUTHOR(rs.getString("VAUTHOR"));
				bean.setVPUBLISHER(rs.getString("VPUBLISHER"));
				bean.setVLIKE(rs.getInt("VLIKE"));
				bean.setVISBN(rs.getString("VISBN"));
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
	
	public Vector<BVOTEBean> getLikeBook2(String bTitle){
		//DB연결 실행 공식
		Connection con = null;//DB연결 객체
		PreparedStatement pstmt = null;//sql문 만드는 객체
		ResultSet rs = null;//select문 실행 결과값 리턴 객체
		String sql = null;
		Vector<BVOTEBean> vlist = new Vector<BVOTEBean>();
		try {
			//pool 객체에서 빌려옴
			con = pool.getConnection();
			//sql문 선언
			sql = "select * from BVOTE where VTITLE like ? order by VLIKE desc";
			
			//DB에 실행하기 위해 pstmt문 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+bTitle+"%");
			rs = pstmt.executeQuery();//DB 실행 후 결과값 리턴
			while(rs.next()/*현재 cursor에서 다음 cursor로 이동*/) {
				BVOTEBean bean = new BVOTEBean();
				bean.setVTITLE(rs.getString("VTITLE"));
				bean.setVAUTHOR(rs.getString("VAUTHOR"));
				bean.setVPUBLISHER(rs.getString("VPUBLISHER"));
				bean.setVLIKE(rs.getInt("VLIKE"));
				bean.setVISBN(rs.getString("VISBN"));
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
	
	
	//도서명으로 좋아요 개수 가져오기
	public BVOTEBean  getBookLike(String bTitle) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		BVOTEBean bean = new BVOTEBean();
		try {
			con = pool.getConnection();
			sql = "select * from BVOTE where VTITLE=?";
			//매개변수 idx를 첫번째 ?에 세팅
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bTitle);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//bean.setBID(rs.getInt(1));//테이블 스키마 인텍스
				bean.setVTITLE(rs.getString(1));
				bean.setVAUTHOR(rs.getString(2));
				bean.setVPUBLISHER(rs.getString(3));
				bean.setVLIKE(rs.getInt(4));
				bean.setVISBN(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	//도서명으로 좋아요 개수 가져오기
		public BVOTEBean  getBookLike8(String VTITLE) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			BVOTEBean bean = new BVOTEBean();
			try {
				con = pool.getConnection();
				sql = "select * from BVOTE where VTITLE=?";
				//매개변수 idx를 첫번째 ?에 세팅
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, VTITLE);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					//bean.setBID(rs.getInt(1));//테이블 스키마 인텍스
					bean.setVTITLE(rs.getString(1));
					bean.setVAUTHOR(rs.getString(2));
					bean.setVPUBLISHER(rs.getString(3));
					bean.setVLIKE(rs.getInt(4));
					bean.setVISBN(rs.getString(5));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return bean;
		}
	//입력
	public boolean insertBVOTE(BVOTEBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "insert into BVOTE(VTITLE,VAUTHOR,VPUBLISHER,VLIKE,VISBN)"
					+ "values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getVTITLE());
			pstmt.setString(2, bean.getVAUTHOR());
			pstmt.setString(3, bean.getVPUBLISHER());
			pstmt.setInt(4, bean.getVLIKE());
			pstmt.setString(5, bean.getVISBN());
			int cnt = pstmt.executeUpdate();//insert,update,delete
			if(cnt==1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}

	//좋아요 업데이트
	public boolean updateBVOTE(BVOTEBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql =null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "update BVOTE set VLIKE=? where VTITLE=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bean.getVLIKE());
			pstmt.setString(2, bean.getVTITLE());
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
	public boolean deleteBVOTE(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "delete from BVOTE where VTITLE=?";
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
	
	public Vector<BVOTEBean> getListVote(String Title){
		//DB연결 실행 공식
		Connection con = null;//DB연결 객체
		PreparedStatement pstmt = null;//sql문 만드는 객체
		ResultSet rs = null;//select문 실행 결과값 리턴 객체
		String sql = null;
		Vector<BVOTEBean> vlist = new Vector<BVOTEBean>();
		try {
			//pool 객체에서 빌려옴
			con = pool.getConnection();
			//sql문 선언
			sql = "select vtitle, vauthor, vpublisher, vlike from bvote where vtitle=?";
			//DB에 실행하기 위해 pstmt문 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Title);
			rs = pstmt.executeQuery();//DB 실행 후 결과값 리턴
			while(rs.next()/*현재 cursor에서 다음 cursor로 이동*/) {
				BVOTEBean bean = new BVOTEBean();
				bean.setVTITLE(rs.getString("VTITLE"));
				bean.setVAUTHOR(rs.getString("VAUTHOR"));
				bean.setVPUBLISHER(rs.getString("VPUBLISHER"));
				bean.setVLIKE(rs.getInt("VLIKE"));
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
	
	
	public Vector<BooksBean> getListBook() {
		return null;
	} 
}















