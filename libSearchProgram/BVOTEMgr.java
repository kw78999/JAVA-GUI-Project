package libSearchProgram;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

//DB�� ������ �ʿ��� ��� ���
public class BVOTEMgr {
	
	//DB ���� ��ü 10�� ����� ����.
	private DBConnectionMgr pool;
	private PreparedStatement pstmt;
	private String sql;
	
	public BVOTEMgr() {
		pool = DBConnectionMgr.getInstance();
	}

	//����Ʈ : 
	//���׸� : Vector�� ����Ǵ� Ÿ���� MemberBean ����(�ɼ�)
	public Vector<BVOTEBean> getListVote(){
		//DB���� ���� ����
		Connection con = null;//DB���� ��ü
		PreparedStatement pstmt = null;//sql�� ����� ��ü
		ResultSet rs = null;//select�� ���� ����� ���� ��ü
		String sql = null;
		Vector<BVOTEBean> vlist = new Vector<BVOTEBean>();
		try {
			//pool ��ü���� ������
			con = pool.getConnection();
			//sql�� ����
			sql = "select * from BVOTE order by VLIKE DESC";
			//DB�� �����ϱ� ���� pstmt�� ����
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();//DB ���� �� ����� ����
			while(rs.next()/*���� cursor���� ���� cursor�� �̵�*/) {
				BVOTEBean bean = new BVOTEBean();
				bean.setVTITLE(rs.getString("VTITLE"));
				bean.setVAUTHOR(rs.getString("VAUTHOR"));
				bean.setVPUBLISHER(rs.getString("VPUBLISHER"));
				bean.setVLIKE(rs.getInt("VLIKE"));
				bean.setVISBN(rs.getString("VISBN"));
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
	
	public Vector<BVOTEBean> getLikeBook2(String bTitle){
		//DB���� ���� ����
		Connection con = null;//DB���� ��ü
		PreparedStatement pstmt = null;//sql�� ����� ��ü
		ResultSet rs = null;//select�� ���� ����� ���� ��ü
		String sql = null;
		Vector<BVOTEBean> vlist = new Vector<BVOTEBean>();
		try {
			//pool ��ü���� ������
			con = pool.getConnection();
			//sql�� ����
			sql = "select * from BVOTE where VTITLE like ? order by VLIKE desc";
			
			//DB�� �����ϱ� ���� pstmt�� ����
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+bTitle+"%");
			rs = pstmt.executeQuery();//DB ���� �� ����� ����
			while(rs.next()/*���� cursor���� ���� cursor�� �̵�*/) {
				BVOTEBean bean = new BVOTEBean();
				bean.setVTITLE(rs.getString("VTITLE"));
				bean.setVAUTHOR(rs.getString("VAUTHOR"));
				bean.setVPUBLISHER(rs.getString("VPUBLISHER"));
				bean.setVLIKE(rs.getInt("VLIKE"));
				bean.setVISBN(rs.getString("VISBN"));
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
	
	
	//���������� ���ƿ� ���� ��������
	public BVOTEBean  getBookLike(String bTitle) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		BVOTEBean bean = new BVOTEBean();
		try {
			con = pool.getConnection();
			sql = "select * from BVOTE where VTITLE=?";
			//�Ű����� idx�� ù��° ?�� ����
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bTitle);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//bean.setBID(rs.getInt(1));//���̺� ��Ű�� ���ؽ�
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
	//���������� ���ƿ� ���� ��������
		public BVOTEBean  getBookLike8(String VTITLE) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			BVOTEBean bean = new BVOTEBean();
			try {
				con = pool.getConnection();
				sql = "select * from BVOTE where VTITLE=?";
				//�Ű����� idx�� ù��° ?�� ����
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, VTITLE);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					//bean.setBID(rs.getInt(1));//���̺� ��Ű�� ���ؽ�
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
	//�Է�
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

	//���ƿ� ������Ʈ
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
	
	//����
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
		//DB���� ���� ����
		Connection con = null;//DB���� ��ü
		PreparedStatement pstmt = null;//sql�� ����� ��ü
		ResultSet rs = null;//select�� ���� ����� ���� ��ü
		String sql = null;
		Vector<BVOTEBean> vlist = new Vector<BVOTEBean>();
		try {
			//pool ��ü���� ������
			con = pool.getConnection();
			//sql�� ����
			sql = "select vtitle, vauthor, vpublisher, vlike from bvote where vtitle=?";
			//DB�� �����ϱ� ���� pstmt�� ����
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Title);
			rs = pstmt.executeQuery();//DB ���� �� ����� ����
			while(rs.next()/*���� cursor���� ���� cursor�� �̵�*/) {
				BVOTEBean bean = new BVOTEBean();
				bean.setVTITLE(rs.getString("VTITLE"));
				bean.setVAUTHOR(rs.getString("VAUTHOR"));
				bean.setVPUBLISHER(rs.getString("VPUBLISHER"));
				bean.setVLIKE(rs.getInt("VLIKE"));
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
	
	
	public Vector<BooksBean> getListBook() {
		return null;
	} 
}















