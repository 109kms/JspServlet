package chap03_forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstForward")
public class FirstForward extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    /*
     * forward
     * 
     * 1. 현재 서블릿이 받은 클라이언트 요청(request)과 응답(response) 객체를 서버 내의 다른 리소스(서블릿)로 그대로 전달하는 기능입니다.
     * 2. 이 과정은 서버 내부에서 이루어지기 때문에 클라이언트는 이 사실을 알 수 없습니다. (URL 변경 감지를 못합니다.)
     * 3. 요청(request)에 저장된 데이터(파라미터, 속성)도 함께 전달됩니다.
     * 4. SELECT 문의 실행 결과를 전달하기 위해서 forward를 활용합니다.
     * 5. 단순한 다른 페이지로의 이동도 forward를 활용합니다.
     */
    
    //----- SeconFroward로 요청(request)과 응답(response) 전달(forward)하기
    RequestDispatcher dispatcher = request.getRequestDispatcher("/SecondForward");  //----- Servlet Path 작성
    dispatcher.forward(request, response);

  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
