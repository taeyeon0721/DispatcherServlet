<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>사방팔방 四方八方 | 관리자 모드</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap" rel="stylesheet"> 
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="libA/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="libA/tempusdominus/cssA/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="cssA/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="cssA/style.css" rel="stylesheet">
</head>

<body>
    <div class="container-fluid position-relative d-flex p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-dark position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->


        <!-- Sidebar Start -->
         <div class="sidebar pe-4 pb-3">
            <nav class="navbar bg-secondary navbar-dark">
                <a href="index.html" class="navbar-brand mx-4 mb-3" >
                    <h3 class="text-primary"><i class="fa fa-user-edit me-2" style="color:green"> Admin</i></h3>
                </a>
                <div class="d-flex align-items-center ms-4 mb-4">
                    <div class="position-relative">
                        <img class="rounded-circle" src="imgA/user.jpg" alt="" style="width: 40px; height: 40px;">
                        <div class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
                    </div>
                    <div class="ms-3">
                        <h6 class="mb-0">관리자</h6>
                        <span>Admin</span>
                    </div>
                </div>
                <div class="navbar-nav w-100">
                    <a href="admin.do?condition=member" class="nav-item nav-link"><i class="fa-solid fa-user"></i>&ensp;회원정보</a>
                    <a href="admin.do?condition=realtor" class="nav-item nav-link"><i class="fa-solid fa-user-tie"></i>&ensp;중개사정보</a>
                    <a href="admin.do?condition=estate" class="nav-item nav-link active"><i class="fa-solid fa-building"></i>&ensp;매물정보</a>
                    <hr>
                    <a href="logout.do" class="nav-item nav-link"><i class="fa-solid fa-home"></i>&ensp;관리자 모드 종료</a>
                </div>
            </nav>
        </div>
        <!-- Sidebar End -->


        <!-- Content Start -->
        <div class="content">

		
		<form id="rInfo" action="eDelete.do" method="post">
	 	<input type="hidden" name="epk" value="${epk}">
		</form>
              <!-- Table Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="row g-4">
                    
                    <div class="col-12">
                        <div class="bg-secondary rounded h-100 p-4">
                            <h6 class="mb-4">매물 목록</h6>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col">등록번호</th>
                                            <th scope="col">매물명</th>
                                            <th scope="col">가격</th>
                                            <th scope="col">종류</th>
                                            <th scope="col">주소</th>
                                            <th scope="col">삭제</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach var="v" items="${eDatas}">
                                    	<tr>
                                            <td>${v.epk}</td> <!-- 등록번호(pk) -->
                                            <td>${v.ename}</td>
                                            <td>${v.price}</td>
                                            <td>${v.category}</td>
                                            <td>${v.eaddress}</td>
                                            <td><a href="eDelete.do?epk=${v.epk}">삭제하기</a></td>  
                                <!--    <td><a href="controller.jsp?action=Edelete&epk=${v.epk}">삭제</a></td>  -->         
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Table End -->

            <!-- Footer Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-secondary rounded-top p-4">
                    <div class="row">
                        <div class="col-12 col-sm-6 text-center text-sm-start">
                            <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                           <!-- Designed By <a style="color:green" href="https://htmlcodex.com">HTML Codex</a> -->
                        </div>
                        <div class="col-12 col-sm-6 text-center text-sm-end">
                            &copy; <a style="color:green" href="#">사방팔방 四方八方</a>, All Right Reserved. 
                        </div>
                    </div>
                </div>
            </div>
            <!-- Footer End -->
        </div>
        <!-- Content End -->
  

        <!-- Back to Top -->
    
    </div>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/jsA/bootstrap.bundle.min.js"></script>
    <script src="libA/chart/chart.min.js"></script>
    <script src="libA/easing/easing.min.js"></script>
    <script src="libA/waypoints/waypoints.min.js"></script>
    <script src="libA/owlcarousel/owl.carousel.min.js"></script>
    <script src="libA/tempusdominus/js/moment.min.js"></script>
    <script src="libA/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="libA/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Template Javascript -->
    <script src="jsA/main.js"></script>
</body>

</html>