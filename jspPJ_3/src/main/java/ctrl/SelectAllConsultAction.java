package ctrl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ConsultDAO;
import vo.ConsultVO;

public class SelectAllConsultAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8"); // 필터로 인해 생략
		
		ActionForward forward =null;
		ConsultVO cVO = new ConsultVO();
		ConsultDAO cDAO = new ConsultDAO();
		
		HttpSession session = request.getSession();
		
		
//		if(request.getParameter("content") != null) {
//			
		cVO.setMid((String)session.getAttribute("mid"));
			
//			
//		}
	//	else {
	//		forward.setPath("관리자페이지.jsp");
	//	}
			
		ArrayList<ConsultVO> cDatas=cDAO.cSelectAll(cVO);
		if(cDatas != null) {
		forward=new ActionForward();
		request.setAttribute("cDatas", cDatas);
		forward.setPath("consultAll.jsp");
		forward.setRedirect(false); // forward 방식
		}
		
		return forward;		
	}
	
}
