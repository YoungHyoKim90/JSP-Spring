<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사칙연산 하기</title>
</head>
<body>
    <h1>피연산자와 연산자를 입력하시오.</h1>
    <form action="calcProc.jsp" method="post">
        숫자1: <input type="text" name="firstNum"><br>
        숫자2: <input type="text" name="secondNum"><br>
        연산자: <select name="operator">
                <option value="+">+</option>
                <option value="-">-</option>
                <option value="*">*</option>
                
                <option value="/">/</option>
            </select>
        <br>
        <input type="submit" value="보내기">
    </form>

 <h2>연산 결과</h2>
    <%
        request.setCharacterEncoding("UTF-8"); //인코딩 형식
        
        int num1 = Integer.parseInt(request.getParameter("firstNum"));
        int num2 = Integer.parseInt(request.getParameter("secondNum"));
        
        String operator = request.getParameter("operator"); //select 태그의 name 값 operator에 저장
        
    %>
    <%
    if (operator.equals("+")) { %>
           <%=num1%> + <%=num2%> = <%=num1+num2 %>
       <%
        } else if (operator.equals("-")) { %>
            <%=num1%> - <%=num2%> = <%=num1-num2 %>
       <%
        }else if (operator.equals("*")){ %>
            <%=num1%> * <%=num2%> = <%=num1*num2 %>
       <%
        }else{    %>
            <%=num1%> / <%=num2%> = <%=num1/num2 %>
       <%
        }
        %>
 
</body>

</html>
