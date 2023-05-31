<%@page import="java.text.MessageFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int minDan = (Integer)request.getAttribute("minDan");
	int maxDan = (Integer)request.getAttribute("maxDan");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02/gugudan.jsp</title>
</head>
<body>
<form id ="gugudanForm">
   <input type="text" placeholder="최소단" name="minDan" value="<%=minDan %>"/>
   <select name="maxDan">
      <option value>최대단</option>
      <%StringBuilder options= new StringBuilder();
        String optPtrn = "<option value=''{0}''{1}>{0}단</option>";
         for (int i=2;i<10;i++){
            String selected = i == maxDan ?  "selected" : "";
            options.append(MessageFormat.format(optPtrn,i,selected));
         }
         out.println(options);
      %>
      <%=options %>
   </select>
   <button type="submit">전송</button>
</form>

<h4><%=MessageFormat.format("{0}단부터 {1}단까지의 구구단", minDan,maxDan) %></h4>
<%=makeGugudanTable(minDan, maxDan) %>

<h4>2단부터 9단까지의 구구단</h4>

<%=makeGugudanTable(2,9)%>

<%
StringBuilder html= new StringBuilder();
html.append("<table>");
   for( int dan =2;dan<10;dan++){
      html.append("<tr>");
      for(int mul=1;mul<10;mul++){
         html.append(MessageFormat.format("<td>{0}*{1}={2}</td>", dan,mul,dan*mul));
      }
      html.append("<tr>");
      }
   html.append("</table>");
%>

<table>
   <%
   for( int dan =2;dan<10;dan++){
   %>
      <tr> 
      <%
      for(int mul=1;mul<10;mul++){
         %>
         <td><%=dan %>*<%=mul %>=<%=dan*mul %></td>
         <%
      }
      %>
      </tr>
      <%
   }
   %>
</table>

<%!
   private String makeGugudanTable(int min, int max){
   StringBuilder html= new StringBuilder();
   html.append("<table>");
      for( int dan =min;dan<=max;dan++){
         html.append("<tr>");
         for(int mul=1;mul<10;mul++){
            html.append(MessageFormat.format("<td>{0}*{1}={2}</td>", dan,mul,dan*mul));
         }
         html.append("<tr>");
         }
      html.append("</table>");
      return html.toString();
}
%>

</body>
</html>