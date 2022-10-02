package ctrl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EstateDAO;
import vo.EstateVO;

public class SelectAllEstateAction implements Action{

	//===============전체 매물 페이지 보여주는 기능=========================

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		EstateVO vo=new EstateVO();
		EstateDAO dao=new EstateDAO();
		ActionForward forward=new ActionForward();

		//		String searchCondition = request.getParameter("searchCondition"); // view가 보내준 검색 종류(지역 or 지하철역)
		//		String searchContent = request.getParameter("searchContent"); // view가 보내준 검색 내용

		
		// 검색 내용이 없으면 "" 가 들어감 null이 아님
		String paramCnt = request.getParameter("cnt");
		
		if(paramCnt==null || paramCnt.equals("")) {
			vo.setCnt(3); // 값이 없거나 null이면 3로 세팅
		}
		else {
			vo.setCnt(Integer.parseInt(paramCnt));
			// request 요청 값은 String이므로 integer 로 변환
		}
		request.setAttribute("cnt", vo.getCnt()); // 더보기 cnt

		// 매물등록 이후 main.do를 사용하는데 입력하지 않기때문에 기본값을 주기 위해
		if(request.getParameter("rid") != null) {
			vo.setRid(request.getParameter("rid"));
		}
		
		String searchCondition = request.getParameter("searchCondition");
		String searchContent = request.getParameter("searchContent");
		
		if(searchCondition != null && searchCondition.equals("address")) { // searchCondition 이 address 일 때
			vo.setEaddress(searchContent);
			vo.setSubway("");
		}
		else if (searchCondition != null && searchCondition.equals("subway")){ // searchCondition 이 subway 일 때
			vo.setEaddress("");
			vo.setSubway(searchContent);
		}else {
			vo.setEaddress("");
			vo.setSubway("");
		}

		request.setAttribute("searchContent", searchContent);
		request.setAttribute("searchCondition", searchCondition);
		
		
		ArrayList<EstateVO> datas = dao.eSelectAll(vo);
		
		// 매물의 사이즈 값을 저장
		request.setAttribute("size", dao.eSelectAll_Size(vo));

		
		// 전체매물용 데이터
		request.setAttribute("eDatas",datas);
		
		// 추천매물 데이터 뽑기용
		vo.setSubway("");
		vo.setEaddress("");
		vo.setCnt(1000);
		ArrayList<EstateVO> datas2 = dao.eSelectAll(vo);

		// 추천매물 보여기주용 전체출력
		request.setAttribute("eDatas2",datas2);
		
		
		if(request.getParameter("rid") != null) {
			forward.setPath("estateAll.jsp");
			forward.setRedirect(false);
			return forward;			
		}else {
			forward.setPath("allPage.jsp");
			forward.setRedirect(false);
			return forward;		
		}

	}

}
