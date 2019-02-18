package Tests;

import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {


  @Test

  public void validLogin() {

    test = extent.createTest("BlaBlaLoginTest");
    LoginPage login = new LoginPage(driver);
    login.LoginToBlaBlaCar("aszhitin@gmail.com", "lenovos820");
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    Boolean status = driver.findElement(By.xpath("//a[contains(text(),'Панель користувача')]")).isDisplayed();
    Assert.assertTrue(status);

  }

}
