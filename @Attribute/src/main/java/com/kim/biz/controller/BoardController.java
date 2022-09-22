package com.kim.biz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kim.biz.board.BoardVO;
import com.kim.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("data") //"data"라는 이름의 데이터가 Model 객체에 세팅이 된다면, 
						   // 그것을 session에 기억시키겠다
public class BoardController {
	
	@ModelAttribute("scMap") //@requestMapping보다 빨리 호출됨
	public Map<String,String> searchConditionMap(){// <key,value>
		Map<String,String> scMap = new HashMap<String,String>();
		scMap.put("제목", "TITLE"); //VIEW에 어떻게 보여야하는지
		scMap.put("작성자", "WRITER"); //MODEL에서 어떻게 쓰여야하는지
		return scMap;
		//모델에 자동 저장됨 == Model.addAttribute();
	}
	
	
	@RequestMapping("/main.do")
	public String selectAllBoard(@RequestParam(value="searchCondition",defaultValue="TITLE",required=false)String searchCondition, @RequestParam(value="searchContent",defaultValue="",required=false) String searchContent, BoardVO bVO, BoardDAO bDAO, Model model) {
		
		System.out.println("검색조건: "+searchCondition);
	    System.out.println("검색어: "+searchContent);
		
		List<BoardVO> datas=bDAO.selectAllBoard(bVO);
		
		model.addAttribute("datas",datas);
		System.out.println("메인로그");
		return "main.jsp";
	}
	
	
	@RequestMapping("/board.do")
	// 자동매핑 안되는 경우?
	//command객체의 멤버변수로 SearchCondition이나 Content가 없기때문에
	// VO에 자바에서만 쓰는 멤버변수로 추가 -> 가장 이상적
	public String selectOneBoard(BoardVO bVO, BoardDAO bDAO, Model model) {

		bVO=bDAO.selectOneBoard(bVO);
		
		model.addAttribute("data", bVO);
		return "board.jsp";
	}
	
	@RequestMapping("/binsert.do")
	public String insertBoard(BoardVO bVO, BoardDAO bDAO) {
		System.out.println("insertb로그: "+bVO);
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
	
	@RequestMapping("/bupdate.do")
	public String updateBoard(@ModelAttribute("data")BoardVO bVO, BoardDAO bDAO) {
		
		System.out.println("update로그: "+bVO);
		//sessionAttributes 로그
		bDAO.updateBoard(bVO);
		
		if(bVO==null) {
			return "board.jsp";
		}
		else {
			return "redirect:main.do";
			//forward: 요청정보를 다음페이지로 유지(url유지)
			//redirect: 새 요청(url바뀜)
		}
	}
	
	@RequestMapping("/bdelete.do")
	public String deleteBoard(BoardVO bVO, BoardDAO bDAO) {
		
		System.out.println("delete로그: "+bVO);
		//sessionAttributes 로그
		bDAO.deleteBoard(bVO);
		
		if(bVO==null) {
			return "board.jsp";
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
