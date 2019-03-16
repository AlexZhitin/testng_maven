package Tests;

import Base.ExtentTestManager;
import Base.TestBase;
import Pages.SignInPage;
import com.aventstack.extentreports.Status;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Test extends TestBase {

  private WebDriver driver;

  @BeforeMethod
  public void setUp() {
    driver = getDriver();
  }


  @org.testng.annotations.Test

  public void SomeTestMethod(){
    ExtentTestManager.getTest().log(Status.INFO, "Started someTestMethod()");

    SignInPage login = new SignInPage(driver);
    login.Login();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    Assert.assertTrue(true);
  }
}
