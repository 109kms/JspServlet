<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%--
  동적 페이지 include
  
  1. <jsp:include> 액션 태그를 이용합니다.
  2. 실행 시점(요청 시점)에 포함됩니다.
  3. 파라미터 전달이 가능합니다.
     <jsp:param name="파라미터이름" value="파라미터값"></jsp:param>
--%>
<jsp:include page="header.jsp">
  <jsp:param value="홈페이지" name="title"/>
</jsp:include>

<div class="body">

여기가 본문입니다.

</div>




<%--
  정적 페이지 include
  
  1. include 지시어(Directive)를 이용합니다.
  2. 컴파일 시점(변환 시점)에 포함됩니다.
  3. 파라미터 전달이 불가능합니다.
--%>
<%@ include file="footer.jsp"%>