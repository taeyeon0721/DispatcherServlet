<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>작성 페이지</title>
</head>
<body>

<form action="/insert" method="post">
	작성자: <input type="text" name="writer" value="${dto.writer }"> <br>
	내용: <input type="text" name="writer" value="${dto.content }"> <br>
	<input type=submit value="글 작성하기">
</form>

</body>
</html>