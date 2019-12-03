package Tests;

import Base.TestBase;
import Pages.HomePage;
import Pages.MobilePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SomeTest extends TestBase {
  private WebDriver driver;
  private String sectionMobile = "mobile";
  private String mobileSectionPageTitle = "Смартфоны, Телефоны";




  @BeforeMethod
  public void setUp() {
    driver = getDriver();
  }

  @Test

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
}