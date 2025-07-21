package chap08_servlet_container.c_request;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HttpServletRequestScope")

public class HttpServletRequestScope extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    /*
     * javax.servlet.htp.HttpServletRequest
     * 
     * 1. 한 번의 요청(Request)에서만 데이터를 전달할 수 있습니다.
     * 2. 현재 요청이 처리되는 동안 데이터에 접근할 수 있고, 요청이 끝나면(응답 시) 데이터는 소멸됩니다.
     * 3. 주로 RequestDispatcher를 이용한 forward 시 데이터를 전달하기 위해서 사용합니다.
     * 4. 데이터 저장 예시
     *    1) 저장: request.setAttrubute(String key, Object value);
     *    2) 조회: request.getAttribute(String key);
     *    3) 삭제: request.removeAttribute(String key);
     */
    
    //----- 데이터 저장
    List<Map<String, Object>> products = Arrays.asList(
        Map.of("model", "가", "price", 1000),
        Map.of("model", "나", "price", 2000),
        Map.of("model", "다", "price", 3000)
    );
    request.setAttribute("products", products);
    
    //----- forward
    request.getRequestDispatcher("/RequestDataView").forward(request, response);
    
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
