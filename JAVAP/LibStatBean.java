package JAVAP;

//빈즈네이밍 : 테이블명+Bean
//빈즈 : 레코드(한줄) 단위를 데이터 덩어리
public class LibStatBean {

	private String year;
	private String month;
	private String count;
	private String first;
	private String second;
	private String third;
	private String popCate;
	private int maxCount;
	private int avgCnt;
	private int fstCnt;
	private int sndCnt;
	private int thdCnt;
	
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getCnt() {
		return count;
	}
	public void setCnt(String count) {
		this.count = count;
	}
	public String getMon() {
		return month;
	}
	public void setMon(String month) {
		this.month = month;
	}
	public String getFst() {
		return first;
	}
	public void setFst(String first) {
		this.first = first;
	}
	public String getSnd() {
		return second;
	}
	public void setSnd(String second) {
		this.second = second;
		}
	public String getThd() {
		return third;
	}
	public void setThd(String third) {
		this.third = third;
	}
	public String getPopCate() {
			return popCate;
		}
	public void setPopCate(String popCate) {
		this.popCate = popCate;
		}
	public int getMaxCount() {
		return maxCount;
	}
	public void setMaxCount(int maxCount) {
	this.maxCount = maxCount;
	}
	public int getAvgCnt() {
		return avgCnt;
	}
	public void setAvgCnt(int avgCnt) {
	this.avgCnt = avgCnt;
	}
	public int getFstCnt() {
		return fstCnt;
	}
	public void setFstCnt(int fstCnt) {
	this.fstCnt = fstCnt;
	}
	public int getSndCnt() {
		return sndCnt;
	}
	public void setSndCnt(int sndCnt) {
	this.sndCnt = sndCnt;
	}
	public int getThdCnt() {
		return thdCnt;
	}
	public void setThdCnt(int thdCnt) {
	this.thdCnt = thdCnt;
	}
	}
