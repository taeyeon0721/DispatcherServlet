package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ConsultDAO;
import dao.RealtorDAO;
import vo.ConsultVO;
import vo.RealtorVO;

public class InsertConsultAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8"); // 필터로 인해 생략
		
		ConsultVO cVO = new ConsultVO();
		ConsultDAO cDAO = new ConsultDAO();
		RealtorVO rVO = new RealtorVO();
		RealtorDAO rDAO = new RealtorDAO();
		
		HttpSession session = request.getSession();
		
		// view에서 들어온 값 setter
		cVO.setMid((String)session.getAttribute("mid"));
		cVO.setRid(request.getParameter("emailAddress"));
		cVO.setEpk(Integer.parseInt(request.getParameter("epk")));
		cVO.setCdate("날짜: "+request.getParameter("cdate").substring(0,10)+" / 시간: "+request.getParameter("cdate").substring(12));
		cVO.setTitle(request.getParameter("title"));
		cVO.setContent(request.getParameter("content")); 
		
		cDAO.cInsert(cVO);// 상담 신청 기능 수행
		
		rVO.setRid(request.getParameter("emailAddress"));
		rDAO.rConsultNum(rVO); // 중개사 상담 건수 +1
		
		ActionForward forward = new ActionForward();
		forward.setPath("cSelectAll.do");
		forward.setRedirect(false); // forward 방식
		
		return forward;		
	}

}
