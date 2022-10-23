package ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JjimDAO;
import vo.JjimVO;

/**
 * Servlet implementation class JjimCheckAction
 */
@WebServlet("/JjimCheckAction.like1")
public class JjimCheckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JjimCheckAction() {
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
		JjimVO jvo = new JjimVO();
		JjimDAO jdao=new JjimDAO();
		
		
//		System.out.println("[JjimCheck-log]요청 페이지에서 받은 값 epk"+request.getParameter("epk"));
//		System.out.println("[JjimCheck-log]요청 페이지에서 받은 값 mid"+request.getParameter("mid"));
		
		
		jvo.setEpk(Integer.parseInt(request.getParameter("epk")));
		jvo.setMid(request.getParameter("mid"));
		
		
		int result = jdao.jjimCheck(jvo);
//		System.out.println("[log]페이지 로드시 좋아요 확인 절차 result반환 값" + result);
		
		//=====ajax에 값을 반환 ========
		System.out.println("페이지 로드시 좋아요 확인 절차 result반환 값" + result);
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().write(result + "");
		
	}

}
