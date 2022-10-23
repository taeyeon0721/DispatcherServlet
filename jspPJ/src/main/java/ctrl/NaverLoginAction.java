package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NaverLoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		
		if(request.getParameter("id")!=null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("mid", request.getParameter("id"));
			session.setAttribute("mname", request.getParameter("pw"));
			
			session.setAttribute("logoutValue", 100);
			forward=new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(true);
		}
		
		return forward;
	}

}
