<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	response.sendRedirect("main.do");
%>
	
<!-- login화면 보여달라는 get요청임
	데이터를 보내야하는게 1개 이상이라도 있으면 ex) 창을 띄웠을 때, 이미지나 광고 들고가려면
	c를 들려야하기 때문에 .do로 보내야하지
	절대 .jsp로 바로 보내면 안됨!!!
	
-->	