<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.error{
		color: red;
	}
</style>
</head>
<body>
<div class="error">
	<%=session.getAttribute("message") %>, ${message }
	<%
		// flash attribute 방식
		session.removeAttribute("message");
	%>
</div>
<form action="<%=request.getContextPath() %>/login/loginProcess" method="post">
	<ul>
		<li>
			아이디 : <input type="text" name="memId" />
			<input type="checkbox" name="idSave" />아이디저장
		</li>
		<li>
			비밀번호 : <input type="text" name="memPass" />
		</li>
		<li>
			<button type="submit">로그인</button>
		</li>
	</ul>
</form>
</body>
</html>














