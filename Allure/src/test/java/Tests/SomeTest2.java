package Tests;

import Base.TestBase;
import Helper.Utils;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MobilePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SomeTest2 extends TestBase {
    private WebDriver driver;
    HomePage home_page;
    MobilePage mobile_page;
    LoginPage login_page;


    private String sectionMobile = "mobile";
    private String sectionGifts = "gifts";
    private String mobileSectionPageTitleRu = "Смартфоны, Телефоны";
    private String mobileSectionPageTitleUa = "Смартфони, Телефони";
    private String giftsSectionPageTitleRu = "Подарки к праздника";
    private String giftsSectionPageTitleUa = "Подарунк";

    @Parameters({"local"})
    @BeforeMethod
    public void setUp(String local) {
        driver = getDriver(local);
        home_page = new HomePage(driver);
        mobile_page = new MobilePage(driver);
        login_page = new LoginPage(driver);
    }


    @Test(description = "Testcase: verify mobile page title")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testcase: verify mobile page title")
    @Story("Story: to check mobile page title")

    public void check_mobile_section_title() {

        home_page.clickSection(sectionMobile);

        home_page.clickSection(sectionMobile);

        Assert.assertTrue(mobile_page.getPageTitleText().equals(mobileSectionPageTitleRu) || mobile_page.getPageTitleText()
                .equals(mobileSectionPageTitleUa), "Wrong page title or it's not showing");
    }

    @Test(description = "Testcase: verify gifts page title")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testcase: verify gifts page title")
    @Story("Story: to check gifts page title")
//some test chang in master
    public void check_gifts_section_title() {

        home_page.clickSection(sectionGifts);

        Assert.assertTrue(mobile_page.getPageTitleText().equals(giftsSectionPageTitleRu)
                || mobile_page.getPageTitleText().equals(giftsSectionPageTitleUa), "Gifts page title is wrong");
    }

    @Test(description = "Testcase: check if profile is displayed")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testcase: verify if profile is displayed")
    @Story("Story: to check is profiele is available on the home page")

    public void profile_is_displayed() {

        Assert.assertTrue(home_page.profileIsDisplayed(), "Profile is not displayed on the home page");
    }
}
