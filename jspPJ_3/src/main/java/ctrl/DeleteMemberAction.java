package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GmemberDAO;
import vo.GmemberVO;

public class DeleteMemberAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8"); // 필터로 인해 생략
		
		GmemberVO mVO = new GmemberVO();
		GmemberDAO mDAO = new GmemberDAO();
		ActionForward forward = new ActionForward();
		
		// view에서 들어온 값 setter
		mVO.setMid(request.getParameter("mid"));
		
		mDAO.mDelete(mVO); // 회원 삭제 기능 수행
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("mid").equals("admin")) {
			
			forward=new ActionForward();
			forward.setPath("admin.do?condition=member");
			forward.setRedirect(true);
			return forward;
		}
		
		session.invalidate(); // 세션에 남아있는 정보를 삭제
		
		forward.setPath("main.do"); // 메인으로 이동
		forward.setRedirect(true); // redirect
		
		return forward;
	}

}
