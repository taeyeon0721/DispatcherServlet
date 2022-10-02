package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RealtorDAO;
import vo.RealtorVO;

public class DeleteRealtorAction implements Action {
	//=================중개사 회원탈퇴(rdelete) action===============
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RealtorVO vo=new RealtorVO();
		RealtorDAO dao=new RealtorDAO();
		ActionForward forward=null;
		
		vo.setRid(request.getParameter("rid"));
		
		System.out.println("중개사 정보 로그 :" +vo);
		
		if(dao.rDelete(vo)) {
			
			System.out.println("로그 : 중개사 회원탈퇴 성공");	
			
			
			HttpSession session = request.getSession();
			
			if(session.getAttribute("mid").equals("admin")) {
				forward=new ActionForward();
				forward.setPath("admin.do?condition=realtor");
				forward.setRedirect(true);
				return forward;
			}
			
			session.invalidate(); // 세션에 남아있는 정보를 삭제
			
			forward=new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(true);
			
			return forward;
		
		}
		
	
		System.out.println("로그 : 중개사 회원탈퇴 실패");	
		return forward;
	}

}