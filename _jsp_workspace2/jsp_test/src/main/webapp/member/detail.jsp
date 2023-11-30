<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/memb/modify" method="post">
		ID : <input type="text" name="id" value="${ses.id }" readonly="readonly"> <br>
		PW : <input type="text" name="pwd" placeholder="${ses.pwd }"> <br>
		Email : <input type="text" name="email" placeholder="${ses.email }"> <br>
		Age : <input type="text" name="age" placeholder="${ses.age }"> <br>
		<button type="submit">수정</button>
	</form>
	<a href="/memb/remove"><button>삭제</button></a>
	<a href="/index.jsp"><button>홈</button></a>
</body>
</html>