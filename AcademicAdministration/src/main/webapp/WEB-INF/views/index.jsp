<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>    
<h4>웰컴페이지</h4>
${sessionScope }

<div style="border: 1px solid black;">
	<security:authentication property="principal.realUser" var="authMember"/>
	${authMember.memName }
</div>
