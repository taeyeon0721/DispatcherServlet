package ctrl;

public class ActionForward {
	private String path; // 어떤 경로
	private boolean redirect; // 어떻게 갈지 forward?
	
	public ActionForward() { // 다른 곳에서 써야 하기 때문엔 기본생성자만듦
		
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
}
