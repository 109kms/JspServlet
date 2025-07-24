package dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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

}
