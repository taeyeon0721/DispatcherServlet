package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GmemberDAO;
import vo.GmemberVO;

public class SelectOneMemberAction implements Action{
	//=================회원 상세페이지 보여주는 기능==================
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		GmemberVO vo = new GmemberVO();
		GmemberDAO dao = new GmemberDAO();
		ActionForward forward= new ActionForward();		
		
		HttpSession session = request.getSession(); // 서블릿 내장객체인 session을 직접 생성
		vo.setMid((String)session.getAttribute("mid")); // 로그인 한 사용자의 mid
		
		
		request.setAttribute("mData", dao.mSelectOne(vo)); // 사용자의 정보를 저장
		
		forward.setPath("memberInfo.jsp"); // 정보보기 페이지로 이동
		forward.setRedirect(false); 
		
		return forward;
	}

}
