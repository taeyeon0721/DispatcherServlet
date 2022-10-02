package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RealtorDAO;
import vo.RealtorVO;

public class SelectOneRealtorAction implements Action {
//==========중개사 마이페이지를 보여주기 위해 정보를 전달해주는 action===========
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RealtorVO vo=new RealtorVO();
		RealtorDAO dao=new RealtorDAO();
		ActionForward forward=null;
		
		
		
		HttpSession session = request.getSession(); // 서블릿 내장객체인 session을 직접 생성
		vo.setRid((String)session.getAttribute("rid"));
		
		RealtorVO data=dao.rSelectOne(vo);
		
		if(data!=null) {
			System.out.println("로그:중개사 정보 추출 성공");
			request.setAttribute("rData", data);	
			// selectone해서 저장한 정보 data를 realtor에 저장후 요청페이지에 정보전달
			
			forward=new ActionForward();
			forward.setPath("/realtorInfo.jsp");	// 상세페이제로 정보 전달
			forward.setRedirect(false);
			return forward;
		}
		System.out.println("로그:중개사 정보 추출 실패");
		return forward;
	}

}
