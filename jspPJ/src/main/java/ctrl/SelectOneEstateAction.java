package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EstateDAO;
import dao.RealtorDAO;
import vo.EstateVO;
import vo.RealtorVO;

public class SelectOneEstateAction implements Action{
	//=================매물 상세페이지 보여주는 기능==================
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//		System.out.println("로그: eSelectOneEstateAction 실행: ["+request.getParameter("epk")+"]");
		EstateVO vo=new EstateVO();
		EstateDAO dao=new EstateDAO();
		
		RealtorVO rVO = new RealtorVO();
		RealtorDAO rDAO = new RealtorDAO();
		
		ActionForward forward = new ActionForward();


		vo.setEpk(Integer.parseInt(request.getParameter("epk")));

		EstateVO data=dao.eSelectOne(vo);
		
		rVO.setRid(data.getRid());
		request.setAttribute("rData", rDAO.rSelectOne(rVO)); // 매물 상세페이지를 위한 중개사 한명의 정보가져가기

		request.setAttribute("eData", data);

		if( request.getParameter("condition") != null && request.getParameter("condition").equals("consult") ) {
			
			forward.setPath("consult.jsp");
			forward.setRedirect(false);
			
//			System.out.println("상담신청을 위한 selectOne 성공"+request.getParameter("epk"));

		}else if(request.getParameter("condition") != null && request.getParameter("condition").equals("estateUpdate") ) {
			forward.setPath("estateUpdate.jsp");
			forward.setRedirect(false);
			
//			System.out.println("매물 수정을 위한 selectOne 성공"+request.getParameter("epk"));
		}
		else{

			forward.setPath("detailPage.jsp");
			forward.setRedirect(false);
//			System.out.println("매물 상세페이지를 위한 selectOne 성공");
		}

		return forward;


	}

}
