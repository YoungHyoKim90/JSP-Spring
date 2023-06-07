<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--
	response.setContentLength(10);
--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04/responseDesc.jsp</title>
</head>
<body>
<h4>HttpServletResponse</h4>
<pre>
	: 서버가 클라이언트로 전송하는 응답에 대한 모든 정보를 가진 객체.
	
	HTTP response packaging (Line, Header, Body)
	1. Response Line : 서버의 요청 처리 결과를 표현하는 상태코드(3자리 ; response status code)
		* response status code
		HTTP : connectLESS ***!remember it! *** , stateLESS 
		100~ : ing... ,  connectfull(의도적인 연결 수립/종료가 가능.), Websocket Protocol 에서 활용됨.
		200~ : OK(SUCCESS) code
		300~ : 최종적으로 요청 처리가 완료되려면, 클라이언트로 추가 액션이 필요함. 
			   response body 가 없음
			   304 : Not Modified -> 정적 자원의 cache 와 연관된 상태 코드.
			   302/307 : Moved -> Location 헤더를 통해 자원의 새로운 위치를 알려줌.
			   				   -> Location 방향으로 새로운 요청을 전송함. (redirect 이동 구조.)
		------실패 코드, 실패의 원인이 무엇이냐에 따라 나뉨.
		400~ : client side error ( 최대한 세부하게 나누는게 원칙.)		
			400 : Bad Request(요청 검증시 사용.)
			401/403	 : 보안 (인증 - authentication/인가-authorization) 
					   처리에 활용
					401(Unauthrorized)	: 미인증 사용자에 대해 사용(UnAuthenticated)
					403(Forbidden)		: 이미 인증된 사용자 이나, 특정 자원에 대한 접근 여부에 사용. 권한이 없는 사용자의 접근을 막을 때 사용.
					*Forbidden - 금지. 권한이 없는 자원에 대한 접근을 막을때 사용.
			404 : Not Found
			405 : Method Not Allowed
			406/415	: 전송 컨텐츠 타입과 연관된 상태코드
				406 : Not Acceptable -> request Accept 헤더와 연관됨.
									 -> 서버가 클라이언트의 요청 컨텐츠 타입을 처리할 수 없음.
				415 : Unsupported Media type
									 -> requst content-type헤더와 연관됨.
									 -> 서버가 읽을 수 없는 형태의 컨텐츠가 전송되었을때.
									 
					
			<%
			
// 				HttpServletResponse.sc_not
			
			%>
			
		500~ : server side error
			500 : Internal Server Error (검증 및 ㄴ보안적인 목적으로 많이 사용.)
		
	2. Response Header : response body의 메타데이터, name/value
		* Content-* (Content-Type, Content-Length)
		* Cache-*
		* auto request
		* redirect Location
		
	3. Response Body(content Body, Message body)
		1) JSP 의 정적 텍스트
		2) JSP Writer out 객체 이용
		3) PrintWriter response.getWriter() 객체 이용.
		4) ServletOuputStream response.getWriter() 객체 이용.
	
	 	==> response body 데이터를 직렬화.
	<%--
		out.println("text");
		response.getWriter().println("text");
		response.getOutputStream().write(4);
	--%>
	
</pre>

</body>
</html>