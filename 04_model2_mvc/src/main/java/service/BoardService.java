package service;

import javax.servlet.http.HttpServletRequest;

import controller.ActionForward;

/**
 * 비즈니스 로직을 작성하는 서비스 계층
 * 
 * 모든 서비스들은 컨트롤러로부터 request를 받아와서 사용하고,
 * 컨트롤러로 ActionForward를 반환합니다.
 */
public interface BoardService {

  ActionForward getBoards(HttpServletRequest request);
  ActionForward getBoardById(HttpServletRequest request);
  ActionForward registBoard(HttpServletRequest request);
  ActionForward modifyBoard(HttpServletRequest request);
  ActionForward removeBoard(HttpServletRequest request);
  
}
