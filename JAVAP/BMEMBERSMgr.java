package JAVAP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

//DB�� ������ �ʿ��� ��� ���
public class BMEMBERSMgr {
	
	//DB ���� ��ü 10�� ����� ����.
	private DBConnectionMgr pool;
	
	public BMEMBERSMgr() {
		pool = DBConnectionMgr.getInstance();
	}

	//����Ʈ : 
	//���׸� : Vector�� ����Ǵ� Ÿ���� MemberBean ����(�ɼ�)
	public Vector<BMEMBERSBean> getListMember(){
		//DB���� ���� ����
		Connection con = null;//DB���� ��ü
		PreparedStatement pstmt = null;//sql�� ����� ��ü
		ResultSet rs = null;//select�� ���� ����� ���� ��ü
		String sql = null;
		Vector<BMEMBERSBean> vlist = new Vector<BMEMBERSBean>();
		try {
			//pool ��ü���� ������
			con = pool.getConnection();
			//sql�� ����
			sql = "select * from BMEMBERS order by 1";
			//DB�� �����ϱ� ���� pstmt�� ����
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();//DB ���� �� ����� ����
			while(rs.next()/*���� cursor���� ���� cursor�� �̵�*/) {
				BMEMBERSBean bean = new BMEMBERSBean();
				bean.setMID(rs.getInt("MID"));
				bean.setMNAME(rs.getString("MNAME"));
				bean.setMGRADE(rs.getString("MGRADE"));
				bean.setMPHONE(rs.getString("MPHONE"));
				bean.setMAXRENTAL(rs.getInt("MAXRENTAL"));
				bean.setECOUNT(rs.getInt("ECOUNT"));
				bean.setELIMIT(rs.getInt("ELIMIT"));
				
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
	//���ڵ� �Ѱ� ��������
	public BMEMBERSBean  getett(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		BMEMBERSBean bean = new BMEMBERSBean();
		try {
			con = pool.getConnection();
			sql = "select * from BMEMBERS where MID=?";
			//�Ű����� idx�� ù��° ?�� ����
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setMID(rs.getInt(1));//���̺� ��Ű�� ���ؽ�
				bean.setMNAME(rs.getString(2));
				bean.setMGRADE(rs.getString(3));
				bean.setMPHONE(rs.getString(4));
				bean.setMAXRENTAL(rs.getInt(5));
				bean.setECOUNT(rs.getInt(6));
				bean.setELIMIT(rs.getInt(7));

				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	//���ڷ� �˻��ϱ� 
	public Vector<BMEMBERSBean> search(String str) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector <BMEMBERSBean> vlist = new Vector<BMEMBERSBean>();
		try {
			con = pool.getConnection();
			sql = "select * from BMEMBERS where MNAME like ?";
			//�Ű����� idx�� ù��° ?�� ����
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+str+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BMEMBERSBean bean = new BMEMBERSBean();
				bean.setMID(rs.getInt("MID"));//���̺� ��Ű�� ���ؽ�
				bean.setMNAME(rs.getString("MNAME"));
				bean.setMGRADE(rs.getString("MGRADE"));
				bean.setMPHONE(rs.getString("MPHONE"));
				bean.setMAXRENTAL(rs.getInt("MAXRENTAL"));
				bean.setECOUNT(rs.getInt("ECOUNT"));
				bean.setELIMIT(rs.getInt("ELIMIT"));

				vlist.addElement(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	//ȸ�� ����ϴ� �޼ҵ� �����Ͼ� õ
	//�Է�
	public boolean insertBMEMBERS(BMEMBERSBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "insert into BMEMBERS(MNAME,MPHONE,MGRADE,MAXRENTAL,ECOUNT,ELIMIT)"
					+ " values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getMNAME());
			pstmt.setString(2, bean.getMPHONE());
			pstmt.setString(3, bean.getMGRADE());
			pstmt.setInt(4, bean.getMAXRENTAL());
			pstmt.setInt(5, bean.getECOUNT());
			pstmt.setInt(6, bean.getELIMIT());
			int cnt = pstmt.executeUpdate();//insert,update,delete
			if(cnt==1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}

	//����
	public boolean updateBMEMBERS(BMEMBERSBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "update BMEMBERS set MNAME=?, MPHONE=?, MGRADE=? ,MAXRENTAL=?, ECOUNT=?, ELIMIT=? "
					+ "where MID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getMNAME());
			pstmt.setString(2, bean.getMPHONE());
			pstmt.setString(3, bean.getMGRADE());
			pstmt.setInt(4, bean.getMAXRENTAL());
			pstmt.setInt(5, bean.getECOUNT());
			pstmt.setInt(6, bean.getELIMIT());
			pstmt.setInt(7, bean.getMID());
			int cnt = pstmt.executeUpdate();//insert,update,delete
			if(cnt==1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	//����� ����Ƚ���� ���Ⱑ�ɱǼ��� �����ϴ� �޼ҵ� 
	public boolean stateupdateBMEMBERS(BMEMBERSBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "update BMEMBERS set ECOUNT=?, ELIMIT=? "
					+ "where MID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bean.getECOUNT());
			pstmt.setInt(2, bean.getELIMIT());
			pstmt.setInt(3, bean.getMID());
			int cnt = pstmt.executeUpdate();//insert,update,delete
			if(cnt==1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	//������ õ��� ��� ������ �� ���� �۵���
	//����
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

	public Vector<BooksBean> getListbooks() {
		return null;
	}


	}