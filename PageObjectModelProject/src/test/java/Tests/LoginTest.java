package Tests;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest{

  private WebDriver driver;

  @Test

  public void validLogin(){

    LoginPage login = new LoginPage(driver);
  }

}
