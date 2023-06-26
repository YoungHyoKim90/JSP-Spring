<%@page import="kr.or.ddit.db.ConnectionFactory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.PropertyVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>JDBC(Java DataBase Connectivity)</h4>
<pre>
	jdbc 단계
	
	1. driver 를 빌드패스에 추가
	2. 드라이버 로딩 (드라이버 클래스 로딩)
	3. Connection(connectFull 방식) 수립
	4. Statement(쿼리) 객체 생성
		- Statement
		- PreparedStatement
		- CallableStatement
	5. SQL 쿼리 실행
		- SELECT : ResultSet executeQuery
		- INSERT/UPDATE/DELETE : int executeUpdate	
	6. ResultSet 으로부터 결과 핸들링
	7. release 단계 (ResultSet -> Statement -> Connection)
	<%
		// Factory Object[Method] Patterh
		
		List<PropertyVO> propList = new ArrayList<>();
		try(
			Connection conn = ConnectionFactory.getConnection();
			Statement stmt = conn.createStatement();
		){
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT PROPERTY_NAME, PROPERTY_VALUE  ");
			sql.append(" FROM DATABASE_PROPERTIES                           ");
			ResultSet rs = stmt.executeQuery(sql.toString());
			while(rs.next()){
// 				entity(attribute) -> java object(property)
				PropertyVO prop = new PropertyVO();
				propList.add(prop);
				prop.setPropertyName(rs.getString("PROPERTY_NAME"));
				prop.setPropertyValue(rs.getString("PROPERTY_VALUE"));
			}
			rs.close();
		}
		
	%>
</pre>
<table>
	<thead>
		<tr>
			<th>프로퍼티 명</th>
			<th>프로퍼티 값</th>
		</tr>
	</thead>
	<tbody>
		<%
			if(propList.isEmpty()){
				%>
				<tr>
					<td colspan="2">프로퍼티 없음.</td>
				</tr>
				<%
			}else{
				for(PropertyVO prop : propList){
					%>
					<tr>
						<td><%=prop.getPropertyName() %></td>
						<td><%=prop.getPropertyValue() %></td>
					</tr>
					<%
				}
			}
		%>
	</tbody>
</table>
</body>
</html>


































