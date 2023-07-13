<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.util.stream.Stream"%>
<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
	String saveId = Optional.ofNullable(request.getCookies())
			.map(ca -> 
				Stream.of(ca)
					  .filter((c) -> "idCookie".equals(c.getName()))
					  .findFirst()
					  .map(Cookie::getValue)
					  .orElse(null)
			 ).orElse(null);
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.error {
		color: red;
	}
</style>
</head>
<body>
<c:if test="${not empty message }">
	<div class="error">
		${message }
		<c:remove var="message" scope="session"/>
		<%--
			// flash attribute 방식
			session.removeAttribute("message");
		--%>
	</div>
</c:if>
<form action="${pageContext.request.contextPath }/login/loginProcess" method="post">
	<ul>
		<li>
			부서코드 : <input type="text" name="proDept" value="${cookie.idCookie.value }" />
			<input type="checkbox" name="deptSave" ${not empty cookie.idCookie ? "checked" : ""} />부서저장
		</li>
		<li>
			교수코드 : <input type="text" name="proCd" />
		</li>
		<li>
			<button type="submit">접속</button>			
		</li>
	</ul>
</form>
</body>
</html>