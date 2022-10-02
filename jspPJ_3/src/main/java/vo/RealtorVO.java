package vo;

public class RealtorVO {
	private String rid; 			 //중개사 아이디 pk
	private String rpw; 		 	 // 비밀번호
	private String rname; 		 	 //이름
	private String rphone; 			 //핸드폰 번호
	private String rpostcode; 		 // 우편번호
	private String raddress;		 //주소
	private String rdetailaddress;	 //상세주소
	private String rextraaddress; 	 // 참고항목
	private int rconsultnum;		 // 상담건수
	private String rment; 			 // 소개멘트
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getRpw() {
		return rpw;
	}
	public void setRpw(String rpw) {
		this.rpw = rpw;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRphone() {
		return rphone;
	}
	public void setRphone(String rphone) {
		this.rphone = rphone;
	}
	
	public String getRaddress() {
		return raddress;
	}
	public void setRaddress(String raddress) {
		this.raddress = raddress;
	}
	public String getRdetailaddress() {
		return rdetailaddress;
	}
	public void setRdetailaddress(String rdetailaddress) {
		this.rdetailaddress = rdetailaddress;
	}
	public String getRextraaddress() {
		return rextraaddress;
	}
	public void setRextraaddress(String rextraaddress) {
		this.rextraaddress = rextraaddress;
	}
	public int getRconsultnum() {
		return rconsultnum;
	}
	public void setRconsultnum(int rconsultnum) {
		this.rconsultnum = rconsultnum;
	}
	public String getRment() {
		return rment;
	}
	public void setRment(String rment) {
		this.rment = rment;
	}
	public String getRpostcode() {
		return rpostcode;
	}
	public void setRpostcode(String rpostcode) {
		this.rpostcode = rpostcode;
	}
	@Override
	public String toString() {
		return "realtorVO [rid=" + rid + ", rpw=" + rpw + ", rname=" + rname + ", rphone=" + rphone + ", rpostcode="
				+ rpostcode + ", raddress=" + raddress + ", rdetailaddress=" + rdetailaddress + ", rextraaddress="
				+ rextraaddress + ", rconsultnum=" + rconsultnum + ", rment=" + rment + "]";
	}
	
	
	
}
