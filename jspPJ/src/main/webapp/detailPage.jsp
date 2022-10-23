<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link
	href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;500;600;700&display=swap"
	rel="stylesheet">


<link rel="stylesheet" href="fonts/icomoon/style.css">
<link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

<link rel="stylesheet" href="css/tiny-slider.css">
<link rel="stylesheet" href="css/aos.css">
<link rel="stylesheet" href="css/style.css">

<title>사방팔방 四方八方 | 부동산 1위 사이트</title>
<style type="text/css">
#map {
	width: 100%;
	height: 500px;
	margin: 0 auto;
	border: 2px solid #005555;
}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
	<t:header />

	<div class="hero page-inner overlay"
		style="background-image: url('images/hero_bg_3.jpg');">

		<div class="container">
			<div class="row justify-content-center align-items-center">
				<div class="col-lg-9 text-center mt-5">
					<h1 class="heading" data-aos="fade-up">매물 정보</h1>

					<nav aria-label="breadcrumb" data-aos="fade-up"
						data-aos-delay="200">
						<ol class="breadcrumb text-center justify-content-center">
							<li class="breadcrumb-item "><a href="mainPage.html">Home</a></li>
							<li class="breadcrumb-item "><a href="detailPage.html">매물
									정보</a></li>
						</ol>
					</nav>


				</div>
			</div>


		</div>
	</div>


	<div class="section">
		<div class="container">
			<div class="row justify-content-between">
				<div class="col-lg-7">

					<div class="img-property-slide-wrap">
						<div class="img-property-slide">
							<img src="${eData.eimgsrc}" alt="Image" class="img-fluid">
							<!-- 이미지 가져올 방법이 없다? -->
						</div>
					</div>

				</div>
				<div class="col-lg-4">
					<p class="meta">매물 번호: ${eData.epk} 번</p>
					<h2 class="heading text-primary">${eData.price}</h2>
					<h5>${eData.ename}</h5>
					<h6>주소: ${eData.eaddress}</h6>
					<p class="text-black-50">
						-------------------------------------------</p>
					<table>
						<tr>
							<th>매물 상세정보<br></th>
						</tr>
						<tr>
							<td>종류 - ${eData.category}<br> <br></td>
						</tr>
						<tr>
							<td>면적 - ${eData.einfo}<br> <br></td>
						</tr>
						<tr>
							<td>관리비 - ${eData.epay}<br> <br>
							<td>
						</tr>
						<tr>
							<td>주변역 - ${eData.subway}</td>
						</tr>
					</table>
					<p class="text-black-50">
						-------------------------------------------</p>

					<c:choose>
						<%-- 로그인한 아이디가 멤버의 아이디이고 null이 아닐경우 --%>
						<c:when test="${mid != null}">
							<form action="eSelectOne.do?epk=${eData.epk}" method="post">
								<input type="hidden" name="condition" value="consult"><%-- 상담페이지로 갈 때 알려줄 변수 --%>
								<input type="submit" value="상담예약" class="btn btn-primary">
								<h2 id="like" class="btn btn-primary"
									style="cursor: pointer; color: red; background-color:white;">♡</h2>
							</form>
						</c:when>
						<%-- 로그인한 중개사가 매물을 등록한 중개사본인일 경우 --%>
						<c:when test="${rid == eData.rid}">
							<form id="eform" action="eSelectOne.do">
							<input type="hidden" name="condition" value="estateUpdate">
							<input type="hidden" name="epk" value="${eData.epk}">
								<input type="submit" value="정보수정" class="btn btn-primary">
								<a href="javascript:edelete()"><input type="button" value="삭제하기"
									class="btn btn-primary" style="background-color: #ffb400"></a>
							</form>
						</c:when>
						<%-- 아무도 로그인 안했을시 --%>
						<c:when test="${mid == null && rid == null}">
							<h4>상담신청은 <a href="login.jsp" style="color:blue;font-size:40px">로그인</a> 이후에 가능합니다.</h4>
						</c:when>
					</c:choose>
					<div class="d-block agent-box p-5">
						<div class="text">
							<h3 class="mb-0">공인중개사: ${rData.rname}</h3>
							<div class="meta mb-3">
								전화번호: 010${rData.rphone}<br>
								주소: ${rData.raddress}<br>
							</div>
							<div class="meta mb-3">
								<strong>소개멘트</strong><br>${rData.rment}
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<t:footer />

	<!-- Preloader -->
	<div id="overlayer"></div>
	<div class="loader">
		<div class="spinner-border" role="status">
			<span class="visually-hidden">Loading...</span>
		</div>
	</div>
	
<script type="text/javascript">
function edelete(){
	// 폼 타겟
	var f = document.getElementById("eform");
	
	f.action = "eDelete.do";
	
	f.submit();
}

$(document).ready(function(){ // 처음 페이지에 들어오면 로그인한 사용자가 좋아요를 누른적이 있는지 체크
	
    $.ajax({
        url : '${pageContext.request.contextPath}/JjimCheckAction.like1?mid=${mid}&epk=${eData.epk}',
        type : 'POST',
        success : function(result){
           console.log("데이터 변환됨"+result);
           if(result==1){
        	   $("#like").text("♥");
           }else if(result==0){
        	   $("#like").text("♡");
           }else{
        	   $("#like").text("오류!!리턴값 -1");
           }
        }
     });

    $("#like").on("click",function(){
    	console.log("click");
        $.ajax({
            url : '${pageContext.request.contextPath}/JjimAction.like2?mid=${mid}&epk=${eData.epk}',
            type : 'POST',
            success : function(result){
               console.log("데이터 변환됨"+result);
               if(result==1){
            	   $("#like").text("♥");
                }else if(result==0){
                	 $("#like").text("♡");
                }else{
                	 $("#like").text("오류!!리턴값 -1");
                }
            }
         });
    });
    
});

</script>

	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/tiny-slider.js"></script>
	<script src="js/aos.js"></script>
	<script src="js/navbar.js"></script>
	<script src="js/counter.js"></script>
	<script src="js/custom.js"></script>

</body>
</html>
