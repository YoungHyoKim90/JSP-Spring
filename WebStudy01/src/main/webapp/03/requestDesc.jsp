<%@page import="java.text.MessageFormat"%>
<%@page import="java.util.Enumeration"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03/requestDesc.jsp</title>
</head>
<body>

<form action ="dataProcess.do" method="post" enctype="multipart/form-data">
	<input type = "text" name ="param1" />
	<input type = "text" name ="param2" />
	<input type = "submit" value = "전송" />
</form>

<h4>Http Request Packaging(HttpServletRequest)</h4>

HTTP외에도***FTP, SMTP가 있다.


<pre>

	1. Request Line : protocol/version(HTTP/1.1) URL, Request Method
		
		<%=request.getProtocol() %>
		<%=request.getRequestURI() %>
		<%=request.getMethod() %>
		
		* Request Method :  어떤 목적, 어떤 규칙이 있는지?
							현재 요청의 의도(목적)과 패키징 구조를 표현
							1) GET(default), R	: Read가 목적.
							2) POST, C	: Write
							3) PUT(전체수정)/PATCH(선택수정), U : Update
							4) DELETE, D 	
							***next service!! CRUD!!	
							5) OPTIONS : preFlight 요청에 사용됨
							6) HEAD : response Body 가 없는 응답을 요청함(잘받았는지 확인만 하면되서...)
							7) TRACE : server debugging 요청. (관리목적의 콘솔에서만 실행됨.)	
									
	2. Request Header : meta data(현재 클라이언트와 요청에 대한 부가 정보)
	
	<%= request.getHeader("accept") %>
	
		Accept-* : 응답에 대한 조건을 설정.
		ex) Accept : application/json => ajax에서 json을 사용하면~ , Accept-Language : ko_KR
		Content-* : request body에 대한 부가정보
		ex) Content-Type : multipart/ form-data, application/json
		User-Agent : 클라이언트가 사용하는 시스템과 브라우저에 대한 정보.
		
		
	3. Request Body(Content Body, Message Body) : send data(content)그 자체.
		1) 요청 파라미터의 형태
		2) multipart
		3) payload

</pre>

<table>
	<thead>
		<tr>
			<th>헤더이름</th>
			<th>헤더값</th>
		</tr>
	</thead>
	
	<tbody>
	<% 
		StringBuilder html = new StringBuilder();
		String pattern= "<tr>{0}<td></td><td>{1}</td><tr>\n";
		Enumeration<String> names = request.getHeaderNames();
		
		while(names.hasMoreElements()){
			String headerName = names.nextElement();
			String headerValue = request.getHeader(headerName);
			html.append(
			MessageFormat.format(pattern, headerName,headerValue)
			);
			
		}
		out.println(html);
	%>
	</tbody>
</table>

<img alt="" src="<%= request.getContextPath() %>/resources/images/cute1.PNG">

</body>
</html>