package Tests;

import Base.TestBase;
import Pages.BasePage;
import Pages.ProfilePage;
import Pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProfilePageTest extends TestBase {
  private WebDriver driver;
  private SignInPage signInPage;
  private BasePage basePage;
  private ProfilePage profilePage;


  @BeforeClass
  public void setUp() {
    driver = getDriver();
  }

  @Test
  public void verifyprofileLocationText() {
    System.out.println("Create a profile page test...");
    basePage = new BasePage(driver);
    signInPage = basePage.clickSignInBtn();
    createAccountPage = signInPage.verifySignIn();
    Assert.assertTrue(createAccountPage.verifyPageTitle(), "Page title not matching");
    Assert.assertTrue(createAccountPage.verifyCreateAccountPageText(), "Page text not matching");
  }

}
