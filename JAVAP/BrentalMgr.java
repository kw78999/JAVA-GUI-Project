package JAVAP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

//DB�� ������ �ʿ��� ��� ���
public class BrentalMgr {
	
	//DB ���� ��ü 10�� ����� ����.
	private DBConnectionMgr pool;
	private PreparedStatement pstmt;
	private String sql;
	
	public BrentalMgr() {
		pool = DBConnectionMgr.getInstance();
	}

	//����Ʈ : 
	//���׸� : Vector�� ����Ǵ� Ÿ���� MemberBean ����(�ɼ�)
	public Vector<BrentalBean> getListBRental(){
		//DB���� ���� ����
		Connection con = null;//DB���� ��ü
		PreparedStatement pstmt = null;//sql�� ����� ��ü
		ResultSet rs = null;//select�� ���� ����� ���� ��ü
		String sql = null;
		Vector<BrentalBean> vlist = new Vector<BrentalBean>();
		try {
			//pool ��ü���� ������
			con = pool.getConnection();
			//sql�� ����
			sql = "select * from BRENTAL order by 1";
			//DB�� �����ϱ� ���� pstmt�� ����
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();//DB ���� �� ����� ����
			while(rs.next()/*���� cursor���� ���� cursor�� �̵�*/) {
				BrentalBean bean = new BrentalBean();
				bean.setRID(rs.getInt("RID"));
				bean.setRMID(rs.getInt("RMID"));
				bean.setRNAME(rs.getString("RNAME"));
				bean.setBMID(rs.getInt("BMID"));
				bean.setBTITLE(rs.getString("BTITLE"));
				bean.setRENTAL(rs.getString("RENTAL"));
				bean.setENDRENTAL(rs.getString("ENDRENTAL"));
				
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
	
	//�����ȣ �˻� 
	public BrentalBean  getett(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		BrentalBean bean  = new BrentalBean();
		try {
			con = pool.getConnection();
			sql = "select * from Brental where RID=?";
			//�Ű����� idx�� ù��° ?�� ����
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
			MDialog md = new MDialog(SwingProject.frame, "����",true	, "�˻� ����� �����ϴ�");
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
			//�Ű����� idx�� ù��° ?�� ����
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
			MDialog md = new MDialog(SwingProject.frame, "����",true	, "�˻� ����� �����ϴ�");
			md.setVisible(true);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	//ȸ����ȣ �˻� 
	public Vector<BrentalBean>  getett2(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector <BrentalBean> vlist = new Vector<BrentalBean>();
	
		try {
			con = pool.getConnection();
			sql = "select * from Brental where RMID=?";
			//�Ű����� idx�� ù��° ?�� ����
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
	
	//�Է�
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

	//����
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
	
	//����
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















