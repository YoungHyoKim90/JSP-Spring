<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body>

<h1>Freeboard Input Form</h1>
    <form method="post" action="saveFreeboard.jsp">
        <label for="boNo">Board Number:</label>
        <input type="text" id="boNo" name="boNo" value="${freeboardVO.boNo}" /><br />

        <label for="boTitle">Title:</label>
        <input type="text" id="boTitle" name="boTitle" value="${freeboardVO.boTitle}" /><br />

        <label for="boWriter">Writer:</label>
        <input type="text" id="boWriter" name="boWriter" value="${freeboardVO.boWriter}" /><br />

        <label for="boIP">IP:</label>
        <input type="text" id="boIP" name="boIP" value="${freeboardVO.boIP}" /><br />

        <label for="boMail">Email:</label>
        <input type="text" id="boMail" name="boMail" value="${freeboardVO.boMail}" /><br />

        <label for="boPass">Password:</label>
        <input type="password" id="boPass" name="boPass" value="${freeboardVO.boPass}" /><br />

        <label for="boContent">Content:</label><br />
        <textarea id="boContent" name="boContent" rows="5" cols="50">${freeboardVO.boContent}</textarea><br />

        <label for="boDate">Date:</label>
        <input type="text" id="boDate" name="boDate" value="${freeboardVO.boDate}" /><br />

        <label for="boHit">Hit:</label>
        <input type="text" id="boHit" name="boHit" value="${freeboardVO.boHit}" /><br />

        <input type="submit" value="저장" />
    </form>
</body>
