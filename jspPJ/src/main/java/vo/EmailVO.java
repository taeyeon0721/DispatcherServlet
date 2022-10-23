package vo;

public class EmailVO {
	private String EmailAddress;
	private String content;
	private String title;
	private String cdate;
	
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "EmailVO [EmailAddress=" + EmailAddress + ", content=" + content + ", title=" + title + "]";
	}
	
}
