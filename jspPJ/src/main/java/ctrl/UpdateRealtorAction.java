package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RealtorDAO;
import vo.RealtorVO;

public class UpdateRealtorAction implements Action{
	//===========중개사 개인정보 변경 (rupdate) action=============
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RealtorVO vo=new RealtorVO();
		RealtorDAO dao=new RealtorDAO();
		ActionForward forward=null;
		vo.setRid(request.getParameter("rid"));	
		vo.setRpw(request.getParameter("rpw"));
		vo.setRpostcode(request.getParameter("rpostcode"));
		vo.setRaddress(request.getParameter("raddress"));	
		vo.setRdetailaddress(request.getParameter("rdetailaddress"));
		vo.setRextraaddress(request.getParameter("rextraaddress"));
		vo.setRment(request.getParameter("rment"));
		
		System.out.println("vo 로그:"+vo);
		
		if(dao.rUpdate(vo)) {
			System.out.println("로그 : 업데이트 성공");
			
			forward=new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(true);
			return forward;
		}
		System.out.println("로그 : 업데이트 실패");
		return forward;
	}

}
