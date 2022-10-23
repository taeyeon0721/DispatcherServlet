package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GmemberDAO;
import vo.GmemberVO;

public class InsertMemberAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8"); // 필터로 인해 생략
		
		GmemberVO mVO = new GmemberVO();
		GmemberDAO mDAO = new GmemberDAO();
		ActionForward forward = null;
		
		// view에서 들어온 값 setter
		mVO.setMid(request.getParameter("mid")); 
		mVO.setMpw(request.getParameter("mpw"));
		mVO.setMname(request.getParameter("mname"));
		mVO.setMphone(request.getParameter("mphone"));
		mVO.setMpostcode(request.getParameter("mpostcode"));
		mVO.setMaddress(request.getParameter("maddress"));
		mVO.setMdetailaddress(request.getParameter("mdetailaddress"));
		mVO.setMextraaddress(request.getParameter("mextraaddress"));
		
		if(mDAO.mInsert(mVO)) {
			System.out.println("회원 mInsert(회원가입) 성공");
			forward=new ActionForward();
			forward.setPath("login.jsp");
			forward.setRedirect(true);
			
			return forward;
		}
		
		System.out.println("회원 mInsert(회원가입) 실패");
		return forward;
	}

}