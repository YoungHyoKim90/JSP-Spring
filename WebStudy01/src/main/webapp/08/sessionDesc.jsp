<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>08/sessionDesc.jsp</title>
</head>
<body>

<h4>타이머 : <span id="timerArea"></span></h4>
<div id="messageArea">
	<p>세션 연장 여부 확인</p>
	<input type="button" value="예" class="controBtn" id="yesBtn"/>
	<input type="button" value="아니오" class="controBtn" id="noBtn"/>
</div>

<h4>HttpSession</h4>
<pre>
	HttpSession : http 프로토콜로 형성된 connection의 한 세션에 대한 정보를 가진 객체.
	세션 ?
	시간 (ConnectLess) :  어플리케이션을 사용하기 시작하는 순간부터 사용 종료까지의 기간.
	통로 (ConnetctFull): C/S사이의 유일한 연결 통로 (connection)
	
	세션의 생명주기 
		생성	:어플리케이션을 대상으로 최초의 요청이 발생한 경우.
			: 최초의 요청인지 확인 ; 트래킹 모드로 저장되어 전송되는 세션 아이디가 없는 요청인 경우, 최초로 판단.
			: --> session id가 부여된다.(식별, 최초 등을 판단.)
				<%= session.getId()%>
				<%= session.getId()%>
				<%= session.getId()%>
		유지 (session tracking mode) : C/S가 세션 아이디를 공유하는 방법.
			Cookie :
				ex) JSESSIONID라는 이름의 쿠키를 통해 세션 아이디 공유.
				URL : <a href="sessionDesc.jsp"> 세션 유지 </a>
				URL : <a href="sessionDesc.jsp?"> 세션 유지 </a>
				URL : <a href="sessionDesc.jsp;jsessionid=<%=session.getId() %>"> 세션 유지 </a>
				URL 은 보안에 취약함.
				SSL(Secure Socket Layer) : 모든 내용을 암호화.
		종료(소멸) - 종료하기에 참 애매하다. 그래서 몇가지 기준만을 만들고, 지킨다.
			1. timeout(만료시간) : 요청과 다음번 요청 사이의 시간의 간격이 timeout이상으로 벌어졌을때 세션이 소멸
			 --> 톰켓의 경우 30분
			2. cookie 삭제 : JSESSIONID 쿠키 제거 -> dummy session 잔존
			3. 브라우저 종료시 -> dummy session 잔존
			4. 명시적인 로그아웃 : invalidate 활용.
			<%--
			session.invalidate();
			--%>
			
			세션 생성 시점 : <%=new Date(session.getCreationTime()) %>
			세션 아이디 : <%=session.getId()%>
			timeout : <%= session.getMaxInactiveInterval() %>
			마지막 요청 시점 : <%= new Date(session.getLastAccessedTime()) %>
			
			<h4>타이머 : <span id="timerArea"></span></h4>
			
		
</pre>

<script type="text/javascript">
   const timeout = 2*60;      <%--    <%=session.getMaxInactiveInterval() %> 기본값 30분으로 세팅--%>
   const speed = 10000;
   let timer = timeout;
   let timeFormat = function(time){
      // formatting : 1:59
      if((time || time==0) && time >= 0){
         let minute = Math.trunc( time / 60 );
         let second = time % 60;
         return `\${new String(minute).padStart(2, '0')}:\${new String(second).padStart(2, '0')}`;
      }else{
         throw new Error("시간 데이터는 0이상의 값이 필요함.");
      }   
   }
   timerArea.innerHTML = timeFormat(timeout);
   // scheduling : timeout, interval
   let timerJob = setInterval(() => {
      if(timer<=0){
         clearInerval(timerJob);         
      }else{
         timerArea.innerHTML = timeFormat(--timer);
      }
   }, 1000);
   
   // 세션 연장 버튼 클릭 이벤트 처리
   const yesBtn = document.getElementById('yesBtn');
   const noBtn = document.getElementById('noBtn');
   yesBtn.addEventListener('click', function() {
      // 세션 연장을 위한 요청을 보낼 수 있는 코드 작성
      alert('세션 연장 요청을 보냈습니다.');
   });
   noBtn.addEventListener('click', function() {
      // 세션 연장을 하지 않는 경우 처리할 코드 작성
      alert('세션 연장을 취소했습니다.');
   });
</script>

</body>
</html>