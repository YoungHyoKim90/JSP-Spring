<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<table class="table table-bordered">
	<thead class="table-light">
		<tr>
			<th><spring:message code="rnum"/></th>
			<th><spring:message code="freeboard.boTitle"/></th>
			<th><spring:message code="freeboard.boWriter"/></th>
			<th><spring:message code="freeboard.boDate"/></th>
			<th><spring:message code="freeboard.boHit"/></th>
		</tr>
	</thead>
	<tbody>
		<c:set var="boardList" value="${paging.dataList }" />
		<c:choose>
			<c:when test="${empty boardList }">
				<tr>
					<td colspan="5">조건에 맞는 게시글 없음.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${boardList }" var="board">
					<tr>
						<td>${board.rnum }</td>
						<td>${board.boTitle }</td>
						<td>${board.boWriter }</td>
						<td>${board.boDate }</td>
						<td>${board.boHit }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="5">
				${paging.pagingHTML }
			</td>
		</tr>
	</tfoot>
</table>




















