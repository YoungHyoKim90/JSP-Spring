<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<MemberVO> memberList = (List) request.getAttribute("memberList");
%>    
<table class="table table-border">
	<thead>
		<tr>
			<th>회원아이디</th>
			<th>회원명</th>
			<th>휴대폰</th>
			<th>이메일</th>
			<th>생일</th>
			<th>거주지역(add1)</th>
			<th>마일리지</th>
		</tr>
	</thead>
	<tbody>
	<% 
		if(memberList.isEmpty()){
			%>
			<tr>
				<td colspan="7">등록된 회원 없음.</td>
			</tr>
			<%
		}else{
			for(MemberVO member : memberList){
				%>
				<tr>
					<td><%=member.getMemId() %></td>
					<td><%=member.getMemName() %></td>
					<td><%=member.getMemHp() %></td>
					<td><%=member.getMemMail() %></td>
					<td><%=member.getMemBir() %></td>
					<td><%=member.getMemAdd1() %></td>
					<td><%=member.getMemMileage() %></td>
				</tr>
				<%
			}
		}
	%>
	</tbody>
</table>































