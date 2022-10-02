<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
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

<style type="text/css">
	.short{
		width: 350px;
	}
	
	.long{
		width: 800px;
	}
</style>

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
					<h1 class="heading aos-init aos-animate" data-aos="fade-up">매물수정</h1>

					<nav aria-label="breadcrumb" data-aos="fade-up"
						data-aos-delay="200" class="aos-init aos-animate">
						<ol class="breadcrumb text-center justify-content-center">
							<li class="breadcrumb-item "><a href="myPage.html">마이페이지</a></li>
							<li class="breadcrumb-item active text-white-50"
								aria-current="page">매물수정</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	
	<form id="eform" action="eUpdate.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="epk" value="${eData.epk}">
	<input type="hidden" name="beforeimg" value="${eData.eimgsrc}">
	<div class="container">
		<div class="col-12 mb-3">
		<h6><b>형식에 맞게 작성해 주십시오 *</b></h6>
		<br>
		<h4>매물 제목</h4>
		<input type="text" name="ename" value="${eData.ename}" placeholder="건물이름 이나 제목을 작성해주세요" class="form-control long" >
		</div>
		<div class="col-12 mb-3">
		<h4>매물 가격</h4>
		<input type="text" name="price" value="${eData.price}" placeholder="ex) 전세 - 4억 3천 or 월세 - 3000/50" class="form-control short" >
		</div>
		<div class="col-12 mb-3">
		<h4>건물 종류</h4>
		<input type="text" name="category" value="${eData.category}" placeholder="ex) 아파트, 빌라" class="form-control short">
		</div>
		<div class="col-12 mb-3">
		<h4>건물 주소</h4>
		<input type="text" name="eaddress" value="${eData.eaddress}" placeholder="ex) OO시 OO구 OO동" class="form-control long">
		</div>
		<div class="col-12 mb-3">
		<h4>면적</h4>
		<input type="text" name="einfo" value="${eData.einfo}" placeholder="ex) 26/34평	" class="form-control short" >
		</div>
		<div class="col-12 mb-3">
		<h4>관리비</h4>
		<input type="text" name="epay" value="${eData.epay}" placeholder="ex) 5만원" class="form-control short" >
		</div>
		<div class="col-12 mb-3">
		<h4>인근 지하철 역</h4>
		<input type="text" name="subway" value="${eData.subway}" placeholder="ex) 신림역, 강남역" class="form-control short" >
		</div>
		<div class="col-12 mb-3">
		<h4>사진 추가</h4>
		<input type="file" name="fileName" value="${eData.eimgsrc}">
		</div>
		<div class="col-12 mb-3" style="text-align: right;">
			<input type="submit" value="  매물수정  " class="btn btn-primary" >
			<a href="javascript:edelete()" class="btn btn-primary"> 매물삭제 </a>
		</div>
	</div>
	</form>
	<!-- 채워넣을 내용은 여기에 -->

	
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

	<script type="text/javascript">
		function edelete(){
			var f = document.getElementById("eform");
			
			f.action = "edelete.do";
			f.submit();
		}
	</script>
</body>
</html>