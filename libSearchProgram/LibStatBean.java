package libSearchProgram;

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
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getFst() {
		return first;
	}
	public void setFst(String first) {
		this.first = first;
	}
	public String getScd() {
		return second;
	}
	public void setScd(String second) {
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
	}
