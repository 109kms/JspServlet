package chap04_el;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestDataHandle")

public class RequestDataHandle extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    //----- request에 데이터 저장 후 forward
    request.setAttribute("height", 173.9);
    request.getRequestDispatcher("/chap04_el/Result.jsp?weight=75.5").forward(request, response);

  }

}
