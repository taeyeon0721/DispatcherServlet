<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<div class="site-mobile-menu site-navbar-target">
		<div class="site-mobile-menu-header">
			<div class="site-mobile-menu-close">
				<span class="icofont-close js-menu-toggle"></span>
			</div>
		</div>
		<div class="site-mobile-menu-body"></div>
	</div>
	
	<nav class="site-nav">
		<div class="container">
			<div class="menu-bg-wrap">
				<div class="site-navigation">
					<a href="main.do" class="logo m-0 float-start">사방팔방 四方八方</a>

					<ul class="js-clone-nav d-none d-lg-inline-block text-start site-menu float-end">
						<li><a href="main.do">Home</a></li>
						<li class="has-children">
							<a href="eMain.do">전체 매물 보기</a>
						</li>
						<c:choose>
							<%-- 일반회원이 null 아니라면 --%>
							<c:when test="${mid != null}">
								<li><a href="logout.do">로그아웃</a></li>
								<li><a href="myPage.jsp">마이페이지</a></li>
							</c:when>
							<%-- 중개사회원이 null 아니라면 --%>
							<c:when test="${rid != null}">
								<li><a href="logout.do">로그아웃</a></li>
								<li><a href="myPage.jsp">마이페이지</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="login.jsp">로그인</a></li>
								<li><a href="chooseOne.jsp">회원가입</a></li>
							</c:otherwise>
						</c:choose>
					</ul>

					<a href="#" class="burger light me-auto float-end mt-1 site-menu-toggle js-menu-toggle d-inline-block d-lg-none" data-toggle="collapse" data-target="#main-navbar">
						<span></span>
					</a>

				</div>
			</div>
		</div>
	</nav>
