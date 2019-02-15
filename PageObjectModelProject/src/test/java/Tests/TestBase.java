package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestBase {

  public static WebDriver driver;

  @BeforeSuite

  public void setUp() {

    driver = new ChromeDriver();


    driver.get("https://www.blablacar.com.ua/login/email");

  }

  @AfterSuite

  public void TeardownTest() {

    TestBase.driver.quit();
  }
}