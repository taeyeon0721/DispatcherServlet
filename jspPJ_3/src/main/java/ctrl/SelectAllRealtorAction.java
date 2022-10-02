package ctrl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RealtorDAO;
import vo.RealtorVO;

public class SelectAllRealtorAction implements Action{
//=================중개사 랭킹(모든 중개사)==================
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RealtorVO vo=new RealtorVO();
		RealtorDAO dao=new RealtorDAO();
		ActionForward forward=null;
		
		ArrayList<RealtorVO> datas=dao.rSelectAll(vo);
		request.setAttribute("rDatas", datas);
		
		if(datas.size()!=0) {
			System.out.println("중개사 selectAll 성공");
			forward=new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(false);
			return forward;
		}
		System.out.println("중개사 selectAll 실패");
		return forward;
		
	}

}
