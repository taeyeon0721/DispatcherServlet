package ctrl;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.EstateDAO;
import vo.EstateVO;

public class UpdateEstateAction implements Action{
	
//=============================매물 업데이트 기능============================
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		// 사진이 저장될 경로
		String path="/java_kty/workspace/jspPJ_3/src/main/webapp/images";
		//사용자가 등록한 이미지를 이클립스 이미지 파일에 저장
		
		int maxSize=1000000; // 바이트 단위
		
		// 사진을 저장함
		MultipartRequest mr = new MultipartRequest(request,path,maxSize,"UTF-8",new DefaultFileRenamePolicy());
		
		EstateVO vo=new EstateVO();
		EstateDAO dao=new EstateDAO();
		
		ActionForward forward=null;	
		
		int epk = Integer.parseInt(mr.getParameter("epk"));
		vo.setEpk(epk);
		
		String ename=mr.getParameter("ename");
//		System.out.println("로그1 이름 ["+ename+"]");
		vo.setEname(ename);
		
		String price=mr.getParameter("price");
//		System.out.println("로그2 가격 ["+eprice+"]");
		vo.setPrice(price);
		
		String category=mr.getParameter("category");
//		System.out.println("로그3 카테고리["+ecategory+"]");
		vo.setCategory(category);
		
		String eaddress=mr.getParameter("eaddress");
//		System.out.println("로그4 주소 ["+eaddress+"]");
		vo.setEaddress(eaddress);
		
		String einfo=mr.getParameter("einfo");
//		System.out.println("로그5 평수["+einfo+"]");
		vo.setEinfo(einfo);
		
		String epay=mr.getParameter("epay");
//		System.out.println("로그6 관리비["+epay+"]");
		vo.setEpay(epay);
		
		String subway=mr.getParameter("subway");
//		System.out.println("로그7 주변역["+esubway+"]");
		vo.setSubway(subway);
		
		HttpSession session = request.getSession();
		String rid=(String)session.getAttribute("rid");
//		System.out.println("로그8 중개사["+rid+"]");
		vo.setRid(rid);
		
		Enumeration<?> file = mr.getFileNames();
		
		if(file.hasMoreElements()) {
			String paramName=(String)file.nextElement();
			
			String img = mr.getFilesystemName(paramName);
		//	System.out.println("로그9 이미지["+img+"]");
			
			if(img == null) {
				img = mr.getParameter("beforeimg");
				// 이미 images/ 형식으로 저장되어있기때문에 따로 set 해줌
				vo.setEimgsrc(img);
			}else {
				vo.setEimgsrc("images/"+img);				
			}
		}
		
		System.out.println("EVO로그 : "+vo);
		
		if(dao.eUpdate(vo)) {
			System.out.println("로그 : 매물 추가 성공");
			
			forward=new ActionForward();
			forward.setPath("myPage.jsp");
			forward.setRedirect(true);
			return forward;
		}
		System.out.println("로그 : 매물 추가 실패");
		forward=new ActionForward();
		forward.setPath("myPage.jsp");
		forward.setRedirect(true);
		return forward;
	}

}

