<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03/requestDesc.jsp</title>
</head>
<body>
<h4>Http Request Packaging</h4>

HTTP외에도***FTP, SMTP가 있다.

<pre>
	1. Request Line : protocol/version(HTTP/1.1) URL, Request Method
		* Request Method :  어떤 목적, 어떤 규칙이 있는지?
							현재 요청의 의도(목적)과 패키징 구조를 표현
							1) GET(default), R	: Read가 목적.
							2) POST, C	: Write
							3) PUT(전체수정)/PATCH(선택수정), U : Update
							4) DELETE, D 							
	2. Request Header
	3. Request Body(Content Body, Message Body)


</pre>
<img alt="" src="<%= request.getContextPath() %>/resources/images/cute1.PNG">

</body>
</html>