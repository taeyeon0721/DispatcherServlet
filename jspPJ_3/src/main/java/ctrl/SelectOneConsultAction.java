package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConsultDAO;
import vo.ConsultVO;

public class SelectOneConsultAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ConsultVO cVO = new ConsultVO();
		ConsultDAO cDAO = new ConsultDAO();
		
		cVO.setCid(Integer.parseInt(request.getParameter("cid")));
		ConsultVO cVO2 = cDAO.cSelectOne(cVO);
		System.out.println(cVO2);
		ActionForward forward = new ActionForward();
//		cVO.setCdate("날짜: "+request.getParameter("cdate").substring(0,10)+" / 시간: "+request.getParameter("cdate").substring(12));

		String reservation="날짜: "+cVO2.getCdate().substring(0,4)+"년"+cVO2.getCdate().substring(5,7)+"월"+cVO2.getCdate().substring(8,10)+"일"+" / 시간: "+cVO2.getCdate().substring(12);
		//디자인을 위해 하드 코딩 했습니다 ㅎㅎ ^^ ♥
		System.out.println(reservation);
		if(cVO2!=null) {
			request.setAttribute("reservation", reservation);
			request.setAttribute("cData", cVO2);
			forward.setPath("consultOne.jsp");
			forward.setRedirect(false);
			
		}else {
			forward.setPath("main.do");
			forward.setRedirect(true);
		}
		
		return forward;
	}

}
