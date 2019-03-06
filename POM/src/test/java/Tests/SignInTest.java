package Tests;

import Base.ExtentTestManager;
import Base.TestBase;
import Pages.FansPage;
import Pages.SignInPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignInTest extends TestBase {

  private WebDriver driver;

  @BeforeMethod
  public void setUp() {
    driver = getDriver();
  }

  @Test

  public void LoginSuccessful() {
    ExtentTestManager.getTest().log(Status.INFO, "Started LoginSuccessful()");

    SignInPage inputEmail = new SignInPage(driver);
    SignInPage inputPassword = new SignInPage(driver);
    SignInPage signin = new SignInPage(driver);
    FansPage logo = new FansPage(driver);


    inputEmail.typeEmail("john.brown@bkstg.com");
    inputPassword.typePassword("12345678");
    signin.clickSignInBtn();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    try {
      if (logo.logoIsDisplayed()) {
        Assert.assertTrue(true);
      } else {
        System.out.println("Logo is not displayed");
      }
    } catch (Throwable e) {
      Assert.assertTrue(false);
    }
    System.out.println("Test completed");
  }



  @Test

  public void LoginFailed() {
    ExtentTestManager.getTest().log(Status.INFO, "Started LoginFailed()");

    SignInPage inputEmail = new SignInPage(driver);
    SignInPage inputPassword = new SignInPage(driver);
    SignInPage signin = new SignInPage(driver);
    FansPage logo = new FansPage(driver);


    inputEmail.typeEmail("john.brown@bkstg.com");
    inputPassword.typePassword("wrong password");
    signin.clickSignInBtn();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    try {
      if (logo.logoIsDisplayed()) {
        Assert.assertTrue(false);
      } else {
        System.out.println("Logo is not displayed");
      }
    } catch (Throwable e) {
      Assert.assertTrue(true);
    }
    System.out.println("Test completed");
  }


  @Test

  public void LoginError() {
    ExtentTestManager.getTest().log(Status.INFO, "Started LoginError()");

    SignInPage inputEmail = new SignInPage(driver);
    SignInPage inputPassword = new SignInPage(driver);
    SignInPage signin = new SignInPage(driver);
    SignInPage loginError = new SignInPage(driver);


    inputEmail.typeEmail("john.brown@bkstg.com");
    inputPassword.typePassword("wrong password");
    signin.clickSignInBtn();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    try {
      if (loginError.LoginError()) {
        Assert.assertTrue(true);
      } else {
        System.out.println("Logo is not displayed");
      }
    } catch (Throwable e) {
      Assert.assertTrue(false);
    }
    System.out.println("Test completed");
  }
}
