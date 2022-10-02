package vo;

public class EstateVO {
	private int epk; 			// pk
	private String ename;		// 매물 이름
	private String price; 		// 가격
	private String category;	// 방종류
	private String eaddress; 	// 매물 주소
	private String einfo; 		// 면적
	private String epay; 		// 관리비
	private String subway; 		// 인근 지하철역
	private String eimgsrc;		// 이미지 경로
	private String rid; 		// 중개사pk -> 중개사만 매물을 등록할 수 있기 때문에, 어떤 중개사가 매물을 등록했다라는것을 알려주기 위해 중개사 pk를 넣어둠
	
	private int cnt; // 더보기 할 변수
	
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public int getEpk() {
		return epk;
	}
	public void setEpk(int epk) {
		this.epk = epk;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getEaddress() {
		return eaddress;
	}
	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}
	public String getEinfo() {
		return einfo;
	}
	public void setEinfo(String einfo) {
		this.einfo = einfo;
	}
	public String getEpay() {
		return epay;
	}
	public void setEpay(String epay) {
		this.epay = epay;
	}
	public String getSubway() {
		return subway;
	}
	public void setSubway(String subway) {
		this.subway = subway;
	}
	public String getEimgsrc() {
		return eimgsrc;
	}
	public void setEimgsrc(String eimgsrc) {
		this.eimgsrc = eimgsrc;
	}
	@Override
	public String toString() {
		return "EstateVO [epk=" + epk + ", ename=" + ename + ", price=" + price + ", category=" + category
				+ ", eaddress=" + eaddress + ", einfo=" + einfo + ", epay=" + epay + ", subway=" + subway + ", eimgsrc="
				+ eimgsrc + ", rid=" + rid + "]";
	}

}
