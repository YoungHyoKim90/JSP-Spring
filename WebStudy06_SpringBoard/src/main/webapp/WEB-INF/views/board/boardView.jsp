<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table class="table table-border">
   <tr>
      <th>글번호</th>
      <td>${freeboard.boNo }</td>
   </tr>
   <tr>
      <th>제목</th>
      <td>${freeboard.boTitle }</td>
   </tr>
   <tr>
      <th>작성자</th>
      <td>${freeboard.boWriter }</td>
   </tr>
   <tr>
      <th>아이피</th>
      <td>${freeboard.boIp }</td>
   </tr>
   <tr>
      <th>이메일</th>
      <td>${freeboard.boMail }</td>
   </tr>
   <tr>
      <th>비밀번호</th>
      <td>${freeboard.boPass }</td>
   </tr>
   <tr>
         <th>첨부파일</th>
         <td>
            <c:if test="${not empty freeboard.fileGroup and not empty freeboard.fileGroup.detailList }">
               <c:forEach items="${freeboard.fileGroup.detailList}" var="fileDetail">
                 <c:url value="/board/download.do" var="downloadURL">
                    <c:param name="atchFileId"  value="${fileDetail.atchFileId }"/>
                    <c:param name="fileSn" value="${fileDetail.fileSn }"/>
                 </c:url>
                 <a href="${downloadURL }">${fileDetail.orignlFileNm }</a>
             </c:forEach>
            </c:if>
         </td>
   </tr>
   
   <tr>
      <th>내용</th>
      <td>${freeboard.boContent }</td>  
   </tr>
   <tr>
      <th>작성일</th>
      <td>${freeboard.boDate }</td>
   </tr>
   <tr>
      <th>조회수</th>
      <td>${freeboard.boHit }</td>
   </tr>
      <tr>
      <th>삭제</th>
   	</tr>
   <tr>
      <td>
         <a class="btn btn-primary" href="<c:url value='/board/boardUpdate.do'/>">수정</a>
         <a class="btn btn-danger" href="<c:url value='/board/boardDelete.do'/>">삭제</a>
      </td>
   </tr>

</table>