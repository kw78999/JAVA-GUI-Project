package JAVAP;

import java.util.Vector;
//������̹� : ���̺��+Bean
//���� : ���ڵ�(����) ������ ������ ���
public class BrentalBean {

	private static final int Idx = 0;
	private int RID;
	private int RMID;
	private String RNAME;
	private int BMID;
	private String BTITLE;
	private String RENTAL;
	private String ENDRENTAL;

	
	public int getRID() {
		return RID;
	}
	                 //getXxx
	public int getIdx() {
		return Idx;
	}                 
	                   //setXxx(Ÿ�� �÷���)
	public void setRID(int RID) {
		this.RID = RID;
	}
	public int getRMID() {
		return RMID;
	}
	public void setRMID(int RMID) {
		this.RMID = RMID;
	}
	public String getRNAME() {
		return RNAME;
	}
	public void setRNAME(String RNAME) {
		this.RNAME = RNAME;
	}
	public void setBMID(int BMID) {
		this.BMID = BMID;
	}
	public int getBMID() {
		return BMID;
	}

	public String getBTITLE() {
		return BTITLE;
	}
	public void setBTITLE(String BTITLE) {
		this.BTITLE = BTITLE;
	}
	
	
	public String getRENTAL() {
		return RENTAL;
	}
	public void setRENTAL(String RENTAL) {
		this.RENTAL = RENTAL;
	}
	public String getENDRENTAL() {
		return ENDRENTAL;
	}
	public void setENDRENTAL(String ENDRENTAL) {
		this.ENDRENTAL = ENDRENTAL;
	}
	
	public int size() {
		return 0;
	}
	public BrentalBean elementAt(int j) {
		return null;
	}
	
}

