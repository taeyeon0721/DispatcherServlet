package com.kim.biz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	//의존관계
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	//init() 통해서 DI
	public void init() throws ServletException{
		handlerMapping = new HandlerMapping(); //생성자 주입
		viewResolver = new ViewResolver(); //setter 주입
	
		viewResolver.setPrefix("");
		viewResolver.setSuffix("");
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//요청정보 빼내야함
		String command = request.getRequestURI(); //   ..../login.do
		command=command.substring(command.lastIndexOf("/")); //   /login.do
		System.out.println(command);
		
		Controller ctrl = handlerMapping.getController(command); 
		//반환값: C객체 -> key값에 따라 다른 객체 반환
		// ex) main.do -> new mainController, login.do -> new loginController
		String viewName = ctrl.handleRequest(request, response);
		//LoginController를 통해서 반환받은 값을 viewName에 저장
		//String으로 값이 나옴
		
		String view = null;
		if(viewName.contains(".do")) {//ex)들어온값이 .do포함 
			view=viewName; 
		}
		else {//ex)그냥 jsp페이지
			view = viewResolver.getView(viewName);
		}
		response.sendRedirect(view);
		
		
	}
}
