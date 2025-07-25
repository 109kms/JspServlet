<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <div class="list-wrap">
    
    <h1>게시글 목록 화면</h1>
    
    <div>
      <div>통합 검색1</div>
      <form action="${contextPath}/board/find">
        <select name="target">
          <option value="title">제목</option>
          <option value="content">내용</option>
          <option value="created_at">작성일자</option>
        </select>
        <input type="text" name="query" placeholder="검색어">
        <br>
        <input type="date" name="beginDate">-<input type="date" name="endDate"><br>
        <button type="submit">검색</button>
      </form>
    </div>
    
    <br>
    
    <div>
      <div>통합 검색2</div>
      <form action="${contextPath}/board/">
        <input type="text" name="title" placeholder="제목 검색"><br>
        <input type="text" name="content" placeholder="내용 검색"><br>
        <input type="date" name="beginDate">-<input type="date" name="endDate"><br>
        <button type="submit">검색</button>
      </form>
    </div>
    
    <br>
    
    <div><a href="${contextPath}/board/list?sort=DESC">최신순</a> | <a href="${contextPath}/board/list?sort=ASC">과거순</a></div>
    <form action="${contextPath}/board/" 
          method="post">
      <div class="btn-wrap"><button type="submit">선택삭제</button></div>
      <table border="1">
        <thead>
          <tr>
            <td><input type="checkbox"></td>
            <td>제목</td>
            <td>작성자</td>
            <td>작성일자</td>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="b" items="${boards}">
            <tr>
              <td><input type="checkbox" name="numbers" value="${b.bid}"></td>
              <td><a href="${contextPath}/board/">${b.title}</a></td>
              <td>${b.user.nickname}</td>
              <td><fmt:formatDate value="${b.createdAt}" pattern="yyyy-MM-dd"/></td>
            </tr>
          </c:forEach>
        </tbody>
        <tfoot>
          <tr>
            <td colspan="4">전체 ${boardCount}개 게시글이 있습니다.</td>
          </tr>
        </tfoot>
      </table>
      <br>
      <div><a href="${contextPath}/board/">새 게시글 작성하기</a></div>
    </form>
  </div>

</body>
</html>