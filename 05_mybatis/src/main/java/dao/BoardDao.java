package dao;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.dto.BoardDTO;

public class BoardDao {

  private SqlSessionFactory factory;

  private BoardDao() {
    try {
      InputStream in = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
      factory = new SqlSessionFactoryBuilder().build(in);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  private static BoardDao dao = new BoardDao();
  public static BoardDao getInstance() {
    return dao;
  }
  
  //----- boardMapper.xml의 namespace
  String namespace = "mybatis.boardMapper.";
  
  //----- 조회 (목록)
  public List<BoardDTO> getBoards(String sort) {
    SqlSession ss = factory.openSession();
    List<BoardDTO> boards = ss.selectList(namespace + "getBoards", sort);
    ss.close();
    return boards;
  }
  
  //----- 조회 (단일)
  public BoardDTO getBoardById(int bid) {
    SqlSession ss = factory.openSession();
    BoardDTO board = ss.selectOne(namespace + "getBoardById", bid);
    ss.close();
    return board;
  }
  
  //----- 조회 (함수 처리)
  public int getBoardCount() {
    SqlSession ss = factory.openSession();
    int count = ss.selectOne(namespace + "getBoardCount");
    ss.close();
    return count;
  }
  
  //----- 조회 (제목과 내용 검색)
  public List<BoardDTO> findBoardsUsingQuery(Map<String, Object> map){
    SqlSession ss = factory.openSession();
    List<BoardDTO> foundBoards = ss.selectList(namespace + "findBoardsUsingQuery", map);
    ss.close();
    return foundBoards;
  }
  
  //----- 조회 (최초 작성일자 검색)
  public List<BoardDTO> findBoardsUsingDate(Map<String, Object> map2){
    SqlSession ss = factory.openSession();
    List<BoardDTO> foundBoards = ss.selectList(namespace + "findBoardsUsingDate", map2);
    ss.close();
    return foundBoards;
  }
  
  //----- 조회 (통합 검색)
  public List<BoardDTO> findBoards(Map<String, Object> map) {
    SqlSession ss = factory.openSession();
    List<BoardDTO> foundBoards = ss.selectList(namespace + "findBoards", map);
    ss.close();
    return foundBoards;
  }
  
  //----- 조회 (통합 검색1)
  public List<BoardDTO> findBoards2(Map<String, Object> map) {
    SqlSession ss = factory.openSession();
    List<BoardDTO> foundBoards = ss.selectList(namespace + "findBoards2", map);
    ss.close();
    return foundBoards;
  }
  
  //----- 등록
  public int insertBoard(BoardDTO board) {
    SqlSession ss = factory.openSession(false);  //----- 수동 커밋으로 설정
    int count = ss.insert(namespace + "inserBoard", board);
    if (count == 1) ss.commit(); //-- 성공 시 수동으로 커밋하기
    ss.close();
    return count;
  }
  
  //----- 수정
  public int updateBoard(BoardDTO board) {
    SqlSession ss = factory.openSession();
    int count = ss.update(namespace + "updateBoard", board);
    if (count == 1) ss.commit();
    ss.close();
    return count;
  }
  
  //----- 삭제 (단일)
  public int deleteBoardById(int bid) {
    SqlSession ss = factory.openSession();
    int count = ss.delete(namespace + "deleteBoardById", bid);
    if (count == 1) ss.commit();
    ss.close();
    return count;
  }
  
  //----- 삭제 (목록)
  public int deleteBoards(String[] numbers) {
    SqlSession ss = factory.openSession();
    int count = ss.delete(namespace + "deleteBoards", numbers);
    if (count == numbers.length) ss.commit();
    ss.close();
    return count;
  }
  
  

}
