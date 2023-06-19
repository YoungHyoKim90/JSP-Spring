<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>08/implicitObject.jsp</title>
</head>
<body>
<h4>기본 객체 (내장 객체)</h4>

<pre>

	
		: 개발자가 선언하거나 생성하지 않고, 컨텍스트에서 기본적으로 제공되는 개체.
		request(HttpServletRequest)
		response(HttpServletResponse)
		out(JspWriter)
		session(HttpSession) : <a href=" sessionDesc.jsp"/>
		application(ServletContext)
		
		config(ServletConfig)
		page(Object) : this, jsp 스펙에 따라 컨테이너가 생성한 싱글턴 인스턴의의참조.
		exception : 에러 처리 목적의 페이지에서 잘생한 예외나 에러에 대한 정보를 가진 객체 
		
		*** pageContext 나머지 모든 객체를 가지고 있음.***
		-> 가장 먼저 생성되는 기본객체로, JSP페이지에 대한 모든 정보를 가진 객체이다.
		--> 나머지 기본 객체들에 대한 참조를 소유한다.
		${pageContext}
	<%-- el이라고 한다. --%>
	
</pre>

</body>
</html>