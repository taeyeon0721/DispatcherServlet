package com.kim.biz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kim.biz.board.BoardVO;
import com.kim.biz.board.impl.BoardDAO;

@Controller
public class BoardController {

	@RequestMapping("/board.do")
	public ModelAndView selectOneBoard(BoardVO bVO, BoardDAO bDAO, ModelAndView mav) {

		bVO=bDAO.selectOneBoard(bVO);
		
		mav.addObject("data", bVO);
		mav.setViewName("board.jsp");//아직 하나의 로직 수행중: forward
		return mav;
	}
	
	@RequestMapping("/write.do")
	public String insertBoard(BoardVO bVO, BoardDAO bDAO) {
		
		bDAO.insertBoard(bVO);
		
		if(bVO==null) {
			return "write.jsp";
		}
		else {
			return "redirect:main.do";
			//forward: 요청정보를 다음페이지로 유지(url유지)
			//redirect: 새 요청(url바뀜)
		}
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
