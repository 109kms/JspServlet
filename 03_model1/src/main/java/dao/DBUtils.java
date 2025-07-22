package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtils {

  // private 생성자 : 외부에서 new DBUtils() 호출 방지
  private DBUtils() {

  }

  public static Connection getConnection(){
    Connection con = null;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc?characterEncoding=UTF-8&serverTimezone=UTC",
          "goodee", "goodee");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return con;
  }

  public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
    try {
      if (rs != null) rs.close();
      if (ps != null) ps.close();
      if (con != null) con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
