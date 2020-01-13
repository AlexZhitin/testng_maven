package Tests;

import Base.AllureTestListener;
import Base.ExcelToDataProvider;
import Base.TestBase;
import Pages.HomePage;
import Pages.MobilePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

public class SomeTest extends TestBase {
  private WebDriver driver;

  HomePage home_page;
  MobilePage mobile_page;


  private String sectionMobile = "mobile";
  private String sectionGifts = "gifts";
  private String mobileSectionPageTitle = "Смартфоны, Телефоны";
  private String giftsSectionPageTitle = "Подарки к праздникам";




  @BeforeMethod
  public void setUp() {
    driver = getDriver();
    home_page = PageFactory.initElements(driver, HomePage.class);
    mobile_page = PageFactory.initElements(driver, MobilePage.class);
  }

  @Test (description = "Testcase: verify mobile page title")
  @Severity(SeverityLevel.NORMAL)
  @Description("Testcase: verify mobile page title")
  @Story("Story: to check mobile page title")

  public void check_mobile_section_title() {

    String error = "Wrong page title or it's not showing";

    home_page.clickSection(sectionMobile);

    if (mobile_page.getPageTitleText().equals(mobileSectionPageTitle)) {
      Assert.assertTrue(true);
    } else {
      System.out.println(error);
      AllureTestListener.saveTextLog(error);
      Assert.fail();
    }
  }

  @Test (description = "Testcase: verify gifts page title")
  @Severity(SeverityLevel.NORMAL)
  @Description("Testcase: verify gifts page title")
  @Story("Story: to check gifts page title")

  public void check_gifts_section_title() {

    String error = "Wrong page title or it's not showing";

    home_page.clickSection(sectionGifts);

    if (mobile_page.getPageTitleText().equals(giftsSectionPageTitle)) {
      Assert.assertTrue(true);
    } else {
      System.out.println(error);
      AllureTestListener.saveTextLog(error);
      Assert.fail();
    }
  }

  @Test (description = "", dataProviderClass = ExcelToDataProvider.class, dataProvider = "userData")
  @Severity(SeverityLevel.NORMAL)
  @Description("")
  @Story("Story: ")

  public void read_from_excel(String userName, String passWord, String dateCreated, String noOfAttempts, String result) {

    System.out.println("UserName: "+ userName);
    System.out.println("PassWord: "+ passWord);
    System.out.println("DateCreated: "+ dateCreated);
    System.out.println("NoOfAttempts: "+ noOfAttempts);
    System.out.println("Result: "+ result);
    System.out.println("*********************");

    /*revert*/

  }
}