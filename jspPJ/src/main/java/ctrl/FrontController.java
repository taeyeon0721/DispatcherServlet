package ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("로그: doGet()실행");
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("로그: doPost()실행");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 정보 추출 부분
		String uri = request.getRequestURI(); // 전체 URI가 모두 나옴
//		System.out.println(uri); // 전체 uri 나오는 것을 확인
		String cp = request.getContextPath(); // 프로젝트 이름
//		System.out.println(cp); // 프로젝트 이름이 나오는 것을 확인
		String command = uri.substring(cp.length()); // 전체 URI에서 프로젝트 이름을 제거하면 xxx.jsp등 실제 요청 값이 남음
		System.out.println(command); // 요청 값만 남는 것을 확인
		
		ActionForward forward = null;
		if(command.equals("/main.do")) { // 메인 페이지로 이동
			try {
				forward = new MainAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/admin.do")) { // 로그인 기능
			try {
				forward = new AdminAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/login.do")) { // 로그인 기능
			try {
				forward = new LoginAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/logout.do")) { // 로그 아웃
			try {
				forward = new LogoutAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/mInsert.do")) { // 회원추가 기능
			try {
				forward = new InsertMemberAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/mDelete.do")) { // 회원 삭제 기능
			try {
				forward = new DeleteMemberAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/mUpdate.do")) { // 회원 정보 변경 기능
			try {
				forward = new UpdateMemberAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/mSelectOne.do")) { // 회원 정보 변경 기능
			try {
				forward = new SelectOneMemberAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/cSelectAll.do")) { // 상담 전체 목록 (관리자가 사용)
			try {
				forward = new SelectAllConsultAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/cSelectOne.do")) { // 상담 목록 하나의 정보
			try {
				forward = new SelectOneConsultAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/cInsert.do")) { // 상담 신청
			try {
				forward = new InsertConsultAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/cUpdate.do")) { // 상담 내용 수정
			try {
				forward = new UpdateConsultAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/cDelete.do")) { // 상담 취소
			try {
				forward = new DeleteConsultAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/eMain.do")) { // 전체 매물 메인
			try {
				forward = new SelectAllEstateAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/eSelectOne.do")) { // 매물 하나의 상세정보
			try {
				forward = new SelectOneEstateAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/eInsert.do")) { // 매물 추가
			try {
				forward = new InsertEstateAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/eUpdate.do")) { // 매물 수정하기
			try {
				forward = new UpdateEstateAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/eDelete.do")) { // 매물 삭제
			try {
				forward = new DeleteEstateAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/rSelectAll.do")) { // 전체 중개사 출력
			try {
				forward = new SelectAllRealtorAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/rSelectOne.do")) { // 중개사 한명의 정보
			try {
				forward = new SelectOneRealtorAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/rInsert.do")) { // 중개사 추가
			try {
				forward = new InsertRealtorAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/rDelete.do")) { // 중개사 탈퇴
			try {
				forward = new DeleteRealtorAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/rUpdate.do")) { // 중개사 정보 수정
			try {
				forward = new UpdateRealtorAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/jSelectAll.do")) { // 
			try {
				forward = new SelectAllJjimAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/naverlogin.do")) {
			try {
				forward = new NaverLoginAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/kakaologin.do")) {
			try {
				forward = new KakaoLoginAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		// 에러발생시
		if(forward==null) { 
	         forward=new ActionForward();
	         forward.setPath("error/error.jsp");
	         forward.setRedirect(false);
	    }
		
		// 요청정부를 웹페이지의 띄워주는 부분
		RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath()); // 어디로 갈지 경로가 있으면 보내줌
		try {
			dispatcher.forward(request, response); // 어디로 갈지 경로가 있으면 보내줌
			// 타겟페이지(인자)(forward.getPath()) 로 request,response 객체를 전달하는 메서드
			// 제어권을 넘겨줌 -> 클라이언트가 응답을 확인할 수 있음
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
}
