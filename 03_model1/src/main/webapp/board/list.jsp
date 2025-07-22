<%@page import="dao.BoardDAO"%>
<%@page import="model.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <h1>Board 목록 보기</h1>
  
  <a href="${contextPath}/board/registForm.jsp">게시글등록하러가기</a>
  
  
  <c:set var="boards" value="${BoardDAO.getInstance().getBoards()}"/>
  
  <table border="1" >
    <thead>
      <tr>
        <th>게시글번호</th>
        <th>작성자번호</th>
        <th>제목</th>
        <th>작성일시</th>
      </tr>
    </thead>
    <tbody>
      <c:if test="${empty boards}">
        <tr>
          <td colspan="4">첫 게시글의 주인공이 되어 보세요.</td>
        </tr>
      </c:if>
      <c:if test="${not empty boards}">
        <c:forEach var="board" items="${boards}">
          <tr>
            <td>${board.bid}</td>
            <td>${board.user.uid}</td>
            <td>${board.title}</td>
            <td>${board.createdAt}</td>
          </tr>
        </c:forEach>
      </c:if>
    </tbody>
  </table>

</body>
</html>