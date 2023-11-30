<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>bno</th>
			<th>title</th>
			<th>writer</th>
			<th>regdate</th>
			<th>readcount</th>
		</tr>
		
		<c:forEach items="${list }" var="bvo">
			<tr>
				<td><a href="/brd/moveBoard?bno=${bvo.bno }">${bvo.bno}</a></td>
				<td><a href="/brd/moveBoard?bno=${bvo.bno }">${bvo.title}</a></td>
				<td>${bvo.writer }</td>
				<td>${bvo.regdate }</td>
				<td>${bvo.readCount }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/index.jsp"><button>홈</button></a>
</body>
</html>