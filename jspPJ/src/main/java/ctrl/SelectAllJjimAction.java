package ctrl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EstateDAO;
import dao.JjimDAO;
import vo.EstateVO;
import vo.JjimVO;

public class SelectAllJjimAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		
		JjimVO jvo=new JjimVO();
		JjimDAO jdao=new JjimDAO();
		EstateDAO edao=new EstateDAO();
		
		HttpSession session = request.getSession();
		
		jvo.setMid((String)session.getAttribute("mid"));
		
		ArrayList<Integer> datas=jdao.selectAll(jvo);	//사용자mid에 해당하는 정수형epk를 받아서 datas에 저장함
		
		
		ArrayList<EstateVO> eDatas=new ArrayList<EstateVO>();	//view에 정보를 전달할때에는 매물의 모든 정보를 줘야함으로 eDatas를 만듬
		
		for(int i=0; i<datas.size(); i++) {
			
			EstateVO evo=new EstateVO();			//반복문 돌때마다 evo를 선언
			evo.setEpk(datas.get(i));				//evo에 epk를 초기화
			evo = edao.eSelectOne(evo);				//edao를 통해 해당 epk의 매물 정보를 다시 evo에 저장
			eDatas.add(evo);						//eDatas에 evo 저장
		}
		
		request.setAttribute("eDatas",eDatas);
		
		if(eDatas.size()!=0) {
			
			System.out.println("[log-SelectAllJjim]찜한 매물 정보 selectAll 성공");
			forward=new ActionForward();
			forward.setPath("likeList.jsp");
			forward.setRedirect(false);
			return forward;
			
		}else {
			
		System.out.println("[log-SelectAllJjim] selectAll 실패");
		forward=new ActionForward();
		forward.setPath("likeList.jsp");
		forward.setRedirect(false);
		return forward;
		}
	}

}
