package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * MVC 흐름
 * 
 * view - filter - controller - service - dao
 * ----   ------   ----------   -------------
 * JSP    Filter   Servlet      Interface/Class
 */

//----- .do로 끝나는 모든 요청을 처리하는 컨트롤러
@WebServlet("*.do")

/*
 * Get  /board/list.do
 * Get  /board/detail.do
 */

public class BoardController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    //----- 요청 확인
    String servletPath = request.getServletPath();

    //----- ActionForward 객체 선언
    ActionForward af = null;

    //----- 요청에 따른 구분
    switch (servletPath) {
    case "/board/list.do":
      af = new ActionForward("/board/list.jsp", false);
      break;
    case "/board/detail.do":
      af = new ActionForward("/board/detail.jsp", false);
      break;
    case "/board/registForm.do":
      af = new ActionForward("/board/regist.jsp", false);
      break;
    case "/board/regist.do":
      af = new ActionForward("/board/list.jsp", true);  //----- 확인 필요
      break;
    case "/board/modifyForm.do":
      af = new ActionForward("/board/modify.jsp", false);
      break;
    case "/board/modify.do":
      af = new ActionForward("/board/detail.jsp", true);  //---- 확인 필요
      break;
    case "/board/remove.do":
      af = new ActionForward("/board/list.jsp", true);  // 확인 피료
      break;
    default:
      af = new ActionForward("/main.jsp", false);
    }
    
    //----- 이동
    if (af.isRedirect()) {
      response.sendRedirect(af.getView());
    } else {
      request.getRequestDispatcher(af.getView()).forward(request, response);
    }

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
