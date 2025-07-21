<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <%--
  JSP 내장 객체
  
  1. 웹 애플리케이션 개발을 쉽게 할 수 있도록 미리 생성해서 제공하는 객체입니다.
  2. JSP에서는 별도의 선언 없이 곧바로 매장 객체를 사용할 수 있습니다.
  3. 내장 객체 9개
        Name          Type                                    Data Scope
     1) request       javax.servlet.http.HttpServletRequest   requestScope
     2) response      javax.servlet.http.HttpServletResponse  
     3) session       javax.servlet.http.HttpSession          sessionScope
     4) application   javax.servlet.ServletContext            applicationScope
     5) out           javax.servlet.jsp.JspWriter
     6) pageContext   javax.servlet.jsp.PageContext           pageScope
     7) page          현재 JSP 페이지 자신
     8) config        javax.servlet.ServletConfig
     9) exception     java.lang.Throwable
  4. 주요 객체 주의사항
     1) config    : JSP 페이지 초기화 파라미터 등에 접근할 때 사용할 수 있으나, 일반적으로 거의 사용 안함
     2) page      : JSP가 서블릿으로 변환되었을 때 현재 서블릿 인스턴스 자신을 의미하나, 거의 사용 안 함 (this와 동일하기 때문에)
     3) exception : 에러 페이지에서만 사용 가능( <%@ page isErrorPage="true" %> 지시어가 있어야 사용 가능)
 --%>

  <%-- 1. request --%>
  <%
    //----- 요청 인코딩
    request.setCharacterEncoding("UTF-8");
  
    //----- 요청 파라미ㅣ터
    request.getParameter("param");
  
    //----- 요청 헤더
    request.getHeader("User-Agent");
  
    //----- 요청 주소 분석
    request.getRequestURI();
    request.getContextPath();
    request.getServletPath();
    request.getRemoteAddr();
  
    //----- 데이터 저장
    request.setAttribute("key", "value");
    request.getAttribute("key");
    request.removeAttribute("key");
  
    //----- 포워드
    // request.getRequestDispatcher("/path").forward(request, response);
  %>

  <%-- 2. response --%>
  <%
    //----- 응답 데이터 타입
    response.setHeader("Content-Type", "Media Type");
    response.setContentType("Media Type");
  
    //----- 리다이렉트
    //response.sendRedirect("/path");
  
    //----- 쿠키 저장
    response.addCookie(new Cookie("name", "value"));
  %>

  <%-- 3. session --%>
  <%
    //----- 세션 유효시간 설정
    session.setMaxInactiveInterval(60 * 10); // 10분
    session.getAttribute("key");
    session.removeAttribute("key");
  
    //----- 세션 초기화
    session.invalidate();
  %>

  <%-- 4. application --%>
  <%
    //----- 데이터 처리
    application.setAttribute("key", "value");
    application.getAttribute("key");
    application.removeAttribute("key");
  %>

  <%-- 5. out --%>
  <%
    //----- 화면 출력
    int age = 30;
    if (age >= 20) {
      out.println("성인입니다.");
    } else {
      out.println("미성년자입니다.");
    }
  %>
  
  <%-- 6. pageContext --%>
  <%
    //----- 데이터 처리
    pageContext.setAttribute("key", "value");
    pageContext.getAttribute("key");
    pageContext.removeAttribute("key");
  %>

</body>
</html>