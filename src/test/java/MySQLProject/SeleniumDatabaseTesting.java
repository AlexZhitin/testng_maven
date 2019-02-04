package MySQLProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;

public class SeleniumDatabaseTesting {

  public static void main(String[] args) {

    //testdata
    String firstname = "Alex";
    String lastname = "Zhitin";
    String zip = "12345";
    String City = "Kiev";

    //input testdata
    ChromeDriver driver = new ChromeDriver();
    driver.get("http://mailing.dollartree.com/user/signup.jsp");
    driver.findElement(By.xpath("//*[@id='emailAddress']")).sendKeys(firstname);
    driver.findElement(By.xpath("//*[@id='zipCode']")).sendKeys(lastname);
    driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys(zip);
    driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys(City);
    driver.findElement(By.xpath("//*[@id='subscribeForm']/div[2]/input[4]")).click();
    driver.findElement(By.xpath("//*[@id='subscribeForm']/div[3]/input[2]")).click();


    Connection conn = null;

    String url = "jdbc:mysql://localhost:3306/";
    String databaseName = "btemployee";
    String username = "root";
    String password = "lenovos820";


    try {

      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(url + databaseName, username, password);

      String sqlQuerry = "Select * from employee";
      Statement statement = conn.createStatement();
      ResultSet result = statement.executeQuery(sqlQuerry);

      result.next();
      System.out.println(result.getString("FirstName"));
      System.out.println(result.getString("LastName"));
      System.out.println(result.getString("Zip"));
      System.out.println(result.getString("City"));

    } catch (Exception e) {
      System.out.println("e");
    } finally {
      if (conn != null) {
        conn = null;
      }
    }
  }
}
