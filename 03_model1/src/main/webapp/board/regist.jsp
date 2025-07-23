<%@page import="dao.BoardDAO"%>
<%@page import="model.dto.BoardDTO"%>
<%@page import="model.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%
//----- registForm.jsp에서 제출된 양식
  request.setCharacterEncoding("UTF-8");
  String uid = request.getParameter("uid");
  String title = request.getParameter("title");
  String content = request.getParameter("content");
  
  //----- 제출된 양식을 DB에 저장할 수 있도록 BoardDTO 객체로 생성
  UserDTO user = new UserDTO();
  user.setUid(Integer.parseInt(uid));
  BoardDTO board = new BoardDTO();
  board.setUser(user);
  board.setTitle(title);
  board.setContent(content);
  
  //----- BoardDTO 객체를 DB에 저장
  int count = BoardDAO.getInstance().insertBoard(board);
  
  //----- 등록 후 이동할 경로 및 메시지 결정
  String msg = "게시글 등록 실패";
  String url = "registForm.jsp";
  if (count == 1){
    msg = "게시글 등록 성공";
    url = "list.jsp";
  }
%>

  <script>
    alert("<%=msg%>");
    location.href = "<%=url%>";
  </script>







