package Tests;

import Base.TestBase;
import Pages.HomePage;
import Pages.MobilePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SomeTest extends TestBase {
  private WebDriver driver;
  private String sectionMobile = "mobile";
  private String sectionGifts = "gifts";
  private String mobileSectionPageTitle = "Смартфоны, Телефоны";
  private String giftsSectionPageTitle = "Подарки к праздникам";




  @BeforeMethod
  public void setUp() {
    driver = getDriver();
  }

  @Test (description = "Testcase: verify mobile page title")
  @Severity(SeverityLevel.NORMAL)
  @Description("Testcase: verify mobile page title")
  @Story("Story: to check mobile page title")

  public void check_mobile_section_title() {

    HomePage home_page = new HomePage(driver);
    MobilePage mobile_page = new MobilePage(driver);

    String error = "Wrong page title or it's not showing";

    home_page.clickSection(sectionMobile);

    if (mobile_page.getPageTitleText().equals(mobileSectionPageTitle)) {
      Assert.assertTrue(true);
    } else {
      System.out.println(error);
      Assert.fail();
    }
  }

  @Test (description = "Testcase: verify gifts page title")
  @Severity(SeverityLevel.NORMAL)
  @Description("Testcase: verify gifts page title")
  @Story("Story: to check gifts page title")

  public void check_gifts_section_title() {

    HomePage home_page = new HomePage(driver);
    MobilePage mobile_page = new MobilePage(driver);

    String error = "Wrong page title or it's not showing";

    home_page.clickSection(sectionGifts);

    if (mobile_page.getPageTitleText().equals(giftsSectionPageTitle)) {
      Assert.assertTrue(false);
    } else {
      System.out.println(error);
      Assert.fail();
    }
  }
}