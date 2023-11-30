<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/memb/register">
		ID : <input type="text" name="id"> <br>
		PW : <input type="text" name="pwd"> <br>
		Email : <input type="text" name="email"> <br>
		Age : <input type="text" name="age"> <br>
		<button type="submit">가입</button>
	</form>
	<a href="/index.jsp"><button>홈</button></a>
</body>
</html>