package com.kim.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.biz.member.MemberVO;
import com.kim.biz.member.impl.MemberDAO;

public class LoginController implements Controller{

   @Override
   public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
      String mid=request.getParameter("mid");
      String mpw=request.getParameter("mpw");
      MemberDAO mDAO=new MemberDAO();
      MemberVO mVO=new MemberVO();
      
      mVO.setMid(mid);
      mVO.setMpw(mpw);
      mVO = mDAO.selectOneMember(mVO);
      
      if(mVO==null) {
         return "login"; // VR가 .jsp를 추가하기 때문에 생략해서 반환
      }					 // login페이지로 이동
      else {
         return "main.do"; //controller를 거쳐서 main으로 감
      }
   }
}


