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
	<form action="memb/login" method="post">
		ID : <input type="text" name="id"> <br>
		PW : <input type="text" name="pwd"> <br>
		<button type="submit">login</button>
	</form>
	<div>
		<c:if test="${ses.id ne null }">
			${ses.id }님이 로그인하셨습니다. <br>
			계정 생성일 : ${ses.regdate } <br>
			마지막 로그인: ${ses.lastlogin } <br>
			<a href="/memb/logout"><button>로그아웃</button></a>
			<a href="/memb/detail"><button>회원정보 수정</button></a>
			<a href="/memb/list"><button>회원정보 리스트</button></a>
			<a href="/brd/myBoard"><button>내가 쓴글</button></a>
		</c:if>	
	</div>
	<br>
	<hr>
	
	<a href="/memb/join"><button>회원가입</button></a>
	<a href="/brd/register"><button>글쓰기</button></a>
	<a href="/brd/list"><button>글목록 보기</button></a>
	<script type="text/javascript">
		const msg_login = `<c:out value="${msg_login}" />`;
		console.log(msg_login);
		
		if(msg_login == '1'){
			alert("로그인하셨습니다.");
		}else if(msg_login == '-1'){
			alert("아이디 또는 비밀번호가 다릅니다.");
		}
		
		const msg_logout = `<c:out value="${msg_logout}" />`;
		console.log(msg_logout);
		
		if(msg_logout == '1'){
			alert("로그아웃 하셨습니다.");
		}
		
		const msg_modify = `<c:out value="${modifySuccess}" />`;
		console.log(msg_modify);
		
		if(msg_modify == '1'){
			alert("수정");
		}
		
		const msg_remove = `<c:out value="${removeSuccess}" />`;
		console.log(msg_remove);
		
		if(msg_remove == '1'){
			alert("삭제");
		}
	</script>
</body>
</html>