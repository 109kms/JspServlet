package chap01_request;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet
 * 
 * 1. Java 기반 웹 서버(WAS)에서 클라이언트의 HTTP 요청을 받아 동적으로 웹 페이지를 생성해 응답하는 서버측 프로그램입니다.
 * 2. 동적 웹 애플리케이션(Dynamic Web Project)의 핵심 기술로 javax.servlet.http.HttpServlet 클래스를 상속 받아 구현합니다. (Tomcat 9.0 기준)
 * 3. 주요 특징
 *    1) 동적 웹 페이지를 생성
 *    2) 클라이언트 요청을 처리
 *    3) MVC 패턴에서 주로 Controller 역할 담당
 *    4) 웹 컨테이너(서블릿 컨테이너, Tomcat) 안에서 동작 (하나의 애플리케이션에서 동일한 이름의 서블릿은 사용 불가)
 *    5) 객체는 싱글톤(Singleton)으로 관리
 *    6) 다양한 형식(HTML, JSON, XML 등)으로 응답 가능
 */

// @WebServlet("/RequestServlet")  //-------------- 현재 서블릿의 요청 주소(URL Mapping, URL Pattern)를 의미합니다. 디폴트는 서블릿 이름(/RequestServlet)입니다.
// @WebServlet("/hello")
// @WebServlet({"/RequestServlet", "/hello"})  //-- 배열로 여러 요청 주소를 전달할 수 있습니다.
@WebServlet("*.do")  //---------------------------- .do로 끝나는 모든 요청 주소를 처리합니다.

public class RequestServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * doGet()
   * GET 방식의 요청이 발생하면 해당 요청을 받는 메소드입니다.
   * 
   * GET 방식
   * 1. <a href="주소">
   * 2. <form method="get"> 또는 <form>
   * 3. location = '주소'
   * 4. open('주소')
   * 5. fetch('주소', {method: 'get'}) 또는 fetch('주소')
   * 
   * @param HttpServletRequest request
   * 1. 클라이언트의 HTTP 요청을 Servlet에 전달하는 객체
   * 2. WAS(Web Application Server)가 클라이언트의 요청이 들어올때마다 자동으로 생성해서 전달
   * 3. 주요 기능
   *   1) 요청 메시지 분석(파싱)
   *   2) 요청 파라미터 처리
   *   3) 세션, 쿠키 등 상태 정보 관리
   *   4) 임시 저장소 기능
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    //----- 요청 분석하기
    String requestURI = request.getRequestURI();  //----- /01_servlet/a/b/c.do
    String contextPath = request.getContextPath();  //--- /01_servlet (애플리케이션의 대표 주소로 디폴트는 프로젝트 이름입니다.)
    String servletPath = request.getServletPath();  //--- /a/b/c.do
    String ip = request.getRemoteAddr();  //------------- 0:0:0:0:0:0:0:1

    System.out.println("===== 요청 분석하기 =====");
    System.out.println("requestURI: " + requestURI);
    System.out.println("contextPath: " + contextPath);
    System.out.println("servletPath: " + servletPath);
    System.out.println("ip: " + ip);
    
    //----- 요청 파라미터 (?p1=100&p2=abc&p3=가나다)
    int p1 = 0;
    try {
        String p1Str = request.getParameter("p1");
        p1 = (p1Str != null && !p1Str.isEmpty()) ? Integer.parseInt(p1Str) : 0;
    } catch (NumberFormatException e) {
        p1 = -1; // 예외 처리: 숫자 아닌 값이 들어온 경우
    }

    String p2 = request.getParameter("p2");
    String p3 = request.getParameter("p3");
    Optional<String> opt = Optional.ofNullable(request.getParameter("p4"));  //----- 파라미터 p4를 Optional로 감쌉니다. 파라미터 p4는 null일수도 있습니다. (ofNullable)
    String p4 = opt.orElse("디폴트");  //------------------------------------------- 파라미터 p4가 null이라면 "디폴트"를 꺼냅니다.
    System.out.println("===== 요청 파라미터 =====");
    System.out.println("p1: " + (p1 + 10));
    System.out.println("p2: " + p2);
    System.out.println("p3: " + p3);
    System.out.println("p4: " + p4);
    
    response.getWriter().append("Served at: ").append(request.getContextPath());
    
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);  //----- post 요청으로 doPost() 메소드가 실행되면 doGet() 메소드를 직접 실행합니다.
  }

}