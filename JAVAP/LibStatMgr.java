package JAVAP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

//DB�� ������ �ʿ��� ��� ���
public class LibStatMgr {
	
	//DB ���� ��ü 10�� ����� ����.
	private DBConnectionMgr pool;
	
	public LibStatMgr() {
		pool = DBConnectionMgr.getInstance();
	}

	//����Ʈ : 
	//���׸� : Vector�� ����Ǵ� Ÿ���� MemberBean ����(�ɼ�)
	public Vector<LibStatBean> getListStat(){
		//DB���� ���� ����
		Connection con = null;//DB���� ��ü
		PreparedStatement pstmt = null;//sql�� ����� ��ü
		ResultSet rs = null;//select�� ���� ����� ���� ��ü
		String sql = null;
		Vector<LibStatBean> vlist = new Vector<LibStatBean>();
		try {
			//pool ��ü���� ������
			con = pool.getConnection();
			//sql�� ����
			sql = "select * from libstat order by yea desc, mon desc";
			//DB�� �����ϱ� ���� pstmt�� ����
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();//DB ���� �� ����� ����
			while(rs.next()/*���� cursor���� ���� cursor�� �̵�*/) {
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
				//���ڵ带 �����Ų ��� Vector�� ����
				vlist.addElement(bean);
			}//---while
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//con�� �ݳ�, pstmt�̶� rs�� close �ؾ���.
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	//���� ����� �Է¹޾� �� �� ��������
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
	
	//���� ���Ź�ư�� ���� ������ ���� �޼ҵ�
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
	
	
	//��Ʈ1 Y�� ���ذ� �������� (�ְ�ġ�� 100������ �߶�)
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
	//��Ʈ2 Y�� ���ذ� ��������
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
	
	//20�� and 10~5�� ������
	public Vector<LibStatBean> getChart1Data(){
		//DB���� ���� ����
		Connection con = null;//DB���� ��ü
		PreparedStatement pstmt = null;//sql�� ����� ��ü
		ResultSet rs = null;//select�� ���� ����� ���� ��ü
		String sql = null;
		Vector<LibStatBean> vlist = new Vector<LibStatBean>();
		try {
			//pool ��ü���� ������
			con = pool.getConnection();
			//sql�� ����
			sql = "select mon, cnt from libstat where mon in ('10��', '09��', '08��', '07��', '06��', '05��') and yea in ('20��')order by mon desc";
			//DB�� �����ϱ� ���� pstmt�� ����
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();//DB ���� �� ����� ����
			while(rs.next()/*���� cursor���� ���� cursor�� �̵�*/) {
				LibStatBean bean = new LibStatBean();
				bean.setCnt(rs.getString("cnt"));
				//���ڵ带 �����Ų ��� Vector�� ����
				vlist.addElement(bean);
			}//---while
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//con�� �ݳ�, pstmt�̶� rs�� close �ؾ���.
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	//������ �׷��� ����
		public LibStatBean  getMonthStat1() {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			LibStatBean bean = new LibStatBean();
			try {
				con = pool.getConnection();
				sql = "select * from libstat where mon='10��' and yea='20��'";
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















