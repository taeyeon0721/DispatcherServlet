package com.kim.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kim.biz.member.MemberVO;
import com.kim.biz.member.impl.MemberDAO;

@Controller
public class MemberController {

	//로그인페이지 보여줘(get방식)
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String index() {
		//String: 페이지이동만 시킬때
		return "login.jsp";
	}

	//로그인 해줘(post방식)
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	//value 속성은 하나만 작성했을 때 생략할 수 있음
	//get방식말고 post방식만 받고싶을 때 method씀
	public String selectOneMember(MemberVO mVO, MemberDAO mDAO, HttpServletRequest request) {
		//String: 페이지이동만 시킬때
		mVO=mDAO.selectOneMember(mVO); //로그인을 수행하는 비즈니스 메서드 R

		if(mVO==null) { //로그인 실패했을 때 
			return "login.jsp"; //default가 forward
			//어떤 값이 위에 세팅될지 모르니까 일단은 forward로 했는데 지금은 값이 없으니까 페이지 이동만 됨
		}
		else {//로그인 성공했을 때 
			HttpSession session=request.getSession();//왜 session? 브라우저 끄기 전까지 무조건 가지고 있어야 하니까
			session.setAttribute("member", mVO);
			//set해줘야 v에서 이엘식으로 꺼내쓸 수 있음
			return "redirect: main.do";
		}
	}

	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.invalidate();
		return "redirect:login.do";
		//viewResolver는 default가 forward방식이라 redirect할때만 써주면 됨
	}

	@RequestMapping("/mypage.do")		
	public String mypage () {
		return "mypage.jsp";
	}

	@RequestMapping("/update.do")
	public String updateMember(MemberVO mVO, MemberDAO mDAO, HttpSession session){

		mDAO.updateMember(mVO);
		System.out.println("update로그"+mVO);
		session.setAttribute("member", mVO);
		//update된 정보를 session에 다시 저장하지않으면 이전 session정보를 사용하기때문에 다시 set해야함
		return "main.do";
	}
	
	@RequestMapping("/signin.do")
	public String insertMember(MemberVO mVO, MemberDAO mDAO){
		
		mDAO.insertMember(mVO);
		System.out.println("sigin로그: "+mVO);
		if(mVO==null) {
			return "signin.jsp";
		}
		else {
			return "main.do";
		}
	}
	
	@RequestMapping("/delete.do")
	public String deleteMember(MemberVO mVO, MemberDAO mDAO,HttpSession session) {
		System.out.println("deleteC로그: "+mVO);
		//mVO가 null인 이유가 v에서 넘겨준 파라미터가 0개이기 때문
		//v에서 값 같이 넘겨줘야함
	  //mVO=(MemberVO)session.getAttribute("member");
		mDAO.deleteMember(mVO);
		System.out.println("deleteC로그2:" +mVO);
		session.invalidate();
		
		return "main.do";
	}
}

