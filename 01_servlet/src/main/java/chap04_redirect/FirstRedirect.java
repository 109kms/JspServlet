package chap04_redirect;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstRedirect")
public class FirstRedirect extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    /*
     * redirect
     * 
     * 1. 서버가 클라이언트에게 "새로운 주소로 다시 요청하세요"라고 지시하는 방식입니다. (응답의 일종입니다.)
     * 2. redirect 지시를 받은 클라이언트를 다시 새로운 주소로 이동하므로 URL 변경을 확인할 수 있습니다.
     * 3. 최초 요청 시 사용한 request와 response는 전달되지 않습니다. (redirect는 별개의 새로운 요청이기 때문입니다.)
     * 4. redirect 시 다른 서버로 이동할 수 있습니다.
     * 5. DB 의 데이터 변경 작업(UPDATE, INSERT, DELETE) 이후 redirect 이동으로 새로 고침으로 인한 중복 제출(서브밋) 등을 방지할 수 있습니다.
     *    PRG(Post-Redirect-Get) 패턴에 필수적인 역할을 수행합니다.
     */
    
    //----- redirect (새로운 주소로 다시 요청하라는 응답)
    response.sendRedirect("/01_servlet/SecondRedirect?p=" + URLEncoder.encode(request.getParameter("p"), "UTF-8"));  // context path와 servlet path 모드 작성

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
