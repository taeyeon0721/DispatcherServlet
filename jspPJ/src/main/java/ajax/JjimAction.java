package ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EstateDAO;
import dao.JjimDAO;
import vo.EstateVO;
import vo.JjimVO;

/**
 * Servlet implementation class JjimAction
 */
@WebServlet("/JjimAction.like2")
public class JjimAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JjimAction() {
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
		
		EstateVO evo = new EstateVO();
		EstateDAO edao = new EstateDAO();
		
//		System.out.println("[Jjim-log]요청 페이지에서 받은 값 epk"+request.getParameter("epk"));
//		System.out.println("[Jjim-log]요청 페이지에서 받은 값 mid"+request.getParameter("mid"));
		
		jvo.setEpk(Integer.parseInt(request.getParameter("epk")));
		jvo.setMid(request.getParameter("mid"));
		
		
		int result=jdao.jjimAction(jvo);		//jjimAction으로 자동으로 사용자 상태를 파악하고 좋아요 클릭시 상황에 맞는 result값을 보내줌
												// result->0이면 사용자가 찜하기를 취소함  result->1이면 사용자가 찜하기를 함

//		System.out.println("페이지 클릭시 좋아요 확인 절차 result반환 값" + result);	
	
		/*
		 * 찜하기 cnt도 추가할려면 여기에 더 로직 추가해야함
		 * 1.매물에 FAVCNT 칼럼 추가 
		 * 2.매물VO에 매개변수 favcnt추가
		 * 3.매물 DAO에 updatedown , updateup sql ,메서드 추가해야함
		 * if(result==0) {
			if(edao.updateDown(vo1)) {
				System.out.println("favcnt -1 성공");
			}
		}
			else if(result==1) {
			if(edao.updateUp(vo1)) {
				System.out.println("favcnt +1 성공");
			}
		}
		 * */
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().write(result + "");
		
		
		
		
	}

}
