package JAVAP;

//빈즈네이밍 : 테이블명+Bean
//빈즈 : 레코드(한줄) 단위를 데이터 덩어리
public class BMEMBERSBean {

	private static final int Idx = 0;
	private int MID;
	public int getMID() {
		return MID;
	}
	private String MNAME;
	private String MGRADE;
	private String MPHONE;
	private int MAXRENTAL;
	private int ECOUNT;
	private String ECOUNTP;
	private int ELIMIT;
	
	                 //getXxx
	public int getIdx() {
		return Idx;
	}                 
	                   //setXxx(타입 컬럼명)
	public void setMID(int MID) {
		this.MID = MID;
	}
	public String getMNAME() {
		return MNAME;
	}
	public void setMNAME(String MNAME) {
		this.MNAME = MNAME;
	}
	public String getMPHONE() {
		return MPHONE;
	}
	public void setMPHONE(String MPHONE) {
		this.MPHONE = MPHONE;
	}
	public String getMGRADE() {
		return MGRADE;
	}
	public void setMGRADE(String MGRADE) {
		this.MGRADE = MGRADE;
	}
	public int getMAXRENTAL() {
		return MAXRENTAL;
	}
	public void setMAXRENTAL(int MAXRENTAL) {
		this.MAXRENTAL = MAXRENTAL;
	}
	public int getECOUNT() {
		return ECOUNT;
	}
	public void setECOUNT(int ECOUNT) {
		this.ECOUNT = ECOUNT;
		}
	public String getECOUNTP() {
		return ECOUNTP;
	}
	public void setECOUNTP(String ECOUNTP) {
		this.ECOUNTP = ECOUNTP;
	}
	public int getELIMIT() {
			return ELIMIT;
		}
	public void setELIMIT(int ELIMIT) {
			this.ELIMIT = ELIMIT;
		}
	}
