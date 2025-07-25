package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public interface BoardService {
  //----- 조회 서비스 (요청을 받아서 포워드 처리)
  ActionForward getBoards(HttpServletRequest request);
  ActionForward findBoards(HttpServletRequest request);
  ActionForward findBoards2(HttpServletRequest request);
  ActionForward getBoardById(HttpServletRequest request);
  
  //----- 변경 서비스 (등록/수정/삭제: 요청을 받아 직접 응답 처리)
  void removeBoards(HttpServletRequest request, HttpServletResponse response) throws IOException;
  void removeBoard(HttpServletRequest request, HttpServletResponse response) throws IOException;
  void modifyBoard(HttpServletRequest request, HttpServletResponse response) throws IOException;
  void registBoard(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
