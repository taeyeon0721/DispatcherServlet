package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GmemberDAO;
import dao.RealtorDAO;
import vo.GmemberVO;
import vo.RealtorVO;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//		request.setCharacterEncoding("UTF-8");
		//		response.setCharacterEncoding("UTF-8"); // 필터로 인해 생략

		HttpSession session = request.getSession(); // 서블릿 내장객체인 session을 직접 생성
		ActionForward forward = new ActionForward();
		System.out.println("로그: loginAction ["+request.getParameter("role")+"]");

		if(request.getParameter("role").equals("member")) { // 개인 회원 로그인일 경우

			GmemberVO mVO = new GmemberVO();
			GmemberDAO mDAO = new GmemberDAO();

			mVO.setMid(request.getParameter("id")); 
			mVO.setMpw(request.getParameter("pw"));

			GmemberVO data = mDAO.mLogin(mVO); // 로그인 기능 수행
			System.out.println(data);
			if(data != null) {
				session.setAttribute("mid",data.getMid()); // session단위에 mid를 저장 (view에서 사용)
				session.setAttribute("mname", data.getMname()); // session단위에 mname를 저장 (view에서 사용)
				
				if(request.getParameter("id").equals("admin")) {
					
					session.setAttribute("mid", data.getMid());// admin
					
					forward.setPath("admin.do?condition=member"); // 메인으로 이동
					forward.setRedirect(true); // redirect

					return forward;
				}
			}
			else { //로그인 실패시 다시 로그인 페이지로 이동
				forward.setPath("login.jsp"); // 로그인 페이지로 이동
				forward.setRedirect(false); // forward
				
				request.setAttribute("loginWarn", -1);
				return forward;
			}

		}
		else { // 중개사 로그인 일 경우

			RealtorVO rVO=new RealtorVO();
			RealtorDAO rDAO=new RealtorDAO();

			rVO.setRid(request.getParameter("id"));
			rVO.setRpw(request.getParameter("pw"));

			RealtorVO data=rDAO.rLogin(rVO);

			if(data != null) {
				session.setAttribute("rid",data.getRid()); // session단위에 rid를 저장 (view에서 사용)
				session.setAttribute("rname", data.getRname()); // session단위에 rname를 저장 (view에서 사용)
			}else { //로그인 실패시 다시 로그인 페이지로 이동
				forward.setPath("login.jsp"); // 로그인 페이지로 이동
				forward.setRedirect(false); // forward
				
				request.setAttribute("loginWarn", -1);
				return forward;
			}
		}
		
		forward.setPath("main.do"); // 메인으로 이동
		forward.setRedirect(true); // redirect

		return forward;

	}

}
