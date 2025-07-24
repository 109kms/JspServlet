package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.UserService;
import service.UserServiceImpl;

@WebServlet("/user/*")

public class UserController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    UserService userService = new UserServiceImpl();
    
    String requestURI = request.getRequestURI();
    String contextPath = request.getContextPath();
    String path = requestURI.substring(contextPath.length());
    
    ActionForward af = null;
    
    switch (path) {
    case "/user/loginForm":
      af = new ActionForward("/view/user/login.jsp", false);
      break;
    case "/user/login":
      af = userService.login(request);
      break;
    case "/user/logout":
      af = userService.logout(request);
      break;
    default:
      af = new ActionForward(request.getContextPath() + "/main", true);
    }
    
    if (af != null) {
      if (af.isRedirect()) {
        response.sendRedirect(af.getView());
      } else {
        request.getRequestDispatcher(af.getView()).forward(request, response);
      }
    }
    
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
