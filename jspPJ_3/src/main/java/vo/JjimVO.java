package vo;

public class JjimVO {
	private int jpk; 	//pk
	private String mid; //사용자pk
	private int epk; 	//매물pk
	
	private String eaddress;	// [JAVA] 조인에서 쓸 주소변수
	
	public int getJpk() {
		return jpk;
	}
	public void setJpk(int jpk) {
		this.jpk = jpk;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getEpk() {
		return epk;
	}
	public void setEpk(int epk) {
		this.epk = epk;
	}
	
	@Override
	public String toString() {
		return "jjimVO [jpk=" + jpk + ", mid=" + mid + ", epk=" + epk + "]";
	}
	
	
}
