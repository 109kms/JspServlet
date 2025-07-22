package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dto.UserDTO;

/*
 * DAO (Data Access Object)
 * 
 * 1. 데이터베이스와의 연결, 데이터 조회/삽입/수정/삭제(CRUD) 등 데이터 접근 작업을 수행하는 객체입니다.
 * 2. 비즈니스 로직과 데이터베이스 로직을 분리하여 코드 구조화, 쉬운 유지보수, 코드 재사용성 등을 얻을 수 있습니다.
 * 3. 인터페이스를 통해 DAO 객체를 생성하면 구현체를 자유롭게 변경할 수 있습니다.
 */

public class UserDAO {

  //----- Singleton Pattern으로 객체 생성하기 (애플리케이션 전체에서 객체를 하나만 제공)
  // 1. private 생성자 (외부에서는 UserDAO 객체 생성 금지)
  // 2. 내부에서 UserDAO 객체 생성
  // 3. 생성한 UserDAO 객체를 반환하는 메소드 제공
  
  private UserDAO() {
    
  }
  private static UserDAO dao = new UserDAO();
  public static UserDAO getInstance() {
    return dao;
  }
  
  //----- 모든 메소드가 공통으로 사용할 필드
  private Connection con;
  private PreparedStatement ps;
  private ResultSet rs;
  private String sql;
  
  //----- 조회 (목록)
  public List<UserDTO> getUsers() {
    List<UserDTO> users = new ArrayList<UserDTO>();
    try {
      con = DBUtils.getConnection();
      sql = "SELECT uid, nickname FROM tbl_user ORDER BY uid";
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      while (rs.next()) {
        //----- DB에서 가져온 결과 ResultSet
        int uid = rs.getInt(1);
        String nickname = rs.getString(2);
        //----- 결과 ResultSet를 UserDTO로 변환 
        UserDTO user = new UserDTO();
        user.setUid(uid);
        user.setNickname(nickname);
        //----- 변환된 UserDTO를 List에 저장
        users.add(user);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      DBUtils.close(con, ps, rs);
    }
    return users;
  }
  
}