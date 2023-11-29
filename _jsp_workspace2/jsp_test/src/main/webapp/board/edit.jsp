<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/brd/modify" method="post">
		<input type="text" name="bno" value="${bvo.bno}" hidden="true">
		제목 : <input type="text" name="title" value="${bvo.title }"> <br>
		내용 : <textarea rows="10" cols="30" name="content">${bvo.content }</textarea> <br>
		<button type="submit">수정</button>
		<a href="/index.jsp"><button>홈</button></a>
	</form>
</body>
</html>