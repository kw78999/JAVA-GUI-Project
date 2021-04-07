package libSearchProgram;

//빈즈네이밍 : 테이블명+Bean
//빈즈 : 레코드(한줄) 단위를 데이터 덩어리
public class BMEMBERSBean {

	private int MID;
	private String MNAME;
	private String MGRADE;
	private String MPHONE;
	private String MAXRENTAL;
	private String ECOUNT;
	private String ECOUNTP;
	private String ELIMIT;
	
	
	public int getMID() {
		return MID;
	}           
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
	public String getMAXRENTAL() {
		return MAXRENTAL;
	}
	public void setMAXRENTAL(String MAXRENTAL) {
		this.MAXRENTAL = MAXRENTAL;
	}
	public String getECOUNT() {
		return ECOUNT;
	}
	public void setECOUNT(String ECOUNT) {
		this.ECOUNT = ECOUNT;
		}
	public String getECOUNTP() {
		return ECOUNTP;
	}
	public void setECOUNTP(String ECOUNTP) {
		this.ECOUNTP = ECOUNTP;
	}
	public String getELIMIT() {
			return ELIMIT;
		}
	public void setELIMIT(String ELIMIT) {
			this.ELIMIT = ELIMIT;
		}
	}
