<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>08/scopeDesc.jsp</title>
</head>
<body>
<h4>Scope(4) : (속성-attribute 저장 영역)</h4>
<pre>
	: 생명주기가 다른 기본 객체가 관리하는 메모리 공간 -> 상황에 따라 설정.
	*** 메모리 형태 (큐,스택,맵 등 7가지 ) ->scope는 map구조이다.
	pageContext(pageScope) : 하나의 JSP 페이지와 생명주기 동일 =>JSP한개(서버의 기준으로 본다.)
	request(requestScope) : Http stateless 특성에 따라 하나의 요청과 동일한 생명주기 
	session(sessionScope) : 한 세션과 동일한 생명주기 
	application(applicationScope) : 하나의 컨텍스트와 동일한 생명주기
	
	setAttribute(String name, Object value)
	Object getAttribute(String name)
	removeAttribute(String name)
	
	<%
		pageContext.setAttribute("pageAttr", "페이지 속성");
		request.setAttribute("requestAttr", "요청 속성");
		session.setAttribute("sessionAttr", "세션 속성");
		application.setAttribute("applicationAttr", "어플리케이션 속성");
		
// 		RequestDispatcher rd = request.getRequestDispatcher("/08/attrView.jsp"); ->3개 살아남음
// 		rd.include(request, response); ->3개 살아남음

		response.sendRedirect(request.getContextPath() + "/08/attrView.jsp");
//			-> 2개 살아남음.클라이언트는 B의 존재를 암.
//			-> 쿠키와 세션은 Http의 상태를 저장하지 않는 특성을 보완하기 위해 나온 것이다.  상태를 유지하기 위한 저장을 하기위해
//			세션은 서버에 저장, 쿠키는 클라이언트의 PC에 저장. 
	%>
	<a href="attrView.jsp">속성 확인하기</a>
</pre>
</body>
</html>




















