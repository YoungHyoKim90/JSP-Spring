<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h4><%=(String)request.getAttribute("welcomeMessage") %></h4>
<h4>${welcomeMessage }</h4>
<%
	String authId = (String) session.getAttribute("authId");
	if(StringUtils.isNotBlank(authId)){
		%>
		<h4><%=session.getAttribute("authId") %>님 로그인 성공</h4>
		<form id="logoutForm" method="post" action="<%=request.getContextPath() %>/login/logout"></form>
		<a href="javascript:;" onclick="logoutForm.requestSubmit()">로그아웃</a>
		<%
	}else{
		%>
		<a href="<%=request.getContextPath() %>/login/loginForm.jsp">로그인</a>
		<%
	}
%>
