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

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="crossorigin="anonymous"></script>
</head>
<body data-aos-easing="slide" data-aos-duration="800" data-aos-delay="0">

	<t:header/>

	<div class="hero page-inner overlay"
		style="background-image: url('images/hero_bg_3.jpg');">

		<div class="container">
			<div class="row justify-content-center align-items-center">
				<div class="col-lg-9 text-center mt-5">
					<h1 class="heading aos-init aos-animate" data-aos="fade-up">상담 신청</h1>

					<nav aria-label="breadcrumb" data-aos="fade-up"
						data-aos-delay="200" class="aos-init aos-animate">
						<ol class="breadcrumb text-center justify-content-center">
							<li class="breadcrumb-item "><a href="myPage.jsp">마이페이지</a></li>
							<li class="breadcrumb-item active text-white-50"
								aria-current="page">상담 신청</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	
	<form name="consult" action="cInsert.do?epk=${eData.epk }" method="post">
	<div class="container">
		<div class="col-12 mb-3">
		<h4>매물 이름</h4>
		<input type="text" name="title" id="title" value="${eData.ename}" class="form-control" readonly><br>
		<h4>중개사 이메일 주소</h4>
		<input type="text" name="emailAddress" id="emailAddress" value="${eData.rid}" class="form-control" readonly>
		</div>
		<h4>상담 예약 날짜</h4>
		<input type="datetime-local" name="cdate" id="cdate">
		<div class="col-12 mb-3">
		<br>
		<h4>상담 내용</h4>
<textarea name="content" id="content" class="form-control" placeholder="상담할 내용을 작성해 주세요" rows="7" cols="5">
종류: ${eData.category}
가격: ${eData.price}
주소: ${eData.eaddress}
면적: ${eData.einfo}
========== 상담하실 내용을 아래 작성해주세요. ==========
</textarea>
		</div>
		<c:if test="${emptydata==-1}">
		<div>
		"상담 예약 날짜 혹은 상담 내용 필수입니다."
		<br>
		"다시 입력 후 상담 신청 부탁드립니다."
		</div>
		</c:if>
		<div class="col-12 mb-3" style="text-align: right;">
			<input type="submit" value="  상담신청  " class="btn btn-primary"  onclick="email()">
		</div>
	</div>
	</form>
	
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
	// 이메일 보내기
	var form=document.forms['consult'];
	form.onsubmit=function(){
		if (document.getElementById("cdate").value == "") {
			alert("예약 날짜는 필수입니다!!");
			return false;
		}
		if(document.getElementById("content").value == ""){
			alert("상담 내용 입력은 필수입니다!!");
			return false;
		}
	}
	
	function email(){
		var title = $("#title").val();
		var emailAddress = $("#emailAddress").val();
		var content = $("#content").val();
		var cdate = $("#cdate").val();
		
		$.ajax({
			type: 'POST',
			url: '${pageContext.request.contextPath}/Email',
			data: {emailAddress:emailAddress, content:content, title:title, cdate:cdate},
			success: function(result){
				console.log("로그: ["+result+"]");
				if(result == 1){
					$("#result").text("상담신청 이메일 전송이 완료되었습니다!");
					$("#result").css("color","blue");
					
				}
				else{
					$("#result").text("상담신청 이메일 전송이 불가합니다...");
					$("#result").css("color","red");
				}
				
			},
			
			error: function(request, status, error){ // 요청 보낸 곳(서블릿)에서 에러가 발생할 시 실행
				console.log("code: "+request.status);
				console.log("message: "+request.responseText);
				console.log("error: "+error);
			}
			
		});
	}
</script>


</body>
</html>