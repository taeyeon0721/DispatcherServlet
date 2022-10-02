package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RealtorDAO;
import vo.RealtorVO;

public class InsertRealtorAction implements Action {
	//===============중개사 회원가입(rinsert) action==================
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RealtorVO vo=new RealtorVO();
		RealtorDAO dao=new RealtorDAO();
		ActionForward forward=null;
		vo.setRid(request.getParameter("rid"));				
		vo.setRpw(request.getParameter("rpw"));				
		vo.setRname(request.getParameter("rname"));		
		vo.setRphone(request.getParameter("rphone"));		
		vo.setRpostcode(request.getParameter("rpostcode"));
		vo.setRaddress(request.getParameter("raddress"));	
		vo.setRdetailaddress(request.getParameter("rdetailaddress"));
		vo.setRextraaddress(request.getParameter("rextraaddress"));
		vo.setRment(request.getParameter("rment"));			//중개사 소개멘트
		
		if(dao.rInsert(vo)) {
			System.out.println("중개사 insert(회원가입) 성공");
			forward=new ActionForward();
			forward.setPath("login.jsp");
			forward.setRedirect(true);
			
			return forward;
		}
		
		System.out.println("중개사 insert(회원가입) 실패");
		return forward;
	}
}