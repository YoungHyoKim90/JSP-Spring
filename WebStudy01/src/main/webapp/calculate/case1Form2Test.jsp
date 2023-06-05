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
  // 폼 요소 가져오기
  var form = document.getElementById("calculationForm");
  // XMLHttpRequest 객체 생성
  var xhr = new XMLHttpRequest();
  // 폼 전송 방식과 동작 설정
  xhr.open(form.method, form.action, true);
  xhr.onreadystatechange = function () {
    // 요청이 완료되었고 응답이 정상인 경우
    if (xhr.readyState === 4 && xhr.status === 200) {
      // 처리 완료 후 수행할 동작
    }
  };
  // 폼 데이터 전송
  xhr.send(new FormData(form));
  // 폼이 실제로 제출되지 않도록 false 반환
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
         // OperatorType 열거형의 모든 값 가져오기
         OperatorType[] opTypes = OperatorType.values();
         // 옵션 요소 생성
         String options = Arrays.stream(opTypes)
               .map(op -> MessageFormat.format("<option value='{0}'>{1}</option>", op.name(), op.getSign()))
               .collect(Collectors.joining("\n"));
         // 옵션 요소 출력
         out.println(options);
      %>
   </select>
   <input type="number" name="rightOp" />
   <button type="submit">=</button>
</form>
</body>
</html>
