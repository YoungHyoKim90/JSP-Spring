<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02/resourceIdentify.jsp</title>
</head>
<body>
<h4>자원의 종류와 식별 방법</h4>

<pre>

	1. file system resource
	2. classpath resource
	3. web resource
		 : 자원을 식별하는 방법
		URI(Uniform Resource Identifier)
		
		URL(Uniform Resource Locator) - 유일성을 확보하지만 위치가 변경되면, 어렵.->리다이렉트 사용. 역시 현물자산... 땅이지! 
		URN(Uniform Resource Naming) - 중복되는 이름이 있는 경우 식별이 안되고, 이름에 대한 명부가 먼저 존재해야함. -> 자원을 식별하기 위해 자원의 이름을 관리하는 자원이 필요함.
		URC(Uniform Resource Content) - 자원을 검색할때 여러가지 속성들을 가지고 검색. 

		URL 구성 요소
		http://www.naver.com/detpth01/....
		프로토콜 도메인           뎁스
		protoclol://IP[domain]:port/depth....
		
		SOP(Same Origin Policy)-동일출처의원칙, CORS(Cross Origin Resource Sharing)
		
		URL 표기 방식
		1) 절대경로 "/"로 시작
			(1) http://Localhost:80/WebStudy01/resources/images/cat2.png
			(2) //Localhost:80/WebStudy01/resources/images/cat1.jpg
			(3) /WebStudy01/resources/images/cat3.png
		
		2) 상대경로 : 현재 위치(location.href)를 기준으로 절대 경로를 파악하는 방법.
		
			(1) ../resources/images/cat1.jpg	
		
		
		
</pre>
<img alt="절대경로 표기방식입니다." src="//Localhost:80/WebStudy01/resources/images/cat1.jpg"/>
<img alt="절대경로 표기방식입니다." src="/WebStudy01/resources/images/cat3.png"/>
<img alt="절대경로 표기방식입니다." src="/resources/images/cat4.png"/>
<img alt="절대경로 표기방식입니다." src="http://Localhost:80/WebStudy01/resources/images/cat2.png"/>

<img alt="절대경로 표기방식입니다." src="<%= request.getContextPath() %>/resources/images/cat4.png"/>
<img alt="절대경로 표기방식입니다." src=""/>


<img alt="싱대경로 표기방식입니다." src="../resources/images/cat1.jpg">
</body>
</html>