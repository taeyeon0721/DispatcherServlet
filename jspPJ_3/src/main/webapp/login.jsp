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
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="crossorigin="anonymous">
</script> 

<style type="text/css">

.error_message{
    display: inline-block;
    font-size: 18px;
    line-height: 16px;
    letter-spacing: -.5px;
    color: #ff003e;
    vertical-align: middle;
}

</style>

</head>

<body data-aos-easing="slide" data-aos-duration="800" data-aos-delay="0">

   <t:header />

   <div class="hero page-inner overlay"
      style="background-image: url('images/hero_bg_1.jpg');">

      <div class="container">
         <div class="row justify-content-center align-items-center">
            <div class="col-lg-9 text-center mt-5">
               <h1 class="heading aos-init aos-animate" data-aos="fade-up">로그인</h1>

               <nav aria-label="breadcrumb" data-aos="fade-up"
                  data-aos-delay="200" class="aos-init aos-animate">
                  <ol class="breadcrumb text-center justify-content-center">
                     <li class="breadcrumb-item "><a href="mainPage.html">Home</a></li>
                     <li class="breadcrumb-item active text-white-50"
                        aria-current="page">로그인</li>
                  </ol>
               </nav>
            </div>
         </div>
      </div>
   </div>

   <div class="section">
      <div class="container">
         <div class="col-lg-4 mb-5 mb-lg-0 aos-init aos-animate"
            data-aos="fade-up" data-aos-delay="100"></div>
         <div class="col-lg-8 aos-init aos-animate" data-aos="fade-up"
            data-aos-delay="200" style="overflow: hidden; margin: 0 auto;">
            
            <form id="login"name="login" action="login.do">
               <!-- action을 로그인.do로 보낸다-->
               <div class="row" style="width: 500px; margin: 0 auto;">
                  <div class="col-12 mb-3">
                     <input type="radio" name="role" id="member" value="member" checked>개인회원&nbsp;&nbsp; 
                     <input type="radio" name="role" value="realtor">중개사
                     <input type="text"id="id" name="id" class="form-control" placeholder="아이디" required>
                  </div>
                  <div class="col-12 mb-3">
                     <input type="password" id="pw" name="pw" class="form-control" placeholder="비밀번호" required>
                  </div>
                  <c:if test="${loginWarn==-1}">
                  <div class="error_message">
                   "아이디(로그인 전용 아이디) 또는 비밀번호를 잘못 입력했습니다."
                   <br>
                   <br>
                  </div>
                  </c:if>
                  <div class="col-12">
                     <input type="submit" value="로그인" class="btn btn-primary"
                        style="padding-bottom: 15px; border-bottom-width: 10px; margin-bottom: 3px; width: 124px;">
                     |&nbsp;<a href="chooseOne.jsp" style="white-space: nowrap">회원가입
                     </a>
                  </div>
                  <br><br><br><br>
                  <div class="col-12">
                      <a id="naverIdLogin_loginButton" href="javascript:void(0)">
                        <img alt="네이버 로그인" src="images/naverLogo.png" style="width: 230px;">
                        </a>
                   <a href="javascript:kakaoLogin();"><img src="images/kakaoLogo.png" alt="카카오계정 로그인" style="width: 230px;"/></a>
                  </div>
               </div>
            </form>
         </div>
      </div>
   </div>
   <!-- /.untree_co-section -->

   <t:footer />

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
   <script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>

<!-- ****************************네이버 로그인 API 코드 **************************** -->
<script>

var naverLogin = new naver.LoginWithNaverId(
      
      {
         clientId: "J1cbMWHwsPJpgLBBCYrK", //내 애플리케이션 정보에 cliendId를 입력해줍니다.
         callbackUrl: "http://localhost:8005/jspPJ_3/login.jsp", // 내 애플리케이션 API설정의 Callback URL 을 입력해줍니다.
         						//로그인 성공시 다시 돌아올 페이지 url
         isPopup: false,
         callbackHandle: true
      }
   );   

naverLogin.init();

