package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConsultDAO;
import dao.EstateDAO;
import dao.RealtorDAO;
import vo.ConsultVO;
import vo.EstateVO;
import vo.RealtorVO;

public class MainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8"); // 필터로 인해 생략
		
		EstateVO eVO = new EstateVO();
		RealtorVO rVO = new RealtorVO();
		ConsultVO cVO = new ConsultVO();

		EstateDAO eDAO = new EstateDAO();
		RealtorDAO rDAO = new RealtorDAO();
		ConsultDAO cDAO = new ConsultDAO();
		
		eVO.setEaddress("");
		eVO.setSubway("");
		eVO.setCnt(1000);
		
		rVO.setRid("cnt");
		
		request.setAttribute("eDatas", eDAO.eSelectAll(eVO)); // 메인에 뜨는 추천매물 보여주기 용도
		request.setAttribute("rDatas", rDAO.rSelectAll(rVO)); // 메인에 뜨는 중개사 랭킹 보여주기 용도
		request.setAttribute("cDatas", cDAO.cSelectAll(cVO)); // 메인에 뜨는 실시간 상담예약현황 보여주기 용도
		
		ActionForward forward = new ActionForward();
		forward.setPath("mainPage.jsp");
		forward.setRedirect(false); // forward 방식 사용
		
		return forward;
	}
	
}
