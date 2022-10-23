package ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SmsDAO;
import vo.SmsVO;

/**
 * Servlet implementation class SmsCheck
 */
@WebServlet("/SmsCheck")
public class SmsCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SmsCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SmsVO vo = new SmsVO();
		SmsDAO dao = new SmsDAO();
		
		
		vo.setPhone(request.getParameter("randNum"));
		vo.setCheckNum(request.getParameter("checkNum"));
		
//		System.out.println("로그: SmsCheck() :"+vo.getPhone()+" "+vo.getCheckNum());

		int result = dao.smsCheck(vo);

		// ****요청했던 곳(ajax)으로 result 값을 보낼 예정****
		// 보통 어노테이션을 사용하는데 어려워서 이번 경우만 응답방식으로 이용
		response.setContentType("application/x-json; charset=UTF-8"); // 이거 json파일이다 utf-8로 인코딩해!
		response.getWriter().write(result+""); // 문자열을 더하면서 String 문자열로 변환 
	}

}
