<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
#top {
	width: 100%;
	height: 100px;
	background-color: yellow;
}

#content {
	width: 100%;
	height: 300px;
}

#foot {
	width: 100%;
	height: 100px;
	background-color: green;
}
</style>

</head>
<body>

	<div id="top">상단메뉴</div>
	<div id="content">
		<tiles:insertAttribute name="content" />
	</div>
	<div id="foot">저작권정보</div>

</body>
</html>