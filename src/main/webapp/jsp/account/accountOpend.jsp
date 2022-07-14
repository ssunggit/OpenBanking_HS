<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌개설</title>
</head>
<body>

계좌 개설
<br>
<form action="${ pageContext.request.contextPath }/accountOpendProcess.do" method="post">
	비밀번호 <input type="password" name="accountPW"> <br>
	비밀번호확인 <br>
	잔액 <input type="number" name="balance"> <br>
	별칭 <input type="text" name="accountAlias">
	
	<input type="submit" value="계좌개설">
</form>


</body>
</html>