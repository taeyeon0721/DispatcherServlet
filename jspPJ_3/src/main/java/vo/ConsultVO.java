package vo;

public class ConsultVO {
	private int cid; 			// pk
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
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

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriteday() {
		return writeday;
	}

	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	private String mid; 		// 사용자pk
	private String rid; 		// 상담사 pk
	private int epk; 			// 매물 pk
	private String cdate; 		// 날짜 
	private String title;		// 제목
	private String content; 	// 내용
	private String writeday; 	// 작성일
	
	private String rname;		// [JAVA] 조인에서 쓸 이름변수

	

}