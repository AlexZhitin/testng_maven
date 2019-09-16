package Tests;

import Base.ExtentTestManager;
import Base.TestBase;
import Pages.NotifyCusp;
import Pages.SignInPage;
import Pages.TopBarSection;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NotifyCuspTest extends TestBase {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = getDriver();
    }

    @Test /*C39253*/

    public void FullNameFieldIsDisplayed() {

        SignInPage login = new SignInPage(driver);
        TopBarSection profileIcon = new TopBarSection(driver);
        TopBarSection notifyOption = new TopBarSection(driver);
        NotifyCusp dialog = new NotifyCusp(driver);

        String error = "Notify CUSP dialog is not shown on click of the Notify Cusp";
        String test = "Testcase C39253";

        login.LoginGlobalAdmin();
        profileIcon.clickMenuIcon();
        notifyOption.clickNotifyOption();

        if (dialog.NotifyCuspDialogIsDisplayed()) {
            Assert.assertTrue(false);////should be true
        } else {
            System.out.println(error);
            ExtentTestManager.getTest().log(Status.INFO, error);
            Assert.fail();
        }
        ExtentTestManager.getTest().log(Status.INFO, test);
    }

    @Test /*C39255*/

    public void SendButtonIsDisabledIfDescriptionIsEmpty() {

        SignInPage login = new SignInPage(driver);
        TopBarSection profileIcon = new TopBarSection(driver);
        TopBarSection notifyOption = new TopBarSection(driver);
        NotifyCusp field = new NotifyCusp(driver);
        NotifyCusp button = new NotifyCusp(driver);

        String text = "Autotest";
        String error = "Send button is enabled even though the description field is empty";
        String test = "Testcase C39255";

        login.LoginGlobalAdmin();
        profileIcon.clickMenuIcon();
        notifyOption.clickNotifyOption();
        field.putInTitle(text);

        if (button.SendButtonIsDisabled()) {
            Assert.assertTrue(true);
        } else {
            System.out.println(error);
            ExtentTestManager.getTest().log(Status.INFO, error);
            Assert.fail();
        }
        ExtentTestManager.getTest().log(Status.INFO, test);
    }
}