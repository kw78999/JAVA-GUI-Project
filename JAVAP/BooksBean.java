 	package JAVAP;

import java.util.Vector;
//빈즈네이밍 : 테이블명+Bean
//빈즈 : 레코드(한줄) 단위를 데이터 덩어리
public class BooksBean {

	private static final int Idx = 0;
	private int BID;
	
	private String ISBN;
	private String TITLE;
	private String AUTHOR;
	private String PUBLISHER;
	private String LOCATION;
	private String BOOKSTATE;
	private String BCOPY;
	private String BDATE;
	private int BCOUNT;
	private String BIMAGE;
	private String CATE;
	
	                 //getXxx
	public int getIdx() {
		return Idx;
	}                
	public int getBID() {
		return BID;
	}
	                   //setXxx(타입 컬럼명)
	public void setBID(int BID) {
		this.BID = BID;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public String getAUTHOR() {
		return AUTHOR;
	}
	public void setAUTHOR(String AUTHOR) {
		this.AUTHOR = AUTHOR;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String TITLE) {
		this.TITLE = TITLE;
	}
	public String getPUBLISHER() {
		return PUBLISHER;
	}
	public void setPUBLISHER(String PUBLISHER) {
		this.PUBLISHER = PUBLISHER;
	}
	public String getLOCATION() {
		return LOCATION;
	}
	public void setLOCATION(String LOCATION) {
		this.LOCATION = LOCATION;
		}
	public String getBOOKSTATE() {
		return BOOKSTATE;
	}
	public void setBOOKSTATE(String BOOKSTATE) {
		this.BOOKSTATE = BOOKSTATE;
	}
	public String getBCOPY() {
			return BCOPY;
		}
	public void setBCOPY(String BCOPY) {
			this.BCOPY = BCOPY;
		}
	public String getBDATE() {
		return BDATE;
	}
    public void setBDATE(String BDATE) {
		this.BDATE = BDATE;
	}
	public int getBCOUNT() {
		return BCOUNT;
	}
    public void setBCOUNT(int BCOUNT) {
		this.BCOUNT = BCOUNT;		
	}

    public String getBIMAGE() {
		return BIMAGE;
	}
    public void setBIMAGE(String BIMAGE) {
		this.BIMAGE = BIMAGE;	
    }
    public String getCATE() {
  		return CATE;
  	}
      public void setCATE(String CATE) {
  		this.CATE = CATE;	
      }
	public int size() {
		return 0;
	}
	public BooksBean elementAt(int j) {
		return null;
	}
	public void setVTITLE(String string) {
	}
	public void setVPUBLISHER(String string) {
	}
	public void setVAUTHOR(String string) {
	}
	public void setVLIKE(String string) {
	}
	public void setVISBN(String string) {
	}

}

