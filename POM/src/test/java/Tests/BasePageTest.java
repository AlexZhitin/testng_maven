package Tests;

import Base.ExtentTestManager;
import Base.TestBase;
import Pages.BasePage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasePageTest extends TestBase {

  private WebDriver driver;

  @BeforeClass
  public void setUp() {
    driver = getDriver();
  }

  @Test

  public void TypeInEmailTest(){
    ExtentTestManager.getTest().log(Status.INFO, "Started TypeInEmailTest()");
    BasePage putinemail = new BasePage(driver);
    putinemail.typeEmail("john.brown@bkstg.com");

  }

  public void SignInTest() {
    ExtentTestManager.getTest().log(Status.INFO, "Started SignInTest()");
    BasePage signin = new BasePage(driver);
    signin.clickSignInBtn();

  }
}
