package libSearchProgram;

import java.util.Vector;
//������̹� : ���̺��+Bean
//���� : ���ڵ�(����) ������ ������ ���
public class BVOTEBean {

//	private static final int Idx = 0;
//	private int BID;
//	public int getBID() {
//		return BID;
	private String VTITLE;
	private String VAUTHOR;
	private String VPUBLISHER;
	private int VLIKE;
	private String VISBN;

	
	                 //getXxx
	//public int getIdx() {
		//return Idx;
                
	                   //setXxx(Ÿ�� �÷���)
//	public void setBID(int BID) {
//		this.BID = BID;
//	}
	public String getVTITLE() {
		return VTITLE;
	}
	public void setVTITLE(String VTITLE) {
		this.VTITLE = VTITLE;
	}
	public String getVAUTHOR() {
		return VAUTHOR;
	}
	public void setVAUTHOR(String VAUTHOR) {
		this.VAUTHOR = VAUTHOR;

	}
	public String getVPUBLISHER() {
		return VPUBLISHER;
	}
	public void setVPUBLISHER(String VPUBLISHER) {
		this.VPUBLISHER = VPUBLISHER;
	}
	public int getVLIKE() {
		return VLIKE;
	}
	public void setVLIKE(int VLIKE) {
		this.VLIKE = VLIKE;
		}
	public String getVISBN() {
		return VISBN;
	}
	public void setVISBN(String VISBN) {
		this.VISBN = VISBN;
		}
	public int size() {
		return 0;
	}
	public BVOTEBean elementAt(int j) {
		return null;
	}
}

