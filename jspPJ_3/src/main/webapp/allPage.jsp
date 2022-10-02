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
</head>
<body>

  <t:header/>

   <div class="hero page-inner overlay"
      style="background-image: url('images/hero_bg_1.jpg');">

      <div class="container">
         <div class="row justify-content-center align-items-center">
            <div class="col-lg-9 text-center mt-5">
               <h1 class="heading" data-aos="fade-up">전체 매물 보기</h1>

               <nav aria-label="breadcrumb" data-aos="fade-up"
                  data-aos-delay="200">
                  <ol class="breadcrumb text-center justify-content-center">
                     <li class="breadcrumb-item "><a href="#bestitem">추천 매물</a></li>
                     <li class="breadcrumb-item "><a href="#allitem">전체 매물 보기</a></li>
                  </ol>
               </nav>
            </div>
         </div>
      </div>
   </div>


   <div class="section">
      <div class="container">
         <div class="row mb-5 align-items-center">
            <div class="col-lg-6 text-center mx-auto">
               <h2 id="bestitem" class="font-weight-bold text-primary heading">추천 매물</h2>
                  <div class="col-lg-6 text-lg-end">
               <p><a></a></p>
            </div>
                  
            </div>
            

         </div>
         <div class="row">

            <div class="col-12">
               <div class="property-slider-wrap">
                  <div class="property-slider">

			
					<c:forEach var="e" items="${eDatas2}">
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
                     </div>
                     <!-- .item -->
					</c:forEach>

                  </div>


                  <div id="property-nav" class="controls" tabindex="0"
                     aria-label="Carousel Navigation">
                     <span class="prev" data-controls="prev" aria-controls="property"
                        tabindex="-1">이전</span> <span class="next"
                        data-controls="next" aria-controls="property" tabindex="-1">다음</span>
                  </div>

               </div>
            </div>

         </div>
      </div>
   </div>


   <div class="section section-properties">
      <div class="container">
         <div class="row mb-5 align-items-center">
            <div class="col-lg-6 text-center mx-auto">
               <h2 id="allitem" class="font-weight-bold text-primary heading">전체 매물</h2>
            </div>

         </div>
         <div class="row">
         			<c:if test="${eDatas.size() == 0}">
						<h3 style="text-align: center;"> 검색결과가 없습니다 </h3>
					</c:if>
					
		<c:forEach var="e" items="${eDatas}">
            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-4">
               <div class="property-item mb-30">
               
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
               </div>
               <!-- .item -->
            </div>
		</c:forEach>
		
		<c:if test="${size>cnt}"> <!-- cnt값이 게시글 사이즈보다 작아야지만 더보기가 보임 -->
			<a href="eMain.do?cnt=${cnt+3}&searchContent=${searchContent}&searchCondition=${searchCondition}" class="btn btn-primary py-2 px-3">더보기</a>
		</c:if> 
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