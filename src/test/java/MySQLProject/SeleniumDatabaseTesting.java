package MySQLProject;

import java.sql.*;

public class SeleniumDatabaseTesting {

  public static void main(String[] args) {

    Connection conn = null;

    String url = "jdbc:mysql://localhost:3306/";
    String databaseName = "btemployee";
    String username = "root";
    String password = "lenovos820";


    try {

      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(url + databaseName, username, password);

      String sqlQuerry = "";
      Statement statement =

    } catch (Exception e) {
      System.out.println("e");
    } finally {
      if (conn != null) {
        conn = null;
      }
    }
  }
}
