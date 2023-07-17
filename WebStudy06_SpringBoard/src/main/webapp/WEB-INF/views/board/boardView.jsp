<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<table class="table table-bordered">
	<tr>
		<th><spring:message code="freeboard.boNo" /></th>
		<td>${freeboard.boNo }</td>
	</tr>
	<tr>
		<th><spring:message code="freeboard.boTitle" /></th>
		<td>${freeboard.boTitle }</td>
	</tr>
	<tr>
		<th><spring:message code="freeboard.boWriter" /></th>
		<td>${freeboard.boWriter }</td>
	</tr>
	<tr>
		<th><spring:message code="freeboard.boIp" /></th>
		<td>${freeboard.boIp }</td>
	</tr>
	<tr>
		<th><spring:message code="freeboard.boMail" /></th>
		<td>${freeboard.boMail }</td>
	</tr>
	<tr>
		<th><spring:message code="freeboard.boPass" /></th>
		<td>${freeboard.boPass }</td>
	</tr>
	<tr>
		<th><spring:message code="freeboard.boContent" /></th>
		<td>${freeboard.boContent }</td>
	</tr>
	<tr>
		<th><spring:message code="freeboard.boDate" /></th>
		<td>${freeboard.boDate }</td>
	</tr>
	<tr>
		<th><spring:message code="freeboard.boHit" /></th>
		<td>${freeboard.boHit }</td>
	</tr>
</table>