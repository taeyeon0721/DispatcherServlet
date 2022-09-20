package com.kim.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kim.biz.board.BoardVO;
import com.kim.biz.board.impl.BoardDAO;

public class BoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardVO bVO=new BoardVO();
		BoardDAO bDAO=new BoardDAO();
		
		bVO.setBid(Integer.parseInt(request.getParameter("bid")));
		bVO=bDAO.selectOneBoard(bVO);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", bVO);
		mav.setViewName("board");
		return mav;
	}

	/*
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		BoardVO bVO=new BoardVO();
		bVO.setBid(Integer.parseInt(request.getParameter("bid")));
		
		BoardDAO bDAO=new BoardDAO();
		bVO=bDAO.selectOneBoard(bVO);
		
		HttpSession session=request.getSession();
		session.setAttribute("data", bVO);
	
		return "board";
	}
	 */
	
}
