package JAVAP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import JAVAP.SwingProject_1.SwingProject1_newf;

//DB�� ������ �ʿ��� ��� ���
public class BooksMgr {
	
	//DB ���� ��ü 10�� ����� ����.
	private DBConnectionMgr pool;
	//private PreparedStatement pstmt;
	private String sql;
	
	public BooksMgr() {
		pool = DBConnectionMgr.getInstance();
	}

	//����Ʈ : 
	//���׸� : Vector�� ����Ǵ� Ÿ���� MemberBean ����(�ɼ�)
	public Vector<BooksBean> getListMember(){
		//DB���� ���� ����
		Connection con = null;//DB���� ��ü
		PreparedStatement pstmt = null;//sql�� ����� ��ü
		ResultSet rs = null;//select�� ���� ����� ���� ��ü
		String sql = null;
		Vector<BooksBean> vlist = new Vector<BooksBean>();
		try {
			//pool ��ü���� ������
			con = pool.getConnection();
			//sql�� ����
			sql = "select * from BOOKS order by 1";
			//DB�� �����ϱ� ���� pstmt�� ����
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();//DB ���� �� ����� ����
			while(rs.next()/*���� cursor���� ���� cursor�� �̵�*/) {
				BooksBean bean = new BooksBean();
				bean.setBID(rs.getInt("BID"));
				bean.setISBN(rs.getString("ISBN"));
				bean.setTITLE(rs.getString("TITLE"));
				bean.setAUTHOR(rs.getString("AUTHOR"));
				bean.setPUBLISHER(rs.getString("PUBLISHER"));
				bean.setLOCATION(rs.getString("LOCATION"));
				bean.setBOOKSTATE(rs.getString("BOOKSTATE"));
				bean.setBCOPY(rs.getString("BCOPY"));
				bean.setBDATE(rs.getString("BDATE"));
				bean.setBCOUNT(rs.getInt("BCOUNT"));	
				bean.setBIMAGE(rs.getString("BIMAGE"));	
				bean.setCATE(rs.getString("CATE"));	
				
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
	public BooksBean  getett(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		BooksBean bean = new BooksBean();
		try {
			con = pool.getConnection();
			sql = "select * from Books where BID=?";
			//�Ű����� idx�� ù��° ?�� ����
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setBID(rs.getInt(1));//���̺� ��Ű�� ���ؽ�
				bean.setTITLE(rs.getString(3));
				bean.setAUTHOR(rs.getString(4));
				bean.setPUBLISHER(rs.getString(5));
				bean.setLOCATION(rs.getString(6));				
				bean.setBOOKSTATE(rs.getString(7));
				bean.setBCOUNT(rs.getInt(10));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	//���ڷ� �˻�
	public Vector<BooksBean> getsearch(String sea) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<BooksBean> vlist = new Vector<BooksBean>();
		try {
			con = pool.getConnection();
			sql = "select * from Books where title like ?";
			//�Ű����� idx�� ù��° ?�� ����
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,"%"+sea+"%");
			rs = pstmt.executeQuery();
			while(rs.next()/*���� cursor���� ���� cursor�� �̵�*/) {
				BooksBean bean = new BooksBean();
				bean.setBID(rs.getInt("BID"));
				bean.setISBN(rs.getString("ISBN"));
				bean.setTITLE(rs.getString("TITLE"));
				bean.setAUTHOR(rs.getString("AUTHOR"));
				bean.setPUBLISHER(rs.getString("PUBLISHER"));
				bean.setLOCATION(rs.getString("LOCATION"));
				bean.setBOOKSTATE(rs.getString("BOOKSTATE"));
				bean.setBCOPY(rs.getString("BCOPY"));
				bean.setBDATE(rs.getString("BDATE"));
				bean.setBCOUNT(rs.getInt("BCOUNT"));
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
	//�Է�
	public boolean insertBooks(BooksBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "insert into BOOKS(ISBN,TITLE,AUTHOR,PUBLISHER,LOCATION,BOOKSTATE,BCOPY,BDATE,BCOUNT,BIMAGE,CATE)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			//pstmt.setInt(1, bean.getBID());
			pstmt.setString(1, bean.getISBN());
			pstmt.setString(2, bean.getTITLE());
			pstmt.setString(3, bean.getAUTHOR());
			pstmt.setString(4, bean.getPUBLISHER());
			pstmt.setString(5, bean.getLOCATION());
			pstmt.setString(6, bean.getBOOKSTATE());
			pstmt.setString(7, bean.getBCOPY());
			pstmt.setString(8, bean.getBDATE());
			pstmt.setInt(9, bean.getBCOUNT());
			pstmt.setString(10, bean.getBIMAGE());
			pstmt.setString(11, bean.getCATE());
			int cnt = pstmt.executeUpdate();//insert,update,delete
			if(cnt==1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			MDialog md = new MDialog(SwingProject1_newf.newf, "����", true,"�Է°��� ���ڶ��ϴ�");
			md.setVisible(true);
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}

	//����
	public boolean updateBooks(BooksBean bean) {
		Connection con = null;
		//pstmt = null;
		PreparedStatement pstmt = null;
	    String setSql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			setSql = "update Books set ISBN=? ,TITLE=? ,AUTHOR=? ,PUBLISHER=? ,LOCATION=? ,BOOKSTATE=? ,BCOPY=? ,BDATE=? ,BCOUNT=? "
					+ "where BID=?";
			pstmt = con.prepareStatement(setSql);
			pstmt.setString(1, bean.getISBN());
			pstmt.setString(2, bean.getTITLE());
			pstmt.setString(3, bean.getAUTHOR());
			pstmt.setString(4, bean.getPUBLISHER());
			pstmt.setString(5, bean.getLOCATION());
			pstmt.setString(6, bean.getBOOKSTATE());
			pstmt.setString(7, bean.getBCOPY());
			pstmt.setString(8, bean.getBDATE());
			pstmt.setInt(9, bean.getBCOUNT());
			pstmt.setInt(10, bean.getBID());
			int cnt = pstmt.executeUpdate();//insert,update,delete
			if(cnt==1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	//����� �������¸� �����ϴ� ���� �޼ҵ�
	public boolean stateupdateBooks(BooksBean bean) {
		Connection con = null;
		//pstmt = null;
		PreparedStatement pstmt = null;
	    String setSql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			setSql = "update Books set BOOKSTATE=?,BCOUNT=?"
					+ "where BID=?";
			pstmt = con.prepareStatement(setSql);
			
			pstmt.setString(1, bean.getBOOKSTATE());
			pstmt.setInt(2, bean.getBCOUNT());
			pstmt.setInt(3, bean.getBID());
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
	public boolean deleteBooks(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "delete from Books where BID=?";
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
	public Vector<BooksBean> getListBook() {
		return null;
	} 
}















