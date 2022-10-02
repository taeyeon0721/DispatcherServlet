<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<!doctype html>
<html lang="en"><head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="author" content="Untree.co">
	<link rel="shortcut icon" href="favicon.png">

	<meta name="description" content="">
	<meta name="keywords" content="bootstrap, bootstrap5">
	
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin="">
	<link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;500;600;700&amp;display=swap" rel="stylesheet">


	<link rel="stylesheet" href="fonts/icomoon/style.css">
	<link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

	<link rel="stylesheet" href="css/tiny-slider.css">
	<link rel="stylesheet" href="css/aos.css">
	<link rel="stylesheet" href="css/style.css">

	<title>사방팔방 四方八方 | 부동산 1위 사이트</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="crossorigin="anonymous"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body data-aos-easing="slide" data-aos-duration="800" data-aos-delay="0">

	<t:header/>

	<div class="hero page-inner overlay" style="background-image: url('images/hero_bg_1.jpg');">

		<div class="container">
			<div class="row justify-content-center align-items-center">
				<div class="col-lg-9 text-center mt-5">
					<h1 class="heading aos-init aos-animate" data-aos="fade-up">중개사 회원가입</h1>

					<nav aria-label="breadcrumb" data-aos="fade-up" data-aos-delay="200" class="aos-init aos-animate">
						<ol class="breadcrumb text-center justify-content-center">
							<li class="breadcrumb-item "><a href="main.do">Home</a></li>
							<li class="breadcrumb-item active text-white-50" aria-current="page">중개사 회원가입</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>


	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 mb-5 mb-lg-0 aos-init aos-animate" data-aos="fade-up" data-aos-delay="100">
					<div class="contact-info">

						<div class="address mt-2">
							<i class="icon-room"></i>
							<h4 class="mb-2">Location</h4>
							<p>서울 강남구 테헤란로 146<br>(주)개발의 민족</p>
						</div>

						<div class="open-hours mt-4">
							<i class="icon-clock-o"></i>
							<h4 class="mb-2">Open Hours:</h4>
							<p>
								Monday-Friday:<br>
								09:00 AM - 18:00 PM
							</p>
						</div>

						<div class="email mt-4">
							<i class="icon-envelope"></i>
							<h4 class="mb-2">Email:</h4>
							<p>admin@developer.com</p>
						</div>

						<div class="phone mt-4">
							<i class="icon-phone"></i>
							<h4 class="mb-2">Call:</h4>
							<p>02-8282-5923</p>
						</div>

					</div>
				</div>
				<div class="col-lg-8 aos-init aos-animate" data-aos="fade-up" data-aos-delay="200">
					<form action="rInsert.do" method="post" name="signUp" id="sign-up">
							<!-- 수정 : action값을 중개사회원가입.do 로 -->
					<input type="hidden" name="action" value="rInsert.do">
						<div class="row">
						<h2>계정 생성</h2></br>
						<hr>
							<div class="col-12 mb-3">
								<p>아이디</p>
								<input type="email" id="userid" name="rid" class="form-control" placeholder="이메일 주소 입력" >
							</div>
							<div class="col-12 mb-3">
								<p>비밀번호</p>
								<input type="password" id="userpasswd" name="rpw" class="form-control" placeholder="8자리 이상 입력" >
							</div>
							<div class="col-12 mb-3">
								<p>비밀번호 확인</p>
								<input type="password" id="userpasswdcheck" class="form-control" placeholder="비밀번호 확인">
								<p id="warn" style="color:red">입력하신 비밀번호와 일치하지 않습니다. 확인 후 다시 입력해주세요</p>
							</div>
							<h2>개인 정보</h2></br>
							<hr>
							<div class="col-12 mb-3">
								<p>이름</p>
								<input type="text" id="username" name="rname" class="form-control" placeholder="이름 입력" maxlength="5">
							</div>
							<div class="col-12 mb-3">
                        <p style="  margin-bottom: 0px;">전화번호</p>
                     </div>
                     	 <input type="tel" name="mphone1" class="form-control" value="010" disabled style="width: 180px; margin-left: 12px; margin-right:10px; text-align: center;">
                        <input type="tel" name="rphone" id="phone" class="form-control" placeholder="12345678"  maxlength="8" style="width: 255px; margin-left: 12px; margin-right:10px;"/>
						<a href="javascript:sms();">인증번호 전송</a>
						<div id="result1"></div>
						
						<input type="tel" name="checkNum" id="checkNum" maxlength="6" class="form-control" style="width: 155px; margin-left: 12px; margin-right:10px;"/>
						<a href="javascript:smsCheck();">인증번호 확인</a>
						<div id="result2"></div>
								<p>사무실 주소</p>
								<input type="text" name="rpostcode" id="sample2_postcode" class="form-control" placeholder="우편번호" readonly style="width: 120px; margin-left: 12px; margin-right:10px;">
								<input type="button" onclick="sample2_execDaumPostcode()" value="우편번호 찾기"  style="width: 120px; border:white; height: 42px; text-align: center; background-color:#2ac1bc; color:white; margin-left: 10px;">
							<div class="col-12 mb-3">
								<input type="text" name="raddress" id="sample2_address" class="form-control" placeholder="주소" readonly>
								<input type="text" name="rdetailaddress" id="sample2_detailAddress"class="form-control"  placeholder="상세주소">
								<input type="text" name="rextraaddress" id="sample2_extraAddress" class="form-control" placeholder="참고항목" readonly>
							</div>
							
							<div class="col-12">
								<p>소개멘트</p>
								<p><textarea id="userment" name="rment" class="form-control" placeholder="소개할 멘트를 작성해 주세요" rows="7"></textarea></p>
							</div>
							
							<div class="col-12">
								<input type="submit" value="  회원가입  " class="btn btn-primary" >
							</div>

						</div>
					</form>
				</div>
			</div>
		</div>
	</div> <!-- /.untree_co-section -->
	<div id="layer"
		style="display: none; position: fixed; overflow: hidden; z-index: 1; -webkit-overflow-scrolling: touch;">
		
		<img src="//t1.daumcdn.net/postcode/resource/images/close.png"
			id="btnCloseLayer"
			style="cursor: pointer; position: absolute; right: -3px; top: -3px; z-index: 1"
			onclick="closeDaumPostcode()" alt="닫기 버튼">
	</div>

	<t:footer/>
    
	<script type="text/javascript">
	
	var number = 0; // 랜덤문자인증번호 저장 변수
	var phoneCheck = 0; // 인증번호 일치, 불일치 변수
	
	// 문자 API
	
		function idCheck(){
			var userid = $("#userid").val();
			
			$.ajax({
				type: 'POST',
				url: '${pageContext.request.contextPath}/idCheck',
				data:{userid:userid},
				success: function(result){
					console.log("로그: ["+result+"]")
					if(result == 1){
						$("#result").text("사용가능한 아이디 입니다!");
						$("#result").css("color","blue");						
					}
					else{
						$("#result").text("중복된 아이디가 존재합니다...");
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
	
		function sms(){
			var phone = $("#phone").val();
			
			$.ajax({
				type: 'POST',
				url: '${pageContext.request.contextPath}/Sms',
				data:{phone:phone},
				success: function(randNum){
					console.log("로그: ["+randNum+"]")
					if(randNum != null){
						$("#result1").text("인증번호 전송이 완료되었습니다!");
						$("#result1").css("color","blue");
						
						number = randNum;
						
					}
					else{
						$("#result1").text("인증번호 전송이 불가합니다...");
						$("#result1").css("color","red");
					}
					
				},
				
				error: function(request, status, error){ // 요청 보낸 곳(서블릿)에서 에러가 발생할 시 실행
					console.log("code: "+request.status);
					console.log("message: "+request.responseText);
					console.log("error: "+error);
				}
				
			});
		}
		

		function smsCheck(){
			var checkNum = $("#checkNum").val();
			
			$.ajax({
				type: 'POST',
				url: '${pageContext.request.contextPath}/SmsCheck',
				data: {randNum:number,checkNum:checkNum},
				success: function(result){
					console.log("로그: ["+result+"]")
					if(result == 1){
						$("#result2").text("인증번호가 일치합니다");
						$("#result2").css("color","blue");
						
						phoneCheck = 1;
						console.log("로그1: ["+phoneCheck+"]");
					}
					else{
						$("#result2").text("인증번호가 일치하지 않습니다");
						$("#result2").css("color","red");
						
						phoneCheck = -1;
						console.log("로그2: ["+phoneCheck+"]");
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

    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/tiny-slider.js"></script>
    <script src="js/aos.js"></script>
    <script src="js/navbar.js"></script>
    <script src="js/counter.js"></script>
    <script src="js/custom.js"></script>
    
    <script type="text/javascript">
	const tmp1 = document.getElementById("warn");
	tmp1.style.visibility = 'hidden';
	
	var form=document.forms['sign-up'];
	
	form.onsubmit=function(){
		
		var pwd = document.getElementById("userpasswd");
		var check = document.getElementById("userpasswdcheck");
		
		if (document.getElementById("userid").value == "") {
			alert("아이디를 입력하세요.");
			return false;
		}
		if (pwd.value== "" ) {
			alert("비밀번호를 입력하세요.");
			return false;
		}
		if(pwd.value.length<8){
			alert("8자리 이상 입력하세요")
			return false;
		}
		
		if (pwd.value != check.value) {
			alert("비밀번호 불일치");
			tmp1.style.visibility = 'visible';
			return false;
		}
		if (document.getElementById("username").value == "") {
			alert("이름을 입력하세요.");
			return false;
		}
		if (document.getElementById("phone").value == "") {
			alert("휴대폰 번호를 입력하세요.");
			return false;
		}
		if(document.getElementById("phone").value.length!=8){
			alert("휴대폰 번호를 모두 입력해주세요!.");
			return false;
		}

		if(document.getElementById("sample2_postcode").value == ""){
			alert("주소를 입력해 주세요");
			return false;
		}
		
		if(document.getElementById("sample2_detailAddress").value == ""){
			alert("상세주소를 입력해 주세요");
			return false;
		}
		
		if(phoneCheck == -1 || phoneCheck == 0){
			<%
			System.out.println("로그: phoneCheck() 안에 들어옴");
			%>
			
			alert("인증번호를 확인해 주세요");
			return false;
		}
		
		if(pwd.value == check.value){
			tmp1.style.visibility = 'hidden';
		}
	}
	</script>

    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/tiny-slider.js"></script>
    <script src="js/aos.js"></script>
    <script src="js/navbar.js"></script>
    <script src="js/counter.js"></script>
    <script src="js/custom.js"></script>
    
    
   <script>
    // 우편번호 찾기 화면을 넣을 element
    var element_layer = document.getElementById('layer');

    function closeDaumPostcode() {
        // iframe을 넣은 element를 안보이게 한다.
        element_layer.style.display = 'none';
    }

    function sample2_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample2_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample2_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample2_postcode').value = data.zonecode;
                document.getElementById("sample2_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample2_detailAddress").focus();

                // iframe을 넣은 element를 안보이게 한다.
                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
                element_layer.style.display = 'none';
            },
            width : '100%',
            height : '100%',
            maxSuggestItems : 5
        }).embed(element_layer);

        // iframe을 넣은 element를 보이게 한다.
        element_layer.style.display = 'block';

        // iframe을 넣은 element의 위치를 화면의 가운데로 이동시킨다.
        initLayerPosition();
    }

    // 브라우저의 크기 변경에 따라 레이어를 가운데로 이동시키고자 하실때에는
    // resize이벤트나, orientationchange이벤트를 이용하여 값이 변경될때마다 아래 함수를 실행 시켜 주시거나,
    // 직접 element_layer의 top,left값을 수정해 주시면 됩니다.
    
    function initLayerPosition(){ // 홍준 : 레이어를 화면가운데에 보여주기위한 메서드
    	
    	// 홍준 : 레이어드의 크기설정
        var width = 300; //우편번호서비스가 들어갈 element의 width
        var height = 400; //우편번호서비스가 들어갈 element의 height
        var borderWidth = 5; //샘플에서 사용하는 border의 두께

        // 홍준 : 레이어드를 가운데에 고정하여 보여주기위한 width, height, left, top 설정
        // 위에서 선언한 값들을 실제 element에 넣는다.
        element_layer.style.width = width + 'px';
        element_layer.style.height = height + 'px';
        element_layer.style.border = borderWidth + 'px solid';
        // 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
        element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width)/2 - borderWidth) + 'px';
        element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height)/2 - borderWidth) + 'px';
    }
</script>
  
</body></html>