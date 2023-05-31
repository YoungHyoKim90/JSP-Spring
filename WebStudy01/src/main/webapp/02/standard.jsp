<%@page import="java.text.MessageFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02/standard.jsp</title>
</head>
<body>
<%-- <h4><%= MessageFormat.format("현재실행중인 쓰레드명 : {0}", tread) %></h4> --%> 
<h4>JSP(Java Server Page)</h4>

<pre>
	: 서블릿의 파생 스펙으로 템플릿(거푸짚:틀) 엔진의 형태로 동작하는 스크립트 언어(따로 번역할 필요가 없다. ->바로 사용가능:톰캣)
	
	JSP container(WAS,Tomcat)
	: jsp 템플릿을 해석하고 (파싱한다.), 서블릿 소스를 생성하고, 컴파일을 하고, 
		하나의 요청이 들어오면, 싱글턴 객체로 동작할 수 있는 인스턴스를 생성하고,
		하나의 쓰레드를 분리하고, 필요한 콜백 메소드(_jspService) 호출.
		
	소스의 구성요소
	1. 정적 텍스트	 : HTML, JS , CSS, 일반 텍스트, foreground module로 동작 ->순수한 문자로 구성된, 한번 정하면 바뀌지 않는 내용들.
	2. 스크립트 요소 : background module로 동작, 
	 
	 :지시자. 실제코드에는 영향을 주지않는 메타데이타를 설정 : 현재 JSP페이지에 대한 설정정보. 
			page (required 필수)	: jsp 페이지에 대한 메타 정보 (contentType, import..)
			include(optional 선택) : 정적 내포
			taglib(optional 선택)  : 커스텀 태그를 로딩함. 
	 		이걸모두 스크립트 요소라고 한다.		
		1) 지시자 directive 
		&lt;%@ 지시자명 속성명 = "속성값" %&gt;
		2) 스크립트 scriptlet
		
	- scriptlet(스크립트) : <% // java code -> _jspService 메소드의 지역 코드화가 된다. %>
	<%
		String sample = "SAMPLE";
	%>
	4가지 변수의 정적, 블록, 인스턴스, 지역 변수의 형태가 있다. 
		
		3) 표현식 expression : <%=sample %> 위의 sample이 출력됨. , <%=this.sample %> 밑의 인스턴스 sample이 출력됨.
							,<%=testMtd() %> 
							출력하고 싶은 변수, 키워드 등이 들어감
		
		
		
		4) 선언부 declartion : <%! %>
		
		<%!
			String sample = "INSTANCE SAMPLE";
			private String testMtd(){
				
				return "TEST Method";
						
			}
		%>
		
		5) 주석 comment : <%-- 주석주석 --%>
						 <% %>
						1. foreground commet 	: html, js, css
						
						<!-- html coment text/plain에서는 보임-->
						
						2. background comment 	: java, jsp 주석은 개발자들끼리의 대화 이므로, 사용자에게 알려주면 안된다.(보안 등)
						<%-- jsp coment --%>
						 
	3. 스크립트 요소 내에서 사용되는 기본 객체(8)
	4. EL(표현언어)
	5. JSTL(표준 태그 라이브러리)
	***1을 정하고 2~5를 어떻게 사용해서 JSP를 구성할 것인가?
	

	
</pre>

</body>
</html>