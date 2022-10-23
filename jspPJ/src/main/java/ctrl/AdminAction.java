package ctrl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EstateDAO;
import dao.GmemberDAO;
import dao.RealtorDAO;
import vo.EstateVO;
import vo.GmemberVO;
import vo.RealtorVO;

public class AdminAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String condition = request.getParameter("condition");
		ActionForward forward=new ActionForward();
		
		if (condition.equals("member")) {
			GmemberVO vo=new GmemberVO();
			GmemberDAO dao=new GmemberDAO();
			
			ArrayList<GmemberVO> datas=dao.mSelectAll(vo);
			request.setAttribute("mDatas", datas);
			
//			System.out.println("회원 selectAll 성공");
			forward=new ActionForward();
			forward.setPath("admin_M.jsp");
			forward.setRedirect(false);
			return forward;

		}else if (condition.equals("realtor")) {
			RealtorVO vo=new RealtorVO();
			RealtorDAO dao=new RealtorDAO();
			
			ArrayList<RealtorVO> datas=dao.rSelectAll(vo);
			request.setAttribute("rDatas", datas);

//			System.out.println("중개사 selectAll 성공");
			forward=new ActionForward();
			forward.setPath("admin_R.jsp");
			forward.setRedirect(false);
			return forward;
			
		}else if (condition.equals("estate")) {
			EstateVO vo=new EstateVO();
			EstateDAO dao=new EstateDAO();
			
			vo.setSubway("");
			vo.setEaddress("");
			vo.setCnt(1000);
			ArrayList<EstateVO> datas = dao.eSelectAll(vo);
			
			request.setAttribute("eDatas",datas);
			forward.setPath("admin_E.jsp");
			forward.setRedirect(false);
			return forward;
		}else {
//			System.out.println("어드민액션에서 null 리턴 -> 아무것도 못함");
			return null;
		}
		
	}
}
