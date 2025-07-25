package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import dao.BoardDao;
import model.dto.BoardDTO;
import model.dto.UserDTO;

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

    // target, query, beginDate, endDate를 받아서 Map 생성
    Map<String, Object> map = Map.of(
        "title", request.getParameter("title"), 
        "content", request.getParameter("content"), 
        "beginDate", request.getParameter("beginDate"), 
        "endDate", request.getParameter("endDate")
        );

    //----- 검색
    List<BoardDTO> foundBoards = boardDao.findBoards2(map);

    request.setAttribute("boards", foundBoards);

    return new ActionForward("/view/board/list.jsp", false);

  }

  @Override
  public ActionForward getBoardById(HttpServletRequest request) {

    //----- bid
    int bid = 0;
    try {
      bid = Integer.parseInt(request.getParameter("bid"));
    } catch (Exception e) {
      bid = 0;
    }

    //----- code
    String code = request.getParameter("code");
    if ( !(code.equalsIgnoreCase("detail") || code.equalsIgnoreCase("modify")) ) {
      code = "detail";
    }

    //----- 게시글 가져와서 request에 저장
    request.setAttribute("board", boardDao.getBoardById(bid));

    //----- code에 따라 이동 경로 결정해서 forward
    return new ActionForward("/view/board/" + code + ".jsp", false);
  }

  @Override
  public void removeBoards(HttpServletRequest request, HttpServletResponse response) throws IOException{

    // 체크된 numbers 값 받기
    String[] numbers = request.getParameterValues("numbers");

    // 삭제
    int count = boardDao.deleteBoards(numbers);

    //----- 성공/실패에 따른 msg, view
    String msg = "삭제 성공";
    String view = "/board/list";
    if (count != numbers.length)
      msg = "삭제 실패";

    // 응답
    PrintWriter out = response.getWriter();
    out.println("<script>");
    out.println("alert('" + msg + "')");
    out.println("location.href='" + request.getContextPath() + view + "'");
    out.println("</script>");
    out.close();

  }

  @Override
  public void removeBoard(HttpServletRequest request, HttpServletResponse response) throws IOException {

    //----- bid
    int bid = 0;
    try {
      bid = Integer.parseInt(request.getParameter("bid"));
    } catch (Exception e) {
      bid = 0;
    }

    //----- 삭제
    int count = boardDao.deleteBoardById(bid);

    //----- 성공/실패에 따른 msg, view
    String msg = "삭제 성공";
    String view = "/board/list";
    if (count == 0)
      msg = "삭제 실패";

    // 응답
    PrintWriter out = response.getWriter();
    out.println("<script>");
    out.println("alert('" + msg + "')");
    out.println("location.href='" + request.getContextPath() + view + "'");
    out.println("</script>");
    out.close();

  }

  @Override
  public void registBoard(HttpServletRequest request, HttpServletResponse response) throws IOException {

    //---- uid, title, content 받아서 BoardDTO 객체 생성
    UserDTO user = new UserDTO(Integer.parseInt(request.getParameter("uid")), null, null, null);
    BoardDTO board = new BoardDTO(0, user, request.getParameter("title"), request.getParameter("content"), null, null);

    //----- 등록
    int count = boardDao.insertBoard(board);

    //----- 성공/실패에 따른 msg, view
    String msg = "등록 성공";
    String view = "/board/list";
    if (count == 0)
      msg = "등록 실패";
    view = "/board/registForm";

    // 응답
    PrintWriter out = response.getWriter();
    out.println("<script>");
    out.println("alert('" + msg + "')");
    out.println("location.href='" + request.getContextPath() + view + "'");
    out.println("</script>");
    out.close();

  }

  @Override
  public void modifyBoard(HttpServletRequest request, HttpServletResponse response) throws IOException {

    //----- bid
    int bid = Integer.parseInt(request.getParameter("bid"));
    
    //----- bid, title, content 받아서 BoardDTO 객체 생성
    BoardDTO board = new BoardDTO(
        bid, 
        null, 
        request.getParameter("title"), 
        request.getParameter("content"), 
        null, 
        null
    );
    
    //----- 수정
    int count = boardDao.updateBoard(board);
    
    //----- 성공/실패에 따른 msg, view
    String msg = "수정 성공";
    String view = "/board/deatil?bid=" + bid + "&code=detail";
    if (count == 0)
      msg = "수정 실패";
      view = "/board/modifyForm?bid=" + bid + "&code=modify";

    // 응답
    PrintWriter out = response.getWriter();
    out.println("<script>");
    out.println("alert('" + msg + "')");
    out.println("location.href='" + request.getContextPath() + view + "'");
    out.println("</script>");
    out.close();

  }




}
