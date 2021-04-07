package libSearchProgram;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

//DB와 연동에 필요한 모든 기능
public class LibStatMgr {
	
	//DB 연결 객체 10개 만들어 놓음.
	private DBConnectionMgr pool;
	
	public LibStatMgr() {
		pool = DBConnectionMgr.getInstance();
	}

	//리스트 : 
	//제네릭 : Vector에 저장되는 타입을 MemberBean 지정(옵션)
	public Vector<LibStatBean> getListStat(){
		//DB연결 실행 공식
		Connection con = null;//DB연결 객체
		PreparedStatement pstmt = null;//sql문 만드는 객체
		ResultSet rs = null;//select문 실행 결과값 리턴 객체
		String sql = null;
		Vector<LibStatBean> vlist = new Vector<LibStatBean>();
		try {
			//pool 객체에서 빌려옴
			con = pool.getConnection();
			//sql문 선언
			sql = "select * from libstat order by 2 desc";
			//DB에 실행하기 위해 pstmt문 생성
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();//DB 실행 후 결과값 리턴
			while(rs.next()/*현재 cursor에서 다음 cursor로 이동*/) {
				LibStatBean bean = new LibStatBean();
				bean.setYear(rs.getString("year"));
				bean.setMonth(rs.getString("month"));
				bean.setCount(rs.getString("count"));
				bean.setFst(rs.getString("first"));
				bean.setScd(rs.getString("second"));
				bean.setThd(rs.getString("third"));
				bean.setPopCate(rs.getString("popCate"));
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
	
	//단위 월을 입력받아 한 행 가져오기
	public LibStatBean  getMonthStat(String month) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		LibStatBean bean = new LibStatBean();
		try {
			con = pool.getConnection();
			sql = "select * from libstat where month=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, month);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setYear(rs.getString("1"));
				bean.setMonth(rs.getString("2"));
				bean.setCount(rs.getString("3"));
				bean.setFst(rs.getString("4"));
				bean.setScd(rs.getString("5"));
				bean.setThd(rs.getString("6"));
				bean.setPopCate(rs.getString("7"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	
	//월말 갱신버튼에 넣을 데이터 삽입 메소드
	public boolean insertStat(LibStatBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "insert into libstat(year, month, count, first, popcate)"
					+ "values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getYear());
			pstmt.setString(2, bean.getMonth());
			pstmt.setString(3, bean.getCount());
			pstmt.setString(4, bean.getFst());
			pstmt.setString(5, bean.getScd());
			pstmt.setString(6, bean.getThd());
			pstmt.setString(7, bean.getPopCate());
			int cnt = pstmt.executeUpdate();//insert,update,delete
			if(cnt==1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	
	//차트1 이용자 수 가져오기
	public LibStatBean getChart1() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		LibStatBean bean = new LibStatBean();
		try {
			con = pool.getConnection();
			sql = "select * from libstat";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setMonth(rs.getString("2"));
				bean.setCount(rs.getString("3"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	
	public Vector<LibStatBean> getListbooks() {
		return null;
	}

	}















