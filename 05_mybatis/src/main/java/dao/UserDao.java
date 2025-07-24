package dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.dto.UserDTO;

public class UserDao {

  private SqlSessionFactory factory;

  private UserDao() {
    try {
      InputStream in = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
      factory = new SqlSessionFactoryBuilder().build(in);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  private static UserDao dao = new UserDao();
  public static UserDao getInstance() {
    return dao;
  }
  
  //----- 조회 (회원 정보)
  public UserDTO getUser(UserDTO user) {
    SqlSession ss = factory.openSession();
    UserDTO foundUser = ss.selectOne("mybatis.userMapper.getUser", user);
    ss.close();
    return foundUser;
  }

}
