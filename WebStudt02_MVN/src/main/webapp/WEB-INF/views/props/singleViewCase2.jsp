<%@page import="kr.or.ddit.vo.PropertyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form id="insertForm" method="post">
	<input type="text" name="propertyName" />
	<input type="text" name="propertyValue" />
	<input type="text" name="description" />
	<input type="submit" value="등록" />
</form>

<table>
	<thead>
		<tr>
			<th>프로퍼티이름</th>
			<th>프로퍼티값</th>
			<th>설명</th>
		</tr>
	</thead>
	<tbody id="listBody">
	</tbody>
</table>

<script src="<%=request.getContextPath() %>/resources/js/app/props/property.js"></script>






















