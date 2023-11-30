<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<form action="/brd/insert" method="post">
		작성자 : <input type="text" name="writer" value="${ses.id }" readonly="readonly"> <br>
		제목 : <input type="text" name="title"> <br>
		내용 : <textarea rows="10" cols="30" name="content"></textarea> <br>
		<button type="submit">전송</button>
	</form>
	<a href="/index.jsp"><button>홈</button></a>
</body>
</html>