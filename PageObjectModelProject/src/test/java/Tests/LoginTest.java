package Tests;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{


  @Test

  public void validLogin(){

    driver.get("https://www.blablacar.com.ua/login/email");

    LoginPage login = new LoginPage(driver);
    login.typeEmail();
    login.typePassword();
    login.clickLogin();
  }

}
