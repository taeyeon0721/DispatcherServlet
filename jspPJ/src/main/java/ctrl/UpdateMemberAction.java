package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GmemberDAO;
import vo.GmemberVO;

public class UpdateMemberAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8"); // 필터로 인해 생략
		
		GmemberVO mVO = new GmemberVO();
		GmemberDAO mDAO = new GmemberDAO();
		
		// view에서 들어온 값 setter
		mVO.setMid(request.getParameter("mid"));
		mVO.setMpw(request.getParameter("mpw"));
		mVO.setMpostcode(request.getParameter("mpostcode"));
		mVO.setMaddress(request.getParameter("maddress"));
		mVO.setMdetailaddress(request.getParameter("mdetailaddress"));
		mVO.setMextraaddress(request.getParameter("mextraaddress"));
		
		mDAO.mUpdate(mVO); // 정보변경 기능 수행
		
		HttpSession session = request.getSession(); // 서블릿 내장객체인 session을 직접 생성
		session.setAttribute("mData", mDAO.mSelectOne(mVO)); // 새 정보를 session에 저장
		
		ActionForward forward = new ActionForward();
		forward.setPath("main.do"); // 메인으로 이동
		forward.setRedirect(true); // redirect
		
		return forward;		
		
	}

}
