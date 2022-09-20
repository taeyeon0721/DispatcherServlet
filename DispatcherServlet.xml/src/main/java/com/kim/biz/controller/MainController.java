package com.kim.biz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kim.biz.board.BoardVO;
import com.kim.biz.board.impl.BoardDAO;

public class MainController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardVO bVO=new BoardVO();
		
		BoardDAO bDAO=new BoardDAO();
		List<BoardVO> datas=bDAO.selectAllBoard(bVO);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("datas", datas);
		//mav에 정보를 담아서 보내는 것
		//ex) request.setAttribute("");
		mav.setViewName("main");
		return mav;
	}

	/*
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		BoardVO bVO=new BoardVO();
		
		BoardDAO bDAO=new BoardDAO();
		List<BoardVO> datas=bDAO.selectAllBoard(bVO);
		
		HttpSession session=request.getSession();
		session.setAttribute("datas", datas);
		
		return "main";
	}
	*/
	
}
//HttpSession session=request.getSession();
//session.setAttribute("datas", datas);