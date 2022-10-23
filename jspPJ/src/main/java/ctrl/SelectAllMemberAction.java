package ctrl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GmemberDAO;
import vo.GmemberVO;
import vo.RealtorVO;


public class SelectAllMemberAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//=================모든 회원 출력==================
		
		GmemberVO vo=new GmemberVO();
		GmemberDAO dao=new GmemberDAO();
		ActionForward forward=null;
		
		ArrayList<GmemberVO> datas=dao.mSelectAll(vo);
		request.setAttribute("mDatas", datas);
		
		if(datas.size()!=0) {
			System.out.println("회원 selectAll 성공");
			forward=new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(false);
			return forward;
		}
		System.out.println("회원 selectAll 실패");
		return forward;
	}

}
