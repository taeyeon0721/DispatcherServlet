package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConsultDAO;
import vo.ConsultVO;

public class UpdateConsultAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8"); // 필터로 인해 생략
		
		ConsultVO cVO = new ConsultVO();
		ConsultDAO cDAO = new ConsultDAO();
		
		cVO.setCid(Integer.parseInt(request.getParameter("cid")));
		cVO.setContent(request.getParameter("content"));
		
		cDAO.cUpdate(cVO);
		
		ActionForward forward = new ActionForward();
		forward.setPath("cSelectAll.do"); // 내 상담목록으로 이동
		forward.setRedirect(true); 
		
		return forward;		
		
	}

}
