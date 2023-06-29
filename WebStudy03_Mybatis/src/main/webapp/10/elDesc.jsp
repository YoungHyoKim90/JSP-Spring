<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>10/elDesc.jsp</title>
</head>
<body>
<h4 id="titleElement" data-name="H4VALUE">EL(Expression Language)</h4>
<pre>
	: 속성 데이터 출력을 목적으로 하는 스크립트 형태 언어.
	
	1. EL 연산자
		1) 산술연산자 : + - * / %
			${4 / 3 }
			${"4" + "3" }, ${"4"+3 }, ${a+b }
			&nbsp;, &lt;
		2) 논리연산자 : && (and), || (or), ! (not)	
			${true and false }, ${true or false }, ${not true }
		3) 비교연산자 : == (eq), != (ne), > (gt), >= (ge), < (lt), <= (le)
			${4 ge 3 }, ${"4" eq 4 }
		4) 삼항연산자 조건식 ? 참표현 : 거짓표현
			${4 ge 3 ? "크다":"작다" }	
		5)*** 단항연산자 : empty(비어있는지 여부 확인)
				속성의 존재여부 -> null 여부 -> size(length)
			${empty asdf }
	2. EL 객체의 멤버에 대한 접근법 : 점표기방식(dot notation), 연상배열방식
			속성명.멤버명, 속성명['멤버명']
	3. EL 기본객체 
		1) scope : pageScope, requestScope, sessionScope, applicationScope
		2) param : 요청 파라미터를 가진 객체
			${param.param1 }
		3) paramValues : 요청 파라미터를 가진 객체
			${paramValues['param1'][0] }
		4) cookie : 쿠키 객체들을 가진 객체
			${cookie.idCookie.value }
			${cookie['idCookie']['value'] }	
			${cookie['idCookie'].value }
		5) pageContext : 
			${pageContext.session.id }
			${cookie['JSESSIONID']['value'] }
			${pageContext.request.contextPath }, <%=request.getContextPath() %>		
	
	<%--=변수명, 값, 연산식 --%>, 
	<%-- 	${속성명, 값, 연산식 } --%>
	<%
		String tmp = "TEXT";
		request.setAttribute("tmp-2", "요청");
		session.setAttribute("tmp-2", "세션");
		Map<String, Object> attrMap = new HashMap<>();
		attrMap.put("key1", "value1");
		attrMap.put("key-2", "value2");
		attrMap.put("key4", new ArrayList());
		request.setAttribute("attrMap", attrMap);
	%>
	표현식 : <%=tmp %>, 
	EL : ${tmp2 }, ${tmp }
		${requestScope['tmp-2'] }
		${sessionScope.tmp-2 }
		${attrMap.key1 }
		${attrMap['key-2'] }
		${empty attrMap.key4 }
</pre>
</body>
</html>














