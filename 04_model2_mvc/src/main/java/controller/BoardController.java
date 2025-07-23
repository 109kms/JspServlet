package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImpl;
import model.dto.BoardDTO;
import service.BoardService;
import service.BoardServiceImpl;

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
 * GET  /board/list.do
 * GET  /board/detail.do?bid=1&code=detail
 * GET  /board/registForm.do
 * POST /board/regist.do
 * GET  /board/modifyForm.do?bid=1&code=modify
 * POST /board/modify.do
 * GET  /board/remove.do?bid=1
 */

public class BoardController extends HttpServlet {
  
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
    //----- BoardService 객체 생성
    BoardService boardService = new BoardServiceImpl();
    
    //----- 요청 확인
    String servletPath = request.getServletPath();
    
    //----- ActionForward 객체 선언
    ActionForward af = null;
    
    //----- 요청에 따른 구분
    switch (servletPath) {
    case "/main.do":
      af = new ActionForward("/main.jsp", false);
      break;
    case "/board/list.do":
      af = boardService.getBoards(request);
      break;
    case "/board/detail.do":
      af = boardService.getBoardById(request);
      break;
    case "/board/registForm.do":
      af = new ActionForward("/board/regist.jsp", false);
      break;
    case "/board/regist.do":
      af = boardService.registBoard(request);
      break;
    case "/board/modifyForm.do":
      af = new ActionForward("/board/modify.jsp", false);
      break;
    case "/board/modify.do":
      af = new ActionForward("/board/detail.jsp", true);  //---- 확인 필요
      break;
    case "/board/remove.do":
      af = boardService.removeBoard(request);
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