<%@page import="java.util.Enumeration"%>
<%@page import="java.text.MessageFormat"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.7.0.min.js"></script>
</head>
<body>
<form id="sampleForm" action="<%=request.getContextPath()%>/03/dataProcess.do" method="post">
<pre>
	<input type="text" name="param1"/>
	<input type="number" name="param2"/>
	<select name="selParamSingle">
		<option value="">선택</option>
		<option value="opt1Value">opt1</option>
		<option>opt2</option>
	</select>
	<!-- HtmlElement, property, boolean -->
	<!-- attr("multiple","multiple") prop() -->	
	<select name="selParamMulti" multiple size="5" >
		<option value="">선택</option>
		<option value="opt1Value">opt1</option>
		<option>opt2</option>
	</select>
	<label><input type="radio" name="rdoParam" value="radio1" />RADIO1</label>
	<label><input type="radio" name="rdoParam" value="radio2" />RADIO2</label>
	<label><input type="checkbox" name="chkParam" value="Check1"> CHECK1</label>
	<label><input type="checkbox" name="chkParam" value="Check2"> CHECK2</label>
	<input type="date" name="dateParam">
	<input type="datetime-local" name="datetimeParam">
	<input type="submit" value="전송"/>
</pre>
</form>
<h4>HTTP Request Packaging(HttpServletRequest)</h4>

<pre>
	1. Request Line : protocol/version(HTTP/1.1) URL, Request Method
			<%=request.getProtocol() %>
			<%=request.getRequestURI() %>
			<%=request.getMethod() %>
			* Request Method : 현재 요청의 의도(목적)와 패키징 구조를 표현
			1) GET(default),R : Read
			2) POST,C  : Write
			------------서버에 따라 지원여부가 달라짐----------------
			3) PUT(전체수정)/PATCH(선택수정),U : Update
			4) DELETE, D : Delete
			5) OPTIONS : preFlight(서버가 담당할 수 있는 메소드가 무엇이 있는지) 요청에 사용됨.
			6) HEAD : response Body가 없는 응답을 요청함.
			7) TRACE : server debugging 요청.
	
	2. Request Header : meta data(현재 클라이언트와 요청에 대한 부가 정보)
			<%=request.getHeader("accept") %>
			- Accept-* : 응답에 대한 조건설정 -> server에서 반드시 분석해야 함
				ex) Accept : application/json, Accept-Language : ko_KR
			- User-Agent : 현재 클라이언트의 os, browser에 대한 설정
			- Content-* : request Body에 대한 정보, Body 없으면 x
				ex) Content-type : multipart/form-data, application/json
			
	3. Request Body(Content Body, Message Body, only POST) : send data(content) 그 자체
		1) 요청 파라미터 (application/x-www-form-urlencoded) 
			: Get 메소드에서도 Query String의 형태로 제한적인 파라미터를 전송할 수 있음
			- String getParameter(String parameterName)
			- Map&lt;String,String[]&gt;   getParameterMap()
			- String [] = getParameterValues(String parameterName)
			- Enumeration&lt;String&gt; getParameterNames()
			   
		2) multipart (multipart/form-data) : Part(servlet 3.x), FileItem(Servlet 2.x)
			- part는 input의 name에 의해 결정
			- Part getPart(String partName)
			- Collection&lt;Part&gt;  getParts(String partName)
			
		3) payload(json|xml , application/json | application/xml)
			- InputStream getInputStream()
			(역직렬화-DeSerialization, 언마샬링-UnMarshalling)
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
			StringBuilder sb = new StringBuilder();
			String pattern = "<tr><td>{0}</td><td>{1}</td></tr>\n";
			Enumeration<String> headList = request.getHeaderNames();
			while(headList.hasMoreElements()){
				String name = (String)headList.nextElement();
				String value = request.getHeader(name);
				sb.append(MessageFormat.format(pattern, name,value));
			}
			out.print(sb);
		%>
	</tbody>
</table>

<script type="text/javascript">
// 	sampleForm.onsubmit=
	$(sampleForm).on("submit",function(event){ //callbackfunction
		event.preventDefault();
		// this==event.target // HTMLElement
		// $(this) // jquery Object
		// this.action
		// $(this).attr("action")
		
		console.log(`HtmlElement : \${this}`);
		console.log(`jquery Object : \${$(this)}`);
		
		let url = this.action;
		let method = this.method;
		let data =$(this).serialize(); //직렬화! 해당 단계에서 native Language를 serialize함.
		
		let setting = {
			url : url,
			method : method,
			data : data,
			
			//-------------------------------------------------------
			
			dataType : "json", // Accept: applicaion/json,
			success : function(resp) {
				alert(resp.message);
			},
			error : function(jqXHR, status, error) {
				console.log(jqXHR)
				console.log(status)
				console.log(error)
			}
		} // request line, header, body -> response
		console.log(setting);
		$.ajax(setting);
		// request 를 어떻게 가져갈 것인가?
		return false;
	});
</script>

</body>
</html>