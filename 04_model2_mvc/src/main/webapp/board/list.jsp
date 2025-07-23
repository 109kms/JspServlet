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

<style>
  a {
    text-decoration: none;
    color: red;
    transition: transform 0.5s ease;
    display: inline;
  }
  a:hover {
    transform: scale(1.05);
  }
  div {
    box-sizing: border-box;
  }
  .regist-form-link {
    display: block;
    text-align: center;
  }
  .wrap {
    width: 1024px;
    margin: 0 auto;
  }
  .title {
    text-align: center;
    color: skyblue;
  }
  .flex-container {
    margin-top: 20px;
    display: flex;
    flex-wrap: wrap; /* 여러 줄로 flex-item 감싸기 */
    gap: 15px; 
  }
  .flex-item {
    flex: 0 0 calc(20% - 12px);  /* flex-grow flex-shrink flex-basis */
    border: 1px solid green;
    border-radius: 5px;
    text-align: center;
    padding-top: 10px;
    height: 100px;
    transition: transform 0.5s ease
  }
  .flex-item:hover {
    transform: scale(1.1);  /* 5% 확대 */
  }
  
</style>

</head>
<body>

<div class="wrap">

  <h1 class="title">게시글 목록 보기</h1>
  
  <a class="regist-form-link" href="${contextPath}/board/registForm.do">신규 게시글 작성</a>
  
  <div class="flex-container">
    <c:forEach var="b" items="${boards}">
      <div class="flex-item" onclick="detail(${b.bid})">
        <div><strong>${b.title}</strong></div>
        <div>${b.user.nickname}</div>      
      </div>
    </c:forEach>
  </div>
  
  <%--  
    	 `` 내부에서 EL(${})과 템플릿 리터럴(${}) 구분하기
    	 1. ${contextPath} : 자바 변수
    	 2. \${bid} : 자바스크립트 변수
  --%>
  
  <script type="text/javascript">
    function detail(bid) {
    	location.href = `${contextPath}/board/detail.do?bid=\${bid}&code=detail`;
    }
  </script>
</div>

</body>
</html>