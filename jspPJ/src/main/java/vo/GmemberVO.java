package vo;

public class GmemberVO {
	private String mid;				// 아이디(이메일 주소) pk
	private String mpw;				// 비밀 번호
	private String mname;			// 회원 이름
	private String mphone;			// 전화번호
	private String mpostcode;		// 우편번호
	private String maddress;		// 주소
	private String mdetailaddress;	// 상세 주소
	private String mextraaddress;	// 참고항목
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public String getMpostcode() {
		return mpostcode;
	}
	public void setMpostcode(String mpostcode) {
		this.mpostcode = mpostcode;
	}
	public String getMaddress() {
		return maddress;
	}
	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}
	public String getMdetailaddress() {
		return mdetailaddress;
	}
	public void setMdetailaddress(String mdetailaddress) {
		this.mdetailaddress = mdetailaddress;
	}
	public String getMextraaddress() {
		return mextraaddress;
	}
	public void setMextraaddress(String mextraaddress) {
		this.mextraaddress = mextraaddress;
	}
	
	@Override
	public String toString() {
		return "GmemberVO [mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", mphone=" + mphone + ", mpostcode="
				+ mpostcode + ", maddress=" + maddress + ", mdetailaddress=" + mdetailaddress + ", mextraaddress="
				+ mextraaddress + "]";
	}
	
}
