package Tests;

import Base.ExtentTestManager;
import Base.TestBase;
import Pages.FansPage;
import Pages.SignInPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignInTest1 extends TestBase {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = getDriver();
    }

    @Test

    public void ValidLogin() {
        ExtentTestManager.getTest().log(Status.INFO, "Started ValidLogin()");

        SignInPage inputEmail = new SignInPage(driver);
        SignInPage inputPassword = new SignInPage(driver);
        SignInPage signin = new SignInPage(driver);
        FansPage logo = new FansPage(driver);


        inputEmail.typeEmail("john.brown@bkstg.com");
        inputPassword.typePassword("12345678");
        signin.clickSignInBtn();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue(logo.logoIsDisplayed());
        System.out.println("Test completed");
    }

    @Test

    public void ValidLogin1() {
        ExtentTestManager.getTest().log(Status.INFO, "Started ValidLogin1()");

        SignInPage inputEmail = new SignInPage(driver);
        SignInPage inputPassword = new SignInPage(driver);
        SignInPage signin = new SignInPage(driver);
        FansPage logo = new FansPage(driver);


        inputEmail.typeEmail("john.brown@bkstg.com");
        inputPassword.typePassword("12345678");
        signin.clickSignInBtn();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue(logo.logoIsDisplayed());

    }
}
