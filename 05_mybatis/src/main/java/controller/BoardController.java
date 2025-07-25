package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.BoardService;
import service.BoardServiceImpl;

@WebServlet("/board/*")

public class BoardController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    BoardService boardService = new BoardServiceImpl();
    
    String requestURI = request.getRequestURI();
    String contextPath = request.getContextPath();
    String path = requestURI.substring(contextPath.length());
    
    ActionForward af = null;
    
    switch (path) {
    case "/board/list":
      af = boardService.getBoards(request);
      break;
    case "/board/find":
      af = boardService.findBoards(request);
      break;
    case "/board/find2":
      af = boardService.findBoards2(request);
      break;
    case "/board/removeBoards":
      boardService.removeBoards(request, response);
      break;
    case "/board/registForm":
      af = new ActionForward("/view/board/regist.jsp", false);
      break;
    case "/board/regist":
      boardService.registBoard(request, response);
      break;
    case "/board/detail":
      af = boardService.getBoardById(request);
      break;
    case "/board/remove":
      boardService.removeBoard(request, response);
      break;
    case "/board/modifyForm":
      af = boardService.getBoardById(request);
      break;
    case "/board/modify":
      boardService.modifyBoard(request, response);
      break;
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
