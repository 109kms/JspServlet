package service;

import javax.servlet.http.HttpServletRequest;

import common.ActionForward;

public interface BoardService {

  ActionForward getBoards(HttpServletRequest request);
  ActionForward findBoards(HttpServletRequest request);
  ActionForward findBoards2(HttpServletRequest request);
}
