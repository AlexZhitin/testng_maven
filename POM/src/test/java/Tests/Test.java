package Tests;

import Base.TestBase;
import Pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class Test extends TestBase {

  private WebDriver driver;

  @BeforeMethod
  public void setUp() {
    driver = getDriver();
  }

  @org.testng.annotations.Test

  public void someTestMethod() throws InterruptedException {

    SignInPage login = new SignInPage(driver);
    login.Login();
    Thread.sleep(5000);

  }
}
