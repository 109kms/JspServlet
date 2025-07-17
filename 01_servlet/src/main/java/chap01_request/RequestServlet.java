package chap01_request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestServlet
 */
// @WebServlet("/RequestServlet")  //----- 현재 서블릿의 요청 주소(URL Mapping, URL Pattern)를 의미합니다.
//@WebServlet("/hello")            //      디폴트는 서블릿 이름(/RequestServlet)입니다.
//@WebServlet({"/RequestServlet", "/hello"})  //-- 배열로 여러 요청 주소를 전달할 수 있습니다.
@WebServlet("*.do")  //--------------------------- .do로 끝나느 모든 요청 주소를 처리합니다.
public class RequestServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  /**
   * Get 방식의 요청이 발생하면 해당 요청을 받는 메소드입니다.
   * <a href="주소">
   * <form method="get"> 또는 <form>
   * location = '주소'
   * open('주소')
   * fetch('주소', {method: 'get'}) 또는 fetch('주소')
   * 
   * @param HttpServletRequest request
   * 1. 클라이언트의 HTTP 요청을 Servlet에 전달하는 객체
   * 2. WAS(Wdb Application Server)가 클라이언트의 요청이 들어올때마다 자동으로 생성해서 전달
   * 3. 주요 기능
   *    1) 요청 메시지 분석(파싱)
   *    2) 요청 파라미터 처리
   *    3) 세션, 쿠키 등 상태 정보 관리
   *    4) 임시 저장소 기능
   * 
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
