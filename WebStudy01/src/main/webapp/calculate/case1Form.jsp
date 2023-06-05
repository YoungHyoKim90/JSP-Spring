<%@page import="java.util.List"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.text.MessageFormat"%>
<%@page import="java.util.Arrays"%>
<%@page import="kr.or.ddit.enumpkg.OperatorType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>
<form action="<%=request.getContextPath() %>/calculate/Case1ProcessServlet" method="post">
   <input type="number" name="leftOp" />
   <select name="opParam">
      <option value>연산자</option>
      <%
         OperatorType[] opTypes = OperatorType.values();
         String options = Arrays.stream(opTypes)
               .map(op -> MessageFormat.format("<option value=''{0}''>{1}</option>", op.name(), op.getSign()))
               .collect(Collectors.joining("\n"));
         out.println(options);
      %>
   </select>
   <input type="number" name="rightOp" />
   <button type="submit">=</button>
</form>
</body>
</html>