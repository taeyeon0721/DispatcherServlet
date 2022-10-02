package ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GmemberDAO;
import vo.GmemberVO;

/**
 * Servlet implementation class idCheck
 */
@WebServlet("/idCheck")
public class idCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public idCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mid = request.getParameter("userid");
		
		GmemberVO vo = new GmemberVO();
		vo.setMid(mid);
		
		GmemberDAO dao = new GmemberDAO();
		
		GmemberVO check = dao.mSelectOne(vo);
		
		// 결과가 0이면 중복이 있다 1이면 생성가능
		int result = 0;
		
		if(check == null) {
			// mid에 대한 결과가 존재하지 않다는것 = 중복이 없다 = 아이디 생성가능
			result = 1;
		}
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().write(result+"");
		
		
		
		
		
		
		
	}

}
