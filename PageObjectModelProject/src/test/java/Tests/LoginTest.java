package Tests;

import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {


  @Test (priority = 1)



  public void validLogin() throws InterruptedException {

    test = extent.createTest("LoginTest");
    LoginPage login = new LoginPage(driver);


    login.LoginToCusp("sasha.z@bkstg.com", "12345678");
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    Boolean status = driver.findElement(By.xpath("//div[@class='sidebar-logo']")).isDisplayed();
    Assert.assertTrue(status);
  }

  @Test(priority = 2)

  public void invalidLogin() {
    LoginPage login = new LoginPage(driver);
    boolean status = false;


    login.LoginToCusp("sasha.z@bkstg.com", "invalid");
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    try {
      status = driver.findElement(By.xpath("//div[@class='sidebar-logo']")).isDisplayed();
    } catch (NoSuchElementException e)
    {Assert.assertFalse(status);}
  }
}
