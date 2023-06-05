<%@page import="java.util.List"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.text.MessageFormat"%>
<%@page import="java.util.Arrays"%>
<%@page import="kr.or.ddit.enumpkg.OperatorType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function submitForm() {
  var form = document.getElementById("calculationForm");
  var xhr = new XMLHttpRequest();
  xhr.open(form.method, form.action, true);
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status === 200) {
      // 처리 완료 후 수행할 동작
    }
  };
  xhr.send(new FormData(form));
  return false;
}

</script>
</head>
<body>
<form id="calculationForm" onsubmit="return submitForm()">
   <input type="number" name="leftOp" />
   <select name="opParam">
      <option value="">연산자</option>
      <%
         OperatorType[] opTypes = OperatorType.values();
         String options = Arrays.stream(opTypes)
               .map(op -> MessageFormat.format("<option value='{0}'>{1}</option>", op.name(), op.getSign()))
               .collect(Collectors.joining("\n"));
         out.println(options);
      %>
   </select>
   <input type="number" name="rightOp" />
   <button type="submit">=</button>
</form>
</body>
</html>
