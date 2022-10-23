package ctrl;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.EstateDAO;
import vo.EstateVO;

public class InsertEstateAction implements Action{
//===================매물 추가 기능======================
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		// 사진이 저장될 경로
		String path="/Users/dongwook/0607jang/eclipse-workspace/SaBangPalBang/src/main/webapp/images";
		
		int maxSize=1000000; // 바이트 단위
		
		// 사진을 저장함
		MultipartRequest mr = new MultipartRequest(request,path,maxSize,"UTF-8",new DefaultFileRenamePolicy());
		
		EstateVO vo=new EstateVO();
		EstateDAO dao=new EstateDAO();
		
		ActionForward forward=null;	
		
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
			System.out.println("안으로 들어왔따잉?");
			String paramName=(String)file.nextElement();
			System.out.println("파라미터명 ["+paramName+"]");
			
			String eimgsrc=mr.getFilesystemName(paramName);
			System.out.println("로그9 이미지["+eimgsrc+"]");
			
			vo.setEimgsrc("images/"+eimgsrc);
		}
		
		System.out.println("EVO로그 : "+vo);
		
		if(dao.eInsert(vo)) {
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
