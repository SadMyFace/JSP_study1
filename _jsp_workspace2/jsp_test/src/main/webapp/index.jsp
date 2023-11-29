<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello</h1>
	<form action="memb/login">
		ID : <input type="text" name="id"> <br>
		PW : <input type="text" name="pwd"> <br>
		<button type="submit">login</button>
	</form>
	<div>
		<c:if test="${ses.id ne null }">
			<p>${ses.id }님이 로그인하셨습니다.</p>
			<p>마지막 로그인: ${ses.lastlogin }</p>
			<a href="/memb/logout"><button>로그아웃</button></a>
		</c:if>	
	</div>
	<br>
	<hr>

	<a href="/brd/register"><button>글쓰기</button></a>
	<a href="/brd/list"><button>글목록 보기</button></a>
</body>
</html>