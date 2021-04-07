package libSearchProgram;

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
			sql = "select * from libstat order by 2 desc";
			//DB�� �����ϱ� ���� pstmt�� ����
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();//DB ���� �� ����� ����
			while(rs.next()/*���� cursor���� ���� cursor�� �̵�*/) {
				LibStatBean bean = new LibStatBean();
				bean.setYear(rs.getString("year"));
				bean.setMonth(rs.getString("month"));
				bean.setCount(rs.getString("count"));
				bean.setFst(rs.getString("first"));
				bean.setScd(rs.getString("second"));
				bean.setThd(rs.getString("third"));
				bean.setPopCate(rs.getString("popCate"));
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
	
	//���� ���� �Է¹޾� �� �� ��������
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
	
	//���� ���Ź�ư�� ���� ������ ���� �޼ҵ�
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
	
	
	//��Ʈ1 �̿��� �� ��������
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















