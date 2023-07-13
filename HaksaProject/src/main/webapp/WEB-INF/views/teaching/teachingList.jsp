<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table table-border">
	<thead>
		<tr>
			<th>과목명</th>
			<th>학점</th>
			<th>강의시간</th>
			<th>강의실</th>
			<th>담당교수</th>
			<th>학과코드</th>
		</tr>
	</thead>
	<tbody>
	<c:if test="${empty teachingList }">
	<tr>
		<td>강의정보가 존재하지 않습니다.</td>
	</tr>
	</c:if>
	<c:if test="${not empty teachingList }">
		<c:forEach items="${teachingList }" var="teaching">
			<c:url value="/learning/learningList.do" var="viewURL">
				<c:param name="subCd" value="${teaching.subCd }"/>
			</c:url>
			<tr>
				<td><a href="${viewURL }">${teaching.subject.subName }</a></td>
				<td>${teaching.subject.subPoint }</td>
				<td>${teaching.teaTime }</td>
				<td>${teaching.teaRoom }</td>
				<td>${teaching.professor.proName }</td>
				<td>${teaching.professor.proDept }</td>
			</tr>
		</c:forEach>
	</c:if>
	</tbody>
</table>