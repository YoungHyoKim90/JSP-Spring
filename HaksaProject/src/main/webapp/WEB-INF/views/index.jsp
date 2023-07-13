<%@page import="kr.or.ddit.vo.ProfessorVO"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h4>${welcomeMessage}</h4>
<%
	ProfessorVO authMember = (ProfessorVO) session.getAttribute("authMember");
	if (authMember != null) {
		%>
		<h4><%=authMember.getProName() %>님 로그인 성공</h4>
		<a href="javascript:;" onclick="logoutForm.requestSubmit()">로그아웃</a>
		<% 
	} else {
		%>
		<a href="<%=request.getContextPath() %>/login/loginForm.jsp">로그인</a>
		<%		
	}
%>