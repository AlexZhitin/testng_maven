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
  public void clickSignInBtn() {
    System.out.println("Home page test...");
    BasePage basePage = new BasePage(driver);
    Assert.assertTrue(basePage.verifyBasePageTitle(), "Home page title doesn't match");
  }

  @Test
  public void baseTest1() {
    ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test1");
    System.out.println("Hey im in test1 test");
    ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test1 1");
    ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test1 2");
    ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test1 3");
    ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test1 4");
  }

}
