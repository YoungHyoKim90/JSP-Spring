<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.util.stream.Stream"%>
<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String savedId = Optional.ofNullable(request.getCookies())
					 		 .map(ca->
					 			Stream.of(ca)
					 				  .filter(c->"idCookie".equals(c.getName()))
					 				  .findFirst()
					 				  .map(Cookie::getValue)
					 				  .orElse(null)
					 		).orElse(null);
%>    
    
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
			아이디 : <input type="text" name="memId" value="<%=savedId %>"/>
			<input type="checkbox" name="idSave" <%=StringUtils.isNotBlank(savedId)? "checked" : "" %>"/>아이디저장
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














