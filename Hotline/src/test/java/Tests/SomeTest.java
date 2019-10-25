package Tests;

import Base.ExtentTestManager;
import Base.TestBase;
import Pages.HomePage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SomeTest extends TestBase {
  private WebDriver driver;
  private String sectionMobile = "mobile";

  @BeforeMethod
  public void setUp() {
    driver = getDriver();
  }

  @Test /*C39205*/

  public void sectionMobile() throws InterruptedException {

    HomePage section = new HomePage(driver);

    String error = "Full name field is not shown on Add User dialog";
    String test = "Testcase C39205";

    section.clickSection(sectionMobile);
    
    /*if (field.FullNameFieldIsDisplayed()) {
      Assert.assertTrue(true);
    } else {
      System.out.println(error);
      ExtentTestManager.getTest().log(Status.INFO, error);
      Assert.fail();
    }*/
    ExtentTestManager.getTest().log(Status.INFO, test);
  }
}