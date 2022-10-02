<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style type="text/css">
   *{
      margin: 5px;
      padding: 5px;
      text-align: center;
   }
   #map{
      width: auto;
      height: 200px;
      border: 2px #202322;               /*구글 맵 api를 띄울 수 있는 공간을 생성한다.*/
   }     
   #sampleEstate {
   	  width: auto;
      height: 450px;
   }                      
</style>
<title>사방팔방 四方八方 | 분양정보</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="crossorigin="anonymous"></script>
<script src="http://maps.google.com/maps/api/js?key=AIzaSyDNp-zYCyvcbrN7Y3_hMRhjShp0p7bqLvY&region=kr"></script>

<body bgcolor="#202322">
<h1 style="color:white">분양 정보</h1>
<div>
	<img id="sampleEstate" alt="popup-sample" src="images/sampleEstate.png">
</div>
<div>
	
</div>

<div id="map"></div>


<button id="unshow"> 다시 보지 않기 </button>


<script type="text/javascript">
   var map;
   function initMap(){
      var ll={lat:37.500600,lng:127.036268};      /*위도 경도 좌표를 입력하는 코드*/
      map=new google.maps.Map(
            document.getElementById("map"),
            {zoom:17,center:ll} /*zoom은 지도 확대 정도이다 숫자가 클수록 위치를 확대해서 지도를 보여준다 center는 말그대로 지도보여질 중심을 정하는 코드*/
         );
      new google.maps.Marker(   /* 입력한 위치에 마커를 생성한다*/
            {position:ll,map:map,label:"마커-내 현재위치"}
         );
   }
   initMap();
   
   $("#unshow").on("click",function(){ //unshow: 다시보지않기
   	console.log("click");
       $.ajax({
           url : '${pageContext.request.contextPath}/unshow.pop',
           type : 'POST',
           success : function(result){
              console.log("데이터 변환됨"+result);
              if(result==1){
           	   alert("성공");
               }
              else {
            	alert("실패");
               }
           }
        });
       
       window.close();
   });
  
</script>












</body>
</html>