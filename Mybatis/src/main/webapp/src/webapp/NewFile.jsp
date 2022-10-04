<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<button onclick="requestPay()">결제하기</button>


<script type="text/javascript">
function requestPay() {
	  IMP.init("{imp00314251}"); //관리자 페이지 내 "가맹점 식별코드" & 결제시스템을 실행시키는 함수
	  IMP.request_pay({
	    pg: "inicis", //원하는 pg사
	    pay_method: "card", //결제수단
	    merchant_uid : 'merchant_'+new Date().getTime()  // 가맹점에서 생성,관리하는 고유 주문번호
	    name : '결제테스트', //주문명
	    amount : 14000,
	    buyer_email : 'iamport@siot.do',
	    buyer_name : '구매자',
	    buyer_tel : '010-7130-7075',
	    buyer_addr : '서울특별시 강남구 삼성동',
	    buyer_postcode : '123-456',
//	    m_redirect_url : 'NewFile.jsp'	 //'{모바일에서 결제 완료 후 리디렉션 될 URL}'  	  
	  }, function (rsp) {//callback 로직: 결제창에서 결제 후 호출되는 함수
		    console.log(rsp);
		    if (rsp.success) {
		      var msg = '결제가 완료되었습니다.';
				msg += '고유ID : ' + rsp.imp_uid;
				msg += '상점 거래ID : ' + rsp.merchant_uid;
				msg += '결제 금액 : ' + rsp.paid_amount;
				msg += '카드 승인번호 : ' + rsp.apply_num;
		    } else {
		      var msg = '결제에 실패하였습니다.';
		      msg += '에러내용 : ' + rsp.error_msg;
		    }
		  });
	  
	  
}
</script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
</body>
</html>