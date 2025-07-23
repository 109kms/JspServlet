<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <h1>${board.title}</h1>
  <div>작성자 : ${board.user.uid}</div>
  <div>작성자닉네임 : ${board.user.nickname}</div>
  <div>최초작성일시 : ${board.createdAt}</div>
  <div>최종수정일시 : ${board.modifiedAt}</div>

  <hr>

  <pre>${board.content}</pre>

  <hr>

  <button type="button" onclick="list()">목록보기</button>
  <c:if test="${board ne null}">
    <button type="button" onclick="deleteBoard()">삭제하기</button>
  </c:if>

  <script type="text/javascript">
      function list() {
        location.href = "${contextPath}/board/list.do";
      }
      function deleteBoard() {
        if (confirm("현재 게시글을 삭제할까요?")) {
          location.href = "${contextPath}/board/remove.do?bid=${board.bid}";
        }
      }
  </script>
  
</body>
</html>