window.addEventListener('load', function () { // 로드가 자동으로 되서 문제인듯?
   naverLogin.getLoginStatus(function (status) {
      if (status) {
         var email = naverLogin.user.getEmail(); // 필수로 설정할것을 받아와 아래처럼 조건문을 줍니다.
        			 //로그인에 성공하면 현재로그인한 사용자의 이메일을 불러올 수 있게됨 -> 로그인성공
         console.log(email);
         
         if(email != null){
            var form=document.forms['login'];
            $('#id').val(email);//id의 value값을 이메일값으로 넣음
            form.action = "naverlogin.do";
            form.submit();
            
         }
      
//          $.ajax({
//             type: 'POST',
//             url: '${pageContext.request.contextPath}/naverLogin',
//             data:{mid:email},
//             success: function(result){
//                console.log("로그: ["+result+"]")
//             },
//             error: function(request, status, error){ // 요청 보낸 곳(서블릿)에서 에러가 발생할 시 실행
//                console.log("code: "+request.status);
//                console.log("message: "+request.responseText);
//                console.log("error: "+error);
//             }
            
//          }); // 쿠키비우기
          
            if( email == undefined || email == null) {
            alert("이메일은 필수정보입니다. 정보제공을 동의해주세요.");
            naverLogin.reprompt();
            return;
         }
      } else {
         console.log("callback 처리에 실패하였습니다.");
      }
   });
});


var testPopUp;
function openPopUp() { // 팝업이 나옴
    testPopUp= window.open("https://nid.naver.com/nidlogin.logout", "_blank", "toolbar=yes,scrollbars=yes,resizable=yes,width=1,height=1");
}
function closePopUp(){ // 그 후 팝업 종료
    testPopUp.close();
}

function naverLogout() { // 로그아웃시 팝업 등장했다 사라짐
   openPopUp();
   setTimeout(function() {
      closePopUp();
      }, 1000);
}


</script>
<!-- 네이버 스크립트 종료 -->

<!-- 카카오 스크립트 -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
Kakao.init('a9015046a1b31ec856c5fa22ee64ae20'); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단
//카카오로그인

        function kakaoLogin() {
            window.Kakao.Auth.login({
//                 scope: 'account_email', //동의항목 페이지에 있는 개인정보 보호 테이블의 활성화된 ID값을 넣습니다.
                success: function(response) {
                      Kakao.API.request({
                           url : '/v2/user/me',
                           success : function(response) {
                        	   
                               var email=response.kakao_account.email;
                               var name=response.kakao_account.profile.nickname;
                               console.log(response)
                               console.log('이메일:'+response.kakao_account.email);
                               console.log('닉네임:'+response.kakao_account.profile.nickname);
//                                location.href="login.do?amid="+email;

                               if(email!=null){
                                   var form=document.forms['login'];
                                   $('#id').val(email);
                                   $('#pw').val(name);
                                   form.action="kakaologin.do";
                                   form.submit();
                                }
                               
                           },
                           fail : function(error) {
                               console.log(error)
                           },
                       })
                   },

                fail: function(error) {
                    console.log(error);
                }
            });
        }
  

//카카오로그아웃  
function kakaoLogout() {
    if (Kakao.Auth.getAccessToken()) {
      Kakao.API.request({
        url: '/v1/user/unlink',
        success: function (response) {
           console.log(response)
        },
        fail: function (error) {
          console.log(error)
        },
      })
      Kakao.Auth.setAccessToken(undefined)
    }
  }  
</script>

<!-- sns 정보 삭제 -->
<script type="text/javascript">
   //   쿠키(Cookie) 삭제하기
//    var deleteCookie = function(name) {
//       document.cookie = name + '=; expires=Thu, 01 Jan 1999 00:00:10 GMT;';
//    }
   if(${logoutValue}==100){//네이버로그인했을 시 쿠키제거

      // deleteCookie(변수이름)
//          deleteCookie('nid_inf');
//          deleteCookie('NID_AUT');
//          deleteCookie('NID_SES');
//          deleteCookie('NID_JKL');
         
//           deleteCookie('nx_ssl');
//           deleteCookie('NNB');
//           deleteCookie('nid_slevel');
//           deleteCookie('ASID');
//           deleteCookie('nid_buk');
//          deleteCookie('JSESSIONID');
         
//       기타 사이트 데이터 제거
//       쿠키라는 쿠키는 다 삭제했지만 삭제가 안됐음
        window.localStorage.clear();
         ${logoutValue=99};
   }

   if(${logoutValue}==101){//카카오 로그인했을 시 쿠키제거
         kakaoLogout();
       ${logoutValue=99};
   }

</script>

</body>
</html>