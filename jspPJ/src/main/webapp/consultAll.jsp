<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="Untree.co">
<link rel="shortcut icon" href="favicon.png">

<meta name="description" content="">
<meta name="keywords" content="bootstrap, bootstrap5">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin="">
<link
	href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;500;600;700&amp;display=swap"
	rel="stylesheet">


<link rel="stylesheet" href="fonts/icomoon/style.css">
<link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

<link rel="stylesheet" href="css/tiny-slider.css">
<link rel="stylesheet" href="css/aos.css">
<link rel="stylesheet" href="css/style.css">

<title>사방팔방 四方八方 | 부동산 1위 사이트</title>
<style></style>
</head>
<body data-aos-easing="slide" data-aos-duration="800" data-aos-delay="0">

	<t:header/>

	<div class="hero page-inner overlay"
		style="background-image: url('images/hero_bg_3.jpg');">

		<div class="container">
			<div class="row justify-content-center align-items-center">
				<div class="col-lg-9 text-center mt-5">
					<h1 class="heading aos-init aos-animate" data-aos="fade-up">전체 상담내역</h1>

					<nav aria-label="breadcrumb" data-aos="fade-up"
						data-aos-delay="200" class="aos-init aos-animate">
						<ol class="breadcrumb text-center justify-content-center">
							<li class="breadcrumb-item "><a href="myPage.jsp">마이페이지</a></li>
							<li class="breadcrumb-item active text-white-50"
								aria-current="page">전체 상담내역</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<div class="container">
	
	<table class="table custom-table">
          <thead>
            <tr>
              <th scope="col">매물번호</th>
              <th scope="col">작성자</th>
              <th scope="col">매물 제목</th>
              <th scope="col">중개사</th>
              <th scope="col">작성일</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach var="c" items="${cDatas}">
            <tr>
              <td>
               	${c.cid}
              </td>
              <td>${mname}</td>
              <td>
               	<a href="cSelectOne.do?cid=${c.cid}">${c.title}</a>
              </td>
              <td>${c.rid}</td>
              <td>${c.writeday}</td>
            </tr>
            <tr class="spacer"><td colspan="100"></td></tr>
          </c:forEach>
          </tbody>
        </table>
	</div>
	
    <t:footer/>

	<!-- Preloader -->
	<div id="overlayer" style="opacity: -0.1; display: none;"></div>
	<div class="loader" style="opacity: -0.1; display: none;">
		<div class="spinner-border" role="status">
			<span class="visually-hidden">Loading...</span>
		</div>
	</div>

	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/tiny-slider.js"></script>
	<script src="js/aos.js"></script>
	<script src="js/navbar.js"></script>
	<script src="js/counter.js"></script>
	<script src="js/custom.js"></script>


</body>
</html>