package MySQLProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;

public class SeleniumDatabaseTesting {

  public static void main(String[] args) {

//testdata
    String firstname = "Mike";
    String lastname = "Hillyer";
    String addressid = "4";
    String email = "Mike.Hill@sakilastaff.com";

    //input testdata
    ChromeDriver driver = new ChromeDriver();
    driver.get("http://mailing.dollartree.com/user/signup.jsp");
    driver.findElement(By.xpath("//*[@id='emailAddress']")).sendKeys(email);
    driver.findElement(By.xpath("//*[@id='zipCode']")).sendKeys(addressid);
    driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys(firstname);
    driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys(lastname);
    driver.findElement(By.xpath("//*[@id='subscribeForm']/div[2]/input[4]")).click();
    driver.findElement(By.xpath("//*[@id='subscribeForm']/div[3]/input[2]")).click();

    Connection conn = null;

    String url = "jdbc:mysql://localhost:3306/";
    String databaseName = "sakila";
    String username = "root";
    String password = "lenovos820";


    try {

      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(url + databaseName, username, password);

      //String sqlQuerry = "Select * from staff";

      String sqlQuerry = "Select * from staff ORDER BY staff_id ASC LIMIT 1";
      Statement statement = conn.createStatement();
      ResultSet result = statement.executeQuery(sqlQuerry);

      result.next();
      System.out.println(result.getString("first_name"));
      System.out.println(result.getString("last_name"));
      System.out.println(result.getString("address_id"));
      System.out.println(result.getString("email"));

      if (!result.getString("first_name").equals(firstname)){
        System.out.println("firstname doesn't match");
      }
      if (!result.getString("last_name").equals(lastname)){
        System.out.println("lastname doesn't match");}

      if (!result.getString("address_id").equals(addressid)){
        System.out.println("address id doesn't match");
      }
      if (!result.getString("email").equals(email)){
        System.out.println("email doesn't match");
      }


    } catch (Exception e) {
      System.out.println("e");
    } finally {
      if (conn != null) {
        conn = null;
      }
    }
  }
}
