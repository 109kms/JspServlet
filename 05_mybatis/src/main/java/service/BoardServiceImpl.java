package service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import common.ActionForward;
import dao.BoardDao;
import model.dto.BoardDTO;

public class BoardServiceImpl implements BoardService {
  
  //----- 서비스는 DAO를 사용합니다.
  private BoardDao boardDao = BoardDao.getInstance();

  @Override
  public ActionForward getBoards(HttpServletRequest request) {

    //----- 요청 파라미터 sort (디폴트 DESC)
    String sort = request.getParameter("sort");
    if (sort == null || !(sort.equalsIgnoreCase("ASC") || sort.equalsIgnoreCase("DESC")))
      sort = "DESC";
    
    //----- 목록 가져오기
    List<BoardDTO> boards = boardDao.getBoards(sort);
    
    //----- 전체 게시글 개수 가져오기
    int boardCount = boardDao.getBoardCount();
    
    //----- 목록과 전체 게시글 개수를 저장 (전달할 수 있도록 request에 저장)
    request.setAttribute("boards", boards);
    request.setAttribute("boardCount", boardCount);
    
    //----- /view/board/list.jsp로 전달
    return new ActionForward("/view/board/list.jsp", false);
  }

  @Override
  public ActionForward findBoards(HttpServletRequest request) {
    
    // target, query, beginDate, endDate를 받아서 Map 생성
    Map<String, Object> map = Map.of(
        "target", request.getParameter("target"), 
        "query", request.getParameter("query"), 
        "beginDate", request.getParameter("beginDate"), 
        "endDate", request.getParameter("endDate")
    );
    
    //----- 검색
    List<BoardDTO> foundBoards = boardDao.findBoards(map);
    
    //----- 검색 결과를 저장 (전달할 수 있도록 request에 저장)
    request.setAttribute("boards", foundBoards);
    
    //----- /view/board/list.jsp로 전달
    return new ActionForward("/view/board/list.jsp", false);
  }

  @Override
  public ActionForward findBoards2(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

}
