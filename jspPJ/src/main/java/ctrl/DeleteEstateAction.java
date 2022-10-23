package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EstateDAO;
import vo.EstateVO;

public class DeleteEstateAction  implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		EstateVO vo=new EstateVO();
		EstateDAO dao=new EstateDAO();
		ActionForward forward=null;
		vo.setEpk(Integer.parseInt(request.getParameter("epk")));
		
		if(dao.eDelete(vo)) {
//			System.out.println("로그 : 매물 삭제 성공");
			
			HttpSession session = request.getSession();
			
			if(session.getAttribute("mid")!=null && session.getAttribute("mid").equals("admin")) {
				forward=new ActionForward();
				forward.setPath("admin.do?condition=estate");
				forward.setRedirect(true);
				return forward;
			}
			
			forward=new ActionForward();
			forward.setPath("eMain.do");
			forward.setRedirect(true);
			return forward;
		}
		
		
//		System.out.println("로그 : 매물 삭제 실패");
		return forward;
	}

}
