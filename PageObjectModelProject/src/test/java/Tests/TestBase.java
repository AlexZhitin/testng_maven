package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestBase {

  ChromeDriver driver = new ChromeDriver();

  @BeforeSuite

  public void setUp() {

    driver.get("https://www.blablacar.com.ua/login/email");

  }

  @AfterSuite

  public void TeardownTest() {

    driver.quit();
  }
}