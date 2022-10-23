package ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmailDAO;
import vo.EmailVO;

/**
 * Servlet implementation class Email
 */
@WebServlet("/Email")
public class Email extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Email() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그: Email서블릿 실행");
		
		EmailVO vo = new EmailVO();
		EmailDAO dao = new EmailDAO();
		
		System.out.println("서블릿 로그: "+request.getParameter("content"));
		
		vo.setEmailAddress(request.getParameter("emailAddress"));
		vo.setContent(request.getParameter("content"));
		vo.setTitle(request.getParameter("title"));
		vo.setCdate("상담예약\n날짜: "+request.getParameter("cdate").substring(0,10)
				+"\n시간: "+request.getParameter("cdate").substring(12)+"\n");
		
//		System.out.println("로그:"+request.getParameter("emailAddress")
//		+request.getParameter("content")+request.getParameter("title"));
		
		int result = dao.email(vo);
		
		response.setContentType("application/x-json; charset=UTF-8"); // 이거 json파일이다 utf-8로 인코딩해!
		response.getWriter().write(result+""); // 문자열을 더하면서 String 문자열로 변환 
	}
	

}
