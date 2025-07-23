package service;

import javax.servlet.http.HttpServletRequest;

import controller.ActionForward;
import dao.BoardDao;
import dao.BoardDaoImpl;
import model.dto.BoardDTO;
import model.dto.UserDTO;

public class BoardServiceImpl implements BoardService {

  //----- BoardDao 타입의 BoardDaoImpl 객체 생성
  private BoardDao boardDao = BoardDaoImpl.getInstance();
  
  @Override
  public ActionForward getBoards(HttpServletRequest request) {
    //----- SELECT 결과 저장
    request.setAttribute("boards", boardDao.getBoards());
    return new ActionForward("/board/list.jsp", false);
  }

  @Override
  public ActionForward getBoardById(HttpServletRequest request) {
    
    //----- 요청 파라미터 bid 처리 (bid 파라미터 전달이 없거나 정수가 아닌 값이 전달되면 bid = 0으로 처리)
    int bid = 0;
    try {
      bid = Integer.parseInt(request.getParameter("bid"));
    } catch (Exception e) {
      bid = 0;
    }
    
    //----- bid 값에 의한 SELECT 결과를 저장
    request.setAttribute("board", boardDao.getBoardById(bid));
    
    //----- 요청 파라미터 code
    String code = request.getParameter("code");
    
    //----- code에 따른 결과를 전달할 JSP 선택
    ActionForward af = null;
    switch (code) {
    case "detail":
      af = new ActionForward("/board/detail.jsp", false);
      break;
    case "modify":
      af = new ActionForward("/board/modify.jsp", false);
      break;
    default:
      af = new ActionForward(request.getContextPath() + "/main.do", true);
    }
    
    //----- code에 따라 선택된 JSP로 forward
    return af;

  }

  @Override
  public ActionForward registBoard(HttpServletRequest request) {
    
    //----- form에서 전달된 uid, title, content 받기
    int uid = Integer.parseInt(request.getParameter("uid"));
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    
    //----- uid, title, content 값으로 BoardDTO 객체 생성
    BoardDTO board = new BoardDTO();
    UserDTO user = new UserDTO();
    user.setUid(uid);
    board.setUser(user);
    board.setTitle(title);
    board.setContent(content);
    
    //----- 등록
    int count = boardDao.insertBoard(board);
    
    //----- 등록 결과에 따라 이동할 경로 결정
    String view = null;
    if (count == 1) {
      view = "/board/list.do";
    } else {
      view = "/board/registForm.do";
    }
    
    return new ActionForward(request.getContextPath() + view, true);
  }

  @Override
  public ActionForward modifyBoard(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ActionForward removeBoard(HttpServletRequest request) {
    
  //----- 요청 파라미터 bid 처리 (bid 파라미터 전달이 없거나 정수가 아닌 값이 전달되면 bid = 0으로 처리)
    int bid = 0;
    try {
      bid = Integer.parseInt(request.getParameter("bid"));
    } catch (Exception e) {
      bid = 0;
    }
    
    //----- 삭제
    int count = boardDao.deleteBoard(bid);
    
  //----- 삭제 결과에 따라 이동할 경로 결정
    String view = null;
    if (count == 1) {
      view = "/board/list.do";
    } else {
      view = "/main.do";
    }
    
    return new ActionForward(request.getContextPath() + view, true);
    
  }

}
