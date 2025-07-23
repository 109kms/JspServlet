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
 * 
 */

public class BoardController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    //----- 요청 확인
    String servletPath = request.getServletPath();
    
    
    //----- 요청에 따른 구분
    switch (servletPath) {
    case "/board/list.do":
    case "/board/detail.do":
    case "/board/registForm.do":
    case "/board/regist.do":
    case "/board/modifyForm.do":
    case "/board/modify.do":
    case "/board/remove.do":
    }

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
