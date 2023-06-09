<%@page import="java.util.Optional"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.stream.Collector"%>
<%@page import="java.util.stream.Stream"%>
<%@page import="java.time.Month"%>
<%@page import="java.time.temporal.TemporalField"%>
<%@page import="java.time.format.TextStyle"%>
<%@page import="java.time.DayOfWeek"%>
<%@page import="java.time.temporal.WeekFields"%>
<%@page import="java.text.MessageFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.YearMonth"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");
	int yearValue = Optional.ofNullable(request.getParameter("year"))
							.map((yp)->{return Integer.parseInt(yp);})
							.orElse(-1);
	
	int monthValue = Optional.ofNullable(request.getParameter("month"))
						     .map(mp -> Integer.parseInt(mp))
						     .orElse(-1);
	
	Locale locale = Locale.KOREA;
	ZoneId zone= ZoneId.systemDefault();
	LocalDate TODAY = LocalDate.now(zone);
	
	YearMonth targetYM = YearMonth.now(zone);
	
	if(yearValue != -1 && monthValue != -1){
		targetYM = YearMonth.of(yearValue, monthValue);
	}
	
	WeekFields weekFields =  WeekFields.of(locale);
	DayOfWeek firstDayOfWeek = weekFields.getFirstDayOfWeek();
	TemporalField dayOfWeek = weekFields.dayOfWeek();
	
	YearMonth beforeYM =  targetYM.minusMonths(1);
	YearMonth nextYM = targetYM.plusMonths(1);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05/calendarCase1.jsp</title>

<style type="text/css">
	.before,.after{
		color: silver;
	}
	.<%=DayOfWeek.SUNDAY.name().toLowerCase()%>{
		color:red;
	}
	.<%=DayOfWeek.SATURDAY.name().toLowerCase()%>{
		color:blue;
	}
	
	td,th{
		border: 1px solid black;
		text-align: center;
	}
	table {
		border-collapse: collapse;
		width: 100%;
		height: 500px;
	}
</style>

</head>
<body>
<h4>TODAY : <span id="todayArea"></span> </h4> 
<h4>SERVER's CURRENT : <span id="currentArea"></span> </h4>
<hr>

<form id="calendarForm" onchange="this.requestSubmit()">
<!-- <form id="calendarForm" onchange="changeCalendar()"> -->
	<input type="number" name ="year" data-year="<%=targetYM.getYear() %>">
	<select name="month" data-month ="<%=targetYM.getMonthValue() %>">
		<%=
			Stream.of(Month.values())
					.map(m->{
						return MessageFormat.format("<option value=''{0}''>{1}</option>",
								m.getValue(),
								m.getDisplayName(TextStyle.FULL, locale));
					}).collect(Collectors.joining("\n"))
		%>
	</select>
</form>

<h4 id="bnId"> 

<a data-year="<%=beforeYM.getYear() %>" data-month="<%= beforeYM.getMonthValue()%>"  onclick="myClick(this)">전달</a>
<%=targetYM.format(DateTimeFormatter.ofPattern("uuuu, MMMM", locale)) %> 
<a data-year="<%=nextYM.getYear() %>" data-month="<%= nextYM.getMonthValue()%>"  onclick="myClick(this)">다음달</a>

</h4>
<h4>first day of week : <%= weekFields.getFirstDayOfWeek() %></h4>
<table>
	<thead>
		<tr>
			<%
				for(int cnt=0; cnt<7; cnt++){
					DayOfWeek thisTurn= firstDayOfWeek.plus(cnt);
					out.println(
						MessageFormat.format("<th class=''{1}''>{0}</th>", 
								thisTurn.getDisplayName(TextStyle.FULL, locale),
								thisTurn.name().toLowerCase())
					);
				}
			%>
		</tr>
	</thead>
	<tbody>
		<%	
			LocalDate firstDate= targetYM.atDay(1);
			int offset = firstDate.get(dayOfWeek) - firstDayOfWeek.get(dayOfWeek); // 앞에 들어갈 공백
			LocalDate startDate = firstDate.minusDays(offset);
			int count = 0;
			for(int row=1;row<=6;row++){
				out.println("<tr>");
				for(int col=1;col<=7 ; col++){
					LocalDate thisTurn= startDate.plusDays(count++);
					YearMonth thisTurnYM = YearMonth.from(thisTurn);
					StringBuilder classes = new StringBuilder();
					
					classes.append(
							thisTurnYM.isBefore(targetYM) ? "before":
								thisTurnYM.isAfter(targetYM) ? "after":
									thisTurn.getDayOfWeek().name().toLowerCase());
					out.println(
						MessageFormat.format("<td class=''{1}''>{0}</td>"
						, thisTurn.getDayOfMonth(),classes)		
					);
				}
				out.println("</tr>");
			}
		%>
	</tbody>
</table>

<script type="text/javascript">
	// JS scheduling function : setTimeout(대기시간 설정), setInterval(갱신주기 설정)
	
	setInterval(() => {
		fetch("<%=request.getContextPath()%>/05/serverTime",{
			method:"get",
			headers:{
				"Accept" : "application/json" // ajax dataType과 동일	
			}
		}).then(resp=>resp.json()).then(html=>{
				currentArea.innerHTML= html.time.current;
				todayArea.innerHTML= html.time.today;
			});		
	}, 1000);
	
	function myClick(thisObj){
		calendarForm.querySelectorAll("[name]").forEach((ipt)=>{
			console.log(ipt)
			let name = ipt.name;
			let data = thisObj.dataset[name];
			if(data)
				ipt.value = data;
		});
		calendarForm.onchange()
	}
	
	calendarForm.querySelectorAll("[name]").forEach((ipt)=>{
		console.log(ipt)
		let name = ipt.name;
		let data = ipt.dataset[name];
		if(data)
			ipt.value = data;
	});
</script>

</body>
</html>