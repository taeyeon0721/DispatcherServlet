<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�ۼ� ������</title>
</head>
<body>

<form action="/insert" method="post">
	�ۼ���: <input type="text" name="writer" value="${dto.writer }"> <br>
	����: <input type="text" name="writer" value="${dto.content }"> <br>
	<input type=submit value="�� �ۼ��ϱ�">
</form>

</body>
</html>