package chap08_servlet_container.b_session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HttpSessionScope")

public class HttpSessionScope extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    /*
     * javax.servlet.http.HttpSession
     * 
     * 1. 각 사용자의 세션(웹 브라우저 단위 사용자 단위의 임시 저장공간)을 제공하는 인터페이스입니다.
     * 2. 웹 애플리케이션의 프로토콜인 HTTP는 기본적으로 어떤 상태도 기억하지 않는 stateless이므로
     *    각 사용자의 정보(로그인 상태, 장바구니 등)를 서버가 일정 시간 동안 기억하도록 도와줍니다.
     * 3. 세션은 접속한 사용자가 브라우저를 닫거나, 타임 아웃되거나, 명시적을 삭제하면 소멸됩니다.
     * 4. 세션의 유효시간은 기본 30분이며, 코드(setMaxInactiveInterval()) 또는 설정(web.xml)을 이용해 변경할
     * 5. 세션 데이터는 서버 메모리에 저장되며, 각 사용자마다 고유의 식별자인 JSESSIONID를 할당합니다.
     *    이 값은 일반적으로 쿠키에 JSESSIONID라는 이름으로 저장됩니다.
     * 6. HttpSesseion 객체 얻기
     *    HttpSession session = request.getSesseion();
     * 7. 데이터 저장 예시
     *    1) 저장: session.setAttrubute(String key, Object value);
     *    2) 조회: session.getAttribute(String key);
     *    3) 삭제: session.removeAttribute(String key);
     */
    
    //----- HttpSession 객체 얻기
    HttpSession session = request.getSession();
    
    //----- 세션 유효시간 설정 (기본 30분)
    session.setMaxInactiveInterval(60 * 10);  // 10분
    
    //----- 데이터 저장
    session.setAttribute("data2", true);
    
    //----- 데이터 조회
    boolean data2 = (boolean) session.getAttribute("data2");
    System.out.println(data2);
    
    //----- 세션 삭제 (로그아웃 등)
    session.invalidate();

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    doGet(request, response);
  }

}
