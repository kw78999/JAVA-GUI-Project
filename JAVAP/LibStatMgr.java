package JAVAP;

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
			sql = "select * from libstat order by yea desc, mon desc";
			//DB에 실행하기 위해 pstmt문 생성
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();//DB 실행 후 결과값 리턴
			while(rs.next()/*현재 cursor에서 다음 cursor로 이동*/) {
				LibStatBean bean = new LibStatBean();
				bean.setYear(rs.getString("yea"));
				bean.setMon(rs.getString("mon"));
				bean.setCnt(rs.getString("cnt"));
				bean.setFst(rs.getString("fst"));
				bean.setSnd(rs.getString("snd"));
				bean.setThd(rs.getString("thd"));
				bean.setPopCate(rs.getString("popCate"));
				bean.setAvgCnt(rs.getInt("avgCnt"));
				bean.setFstCnt(rs.getInt("fstCnt"));
				bean.setSndCnt(rs.getInt("sndCnt"));
				bean.setThdCnt(rs.getInt("thdCnt"));
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
	
	//단위 년월을 입력받아 한 행 가져오기
	public LibStatBean  getMonthStat(String month, String year) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		LibStatBean bean = new LibStatBean();
		try {
			con = pool.getConnection();
			sql = "select * from libstat where mon=? and yea=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, month);
			pstmt.setString(2, year);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setYear(rs.getString("yea"));
				bean.setMon(rs.getString("mon"));
				bean.setCnt(rs.getString("cnt"));
				bean.setFst(rs.getString("fst"));
				bean.setSnd(rs.getString("snd"));
				bean.setThd(rs.getString("thd"));
				bean.setPopCate(rs.getString("popCate"));
				bean.setAvgCnt(rs.getInt("avgCnt"));
				bean.setFstCnt(rs.getInt("fstCnt"));
				bean.setSndCnt(rs.getInt("sndCnt"));
				bean.setThdCnt(rs.getInt("thdCnt"));
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
			sql = "insert into libstat(yea, mon, cnt, fst, snd, thd, popcate, avgcnt, fstcnt, sndcnt, thdcnt)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getYear());
			pstmt.setString(2, bean.getMon());
			pstmt.setString(3, bean.getCnt());
			pstmt.setString(4, bean.getFst());
			pstmt.setString(5, bean.getSnd());
			pstmt.setString(6, bean.getThd());
			pstmt.setString(7, bean.getPopCate());
			pstmt.setInt(8,bean.getAvgCnt());
			pstmt.setInt(9,bean.getFstCnt());
			pstmt.setInt(10,bean.getSndCnt());
			pstmt.setInt(11,bean.getThdCnt());
			int cnt = pstmt.executeUpdate();//insert,update,delete
			if(cnt==1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	
	//차트1 Y축 기준값 가져오기 (최고치를 100단위로 잘라서)
	public LibStatBean getAxisY1() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		LibStatBean bean = new LibStatBean();
		try {
			con = pool.getConnection();
			sql = "select round(max(cnt),-2) from libstat";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setMaxCount(rs.getInt("round(max(cnt),-2)"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	//차트2 Y축 기준값 가져오기
		public LibStatBean getAxisY2() {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			LibStatBean bean = new LibStatBean();
			try {
				con = pool.getConnection();
				sql = "select fstcnt, sndcnt, thdcnt, avgcnt from libstat where yea=? and mon=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bean.getYear());
				pstmt.setString(2, bean.getMon());				
				rs = pstmt.executeQuery();
				if(rs.next()) {
					bean.setFstCnt(rs.getInt("fstCnt"));
					bean.setSndCnt(rs.getInt("sndCnt"));
					bean.setThdCnt(rs.getInt("thdCnt"));
					bean.setAvgCnt(rs.getInt("avgCnt"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return bean;
		}
	
	//20년 and 10~5월 데이터
	public Vector<LibStatBean> getChart1Data(){
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
			sql = "select mon, cnt from libstat where mon in ('10월', '09월', '08월', '07월', '06월', '05월') and yea in ('20년')order by mon desc";
			//DB에 실행하기 위해 pstmt문 생성
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();//DB 실행 후 결과값 리턴
			while(rs.next()/*현재 cursor에서 다음 cursor로 이동*/) {
				LibStatBean bean = new LibStatBean();
				bean.setCnt(rs.getString("cnt"));
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
	
	//독서왕 그래프 연동
		public LibStatBean  getMonthStat1() {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			LibStatBean bean = new LibStatBean();
			try {
				con = pool.getConnection();
				sql = "select * from libstat where mon='10월' and yea='20년'";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					bean.setYear(rs.getString("yea"));
					bean.setMon(rs.getString("mon"));
					bean.setCnt(rs.getString("cnt"));
					bean.setFst(rs.getString("fst"));
					bean.setSnd(rs.getString("snd"));
					bean.setThd(rs.getString("thd"));
					bean.setPopCate(rs.getString("popCate"));
					bean.setAvgCnt(rs.getInt("avgCnt"));
					bean.setFstCnt(rs.getInt("fstCnt"));
					bean.setSndCnt(rs.getInt("sndCnt"));
					bean.setThdCnt(rs.getInt("thdCnt"));
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















