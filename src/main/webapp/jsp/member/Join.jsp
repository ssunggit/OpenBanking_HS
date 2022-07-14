<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
		<form action="${ pageContext.request.contextPath }/joinProcess.do" method="post">
			id : <input type="text" name="id"/><br>
			password : <input type="password" name="password"/><br>
			name : <input type="text" name="name"/><br>
			birth : <input type="date" name="birth"/><br>
			tel : <input type="tel" name="tel"/><br>
			email : <input type="email" name="email"/><br>
			address : <input type="text" name="address"/>
			<input type="submit" value="회원가입"/>
		</form>
</body>
</html>