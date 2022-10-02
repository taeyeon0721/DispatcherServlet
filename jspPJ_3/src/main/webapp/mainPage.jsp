<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="author" content="Untree.co">
	<link rel="shortcut icon" href="favicon.png">

	<meta name="description" content="" />
	<meta name="keywords" content="bootstrap, bootstrap5" />
	
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;500;600;700&display=swap" rel="stylesheet">


	<link rel="stylesheet" href="fonts/icomoon/style.css">
	<link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

	<link rel="stylesheet" href="css/tiny-slider.css">
	<link rel="stylesheet" href="css/aos.css">
	<link rel="stylesheet" href="css/style.css">

	<title>사방팔방 四方八方 | 부동산 1위 사이트</title>
	   <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="crossorigin="anonymous"></script>
   
   <script type="text/javascript">
   
   var popupWidth = 600;
   var popupHeight = 780;
   
   var popupX = (window.screen.width / 2) - (popupWidth * 1.5);
   // 만들 팝업창 width 크기의 1/2 만큼 보정값으로 빼주었음

   var popupY= (window.screen.height / 2) - (popupHeight / 2);
   // 만들 팝업창 height 크기의 1/2 만큼 보정값으로 빼주었음
   function pop()
   {
      window.open("recommendEstate.jsp", "pop", 'status=no, height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY);
   	//순서대로 "팝업창 열었을 때 연결될 url", "팝업이 열렸을 때 팝업창 이름", "팝업옵션(여러가지 속성값 지정가능)" 
   }
   
   </script> 
   
   <!--     팝업 코드 실행 여부 확인 -->
    <c:if test="${unShowPop!=-1}">
    <script type="text/javascript">
       window.onload=pop;
    </script>
    </c:if>
    
	</head>
	
<body>

	<t:header/>

	<div class="hero">


		<div class="hero-slide">
			<div class="img overlay" style="background-image: url('images/hero_bg_3.jpg')"></div>
			<div class="img overlay" style="background-image: url('images/hero_bg_2.jpg')"></div>
			<div class="img overlay" style="background-image: url('images/hero_bg_1.jpg')"></div>
		</div>

		<div class="container">
			<div class="row justify-content-center align-items-center">
				<div class="col-lg-9 text-center">
					<c:if test="${mid != null}">
					<h1 class="heading" data-aos="fade-up">${mname} 님 어서오세요</h1>
					</c:if>
					<c:if test="${rid != null}">
					<h1 class="heading" data-aos="fade-up">${rname} 님 어서오세요</h1>
					</c:if>
					<h1 class="heading" data-aos="fade-up">어떤 방을 찾으세요?</h1>
					<form action="eMain.do" class="narrow-w form-search d-flex align-items-stretch mb-3" data-aos="fade-up" data-aos-delay="200">
						<!-- action 정해놓기 -->
						<select name="searchCondition" class="btn btn-primary">
							<option value="address">지역</option>
							<option value="subway">지하철</option>
						</select>
						&nbsp;&nbsp;&nbsp;
						<input type="text" name="searchContent" class="form-control px-4" placeholder="지역 또는 단지명을 입력하세요.">
						<button type="submit" class="btn btn-primary">Search</button>
					</form>
				</div>
			</div>
		</div>
	</div>


	<div class="section">
		<div class="container">
			<div class="row mb-5 align-items-center">
				<div class="col-lg-6">
					<h2 class="font-weight-bold text-primary heading">추천 매물</h2>
				</div>
				<div class="col-lg-6 text-lg-end">
					<p><a href="eMain.do" class="btn btn-primary text-white py-3 px-4">전체 매물 보기</a></p>
				</div>
			</div>
			<div class="row">

				<div class="col-12">


					<div class="property-slider-wrap">



						<div class="property-slider">

							<c:forEach var="e" items="${eDatas}">
							<div class="property-item">

								<a href="eSelectOne.do?epk=${e.epk}" class="img">
									<img src="${e.eimgsrc}" alt="Image" class="img-fluid">
								</a>

								<div class="property-content">
									<div class="price mb-2">
									<span>${e.subway} / ${e.category}</span>
									</div>
									<div>
										<span class="d-block mb-2 text-black-50">[ ${e.ename} ]  ${e.einfo}</span>
										<span class="city d-block mb-3">${e.price}</span>

										<a href="eSelectOne.do?epk=${e.epk}" class="btn btn-primary py-2 px-3">매물 보기</a>
									</div>
								</div>
							</div> <!-- .item -->
							</c:forEach>
							
						</div>
						<div id="property-nav" class="controls" tabindex="0" aria-label="Carousel Navigation">
							<span class="prev" data-controls="prev" aria-controls="property" tabindex="-1">이전</span>
							<span class="next" data-controls="next" aria-controls="property" tabindex="-1">다음</span>
						</div>

					</div>
				</div>

			</div>
		</div>
	</div>
	
	<div class="section sec-testimonials">
		<div class="container">
			<div class="row mb-5 align-items-center">
				<div class="col-md-6">
					<h2 class="font-weight-bold heading text-primary mb-4 mb-md-0">실시간 고객 상담</h2>
				</div>
				<div class="col-md-6 text-md-end">
					<div id="testimonial-nav">
						<span class="prev" data-controls="prev">이전</span>
						
						<span class="next" data-controls="next">다음</span>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-4">
					
				</div>
			</div>
			<div class="testimonial-slider-wrap">
				<div class="testimonial-slider">
					<c:forEach var="c" items="${cDatas}">
					<div class="item">
						<div class="testimonial">
							<h3 class="h5 text-primary mb-4">${c.title}</h3>
							<blockquote>
								<p style="font-size: 20px">${c.writeday}</p>
							</blockquote>
							<p class="text-black-50"></p>
						</div>
					</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	
	<div class="section section-5 bg-light">
		<div class="container">
			<div class="row justify-content-center  text-center mb-5">
				<div class="col-lg-6 mb-5">
					<h2 class="font-weight-bold heading text-primary mb-4">8월 중개사 랭킹</h2>
					<p class="text-black-50">계약 성공 횟수와 상담 횟수 등을 종합하여 통계를 낸 수치이며</br> 중개사 분들의 홍보를 위한 목적으로 계시됩니다.</p>
				</div>
			</div>
			<div class="row">
			<c:forEach var="r" items="${rDatas}" varStatus="status">
				<div class="col-sm-6 col-md-6 col-lg-4 mb-5 mb-lg-0">
					<div class="h-100 person">
						<c:if test="${status.index == 0}">
						<img src="images/1st.png" alt="gold" class="img-fluid">
						</c:if>
						<c:if test="${status.index == 1}">
						<img src="images/2nd.png" alt="silver" class="img-fluid">
						</c:if>
						<c:if test="${status.index == 2}">
						<img src="images/3rd.png" alt="bronze" class="img-fluid">
						</c:if>
						<div class="person-contents">
							<h2 class="mb-0"><a href="#">공인중개사 | ${r.rname}</a></h2>
							<span class="meta d-block mb-3">${r.raddress}</span>
							<p>${r.rment}</p>

							<ul class="social list-unstyled list-inline dark-hover">
								<li class="list-inline-item"><span class="icon-twitter"></span></li>
								<li class="list-inline-item"><span class="icon-facebook"></span></li>
								<li class="list-inline-item"><span class="icon-linkedin"></span></li>
								<li class="list-inline-item"><span class="icon-instagram"></span></li>
							</ul>
						</div>
					</div>
				</div>
			</c:forEach>
			</div>
		</div>
	</div>

	<t:footer/>


    <!-- Preloader -->
    <div id="overlayer"></div>
    <div class="loader">
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
