package libSearchProgram;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

//DB와 연동에 필요한 모든 기능
public class BMEMBERSMgr {
	
	//DB 연결 객체 10개 만들어 놓음.
	private DBConnectionMgr pool;
	
	public BMEMBERSMgr() {
		pool = DBConnectionMgr.getInstance();
	}

	//리스트 : 
	//제네릭 : Vector에 저장되는 타입을 MemberBean 지정(옵션)
	public Vector<BMEMBERSBean> getListMember(){
		//DB연결 실행 공식
		Connection con = null;//DB연결 객체
		PreparedStatement pstmt = null;//sql문 만드는 객체
		ResultSet rs = null;//select문 실행 결과값 리턴 객체
		String sql = null;
		Vector<BMEMBERSBean> vlist = new Vector<BMEMBERSBean>();
		try {
			//pool 객체에서 빌려옴
			con = pool.getConnection();
			//sql문 선언
			sql = "select * from BMEMBERS order by 1";
			//DB에 실행하기 위해 pstmt문 생성
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();//DB 실행 후 결과값 리턴
			while(rs.next()/*현재 cursor에서 다음 cursor로 이동*/) {
				BMEMBERSBean bean = new BMEMBERSBean();
				bean.setMID(rs.getInt("MID"));
				bean.setMNAME(rs.getString("MNAME"));
				bean.setMGRADE(rs.getString("MGRADE"));
				bean.setMPHONE(rs.getString("MPHONE"));
				bean.setMAXRENTAL(rs.getString("MAXRENTAL"));
				bean.setECOUNT(rs.getString("ECOUNT"));
				bean.setELIMIT(rs.getString("ELIMIT"));
				
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
	
	//레코드 한개 가져오기
	public BMEMBERSBean  getett(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		BMEMBERSBean bean = new BMEMBERSBean();
		try {
			con = pool.getConnection();
			sql = "select * from BMEMBERS where MID=?";
			//매개변수 idx를 첫번째 ?에 세팅
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setMID(rs.getInt("MID"));//테이블 스키마 인텍스
				bean.setMNAME(rs.getString("MNAME"));
				bean.setMGRADE(rs.getString("MGRADE"));
				bean.setMPHONE(rs.getString("MPHONE"));
				bean.setMAXRENTAL(rs.getString("MAXRENTAL"));
				bean.setECOUNT(rs.getString("ECOUNT"));
				bean.setELIMIT(rs.getString("ELIMIT"));

				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	
	//입력
	public boolean insertBMEMBERS(BMEMBERSBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "insert into BMEMBERS(MID,MNAME,MPHONE,MGRADE,MAXRENTAL,ECOUNT,ECOUNTP,ELIMIT)"
					+ "values(seqmember.nextval,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getMNAME());
			pstmt.setString(2, bean.getMPHONE());
			pstmt.setString(3, bean.getMGRADE());
			pstmt.setString(4, bean.getMAXRENTAL());
			pstmt.setString(5, bean.getECOUNT());
			pstmt.setString(6, bean.getECOUNTP());
			pstmt.setString(7, bean.getELIMIT());
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
	public boolean updateBMEMBERS(BMEMBERSBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "update BMEMBERS set MNAME=?, MPHONE=?, MGRADE=? ,MAXRENTAL=?, ECOUNT=?, ECOUNTP=?, ELIMIT=?"
					+ "where MID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getMNAME());
			pstmt.setString(2, bean.getMPHONE());
			pstmt.setString(3, bean.getMGRADE());
			pstmt.setString(4, bean.getMAXRENTAL());
			pstmt.setString(5, bean.getECOUNT());
			pstmt.setString(6, bean.getECOUNTP());
			pstmt.setString(7, bean.getELIMIT());
			pstmt.setInt(8, bean.getMID());
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
	public boolean deleteBMEMBERS(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "delete from BMEMBERS where MID=?";
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
	
	//투표버튼 눌렀을 때 회원번호로 조회 (레코드 한개 가져오기 메소드 변형)
	public BMEMBERSBean  idCheck(int idx) {
		System.out.println("전달받은 정수: "+idx);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		BMEMBERSBean bean = new BMEMBERSBean();
		try {
			con = pool.getConnection();
			sql = "select MID, MNAME from BMEMBERS where MID=?";
			//매개변수 idx를 첫번째 ?에 세팅
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setMID(rs.getInt("MID"));//테이블 스키마 인텍스
				bean.setMNAME(rs.getString("MNAME"));
				System.out.println("빈즈에 담은 MID: "+bean.getMID());
				System.out.println("빈즈에 담은 MNAME: "+bean.getMNAME());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}

	
	
	
	public Vector<BooksBean> getListbooks() {
		return null;
	}


	}















