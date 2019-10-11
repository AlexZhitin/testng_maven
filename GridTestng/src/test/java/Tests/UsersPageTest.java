package Tests;

import Base.Distribution;
import Base.ExtentTestManager;
import Base.TestngBase;
import Pages.SignInPage;
import Pages.TopBarSection;
import Pages.UsersPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UsersPageTest extends Distribution {

    private WebDriver driver;

    @Parameters({"connection"})
    @BeforeMethod

    public void setUp(String connection) {
        driver = Connection(connection);
        /*driver = getDriver();*/
    }

    @Test /*C39153*/

    public void AddUserButtonisDisplayed() {

        SignInPage login = new SignInPage(driver);
        TopBarSection profileIcon = new TopBarSection(driver);
        TopBarSection usersOption = new TopBarSection(driver);
        UsersPage buttonAddUser = new UsersPage(driver);


        String error = "Add new user button is not displayed";
        String test = "Testcase C39153";


        login.LoginGlobalAdmin();

        profileIcon.clickMenuIcon();
        usersOption.clickUsersOption();

        if (buttonAddUser.AddUserButtonIsDisplayed()) {
            Assert.assertTrue(true);
        } else {
            System.out.println(error);
            ExtentTestManager.getTest().log(Status.INFO, error);
            Assert.fail();
        }
        ExtentTestManager.getTest().log(Status.INFO, test);
    }

    @Test /*C39154*/

    public void AddUserDialogisDisplayed() {

        SignInPage login = new SignInPage(driver);
        TopBarSection profileIcon = new TopBarSection(driver);
        TopBarSection usersOption = new TopBarSection(driver);
        UsersPage buttonAddUser = new UsersPage(driver);
        UsersPage dialog = new UsersPage(driver);


        String error = "On click of Add User button the add user dialog was not shown";
        String test = "Testcase C39154";


        login.LoginGlobalAdmin();

        profileIcon.clickMenuIcon();
        usersOption.clickUsersOption();
        buttonAddUser.clickAddUser();

        if (dialog.AddUserDialogisDisplayed()) {
            Assert.assertTrue(true);
        } else {
            System.out.println(error);
            ExtentTestManager.getTest().log(Status.INFO, error);
            Assert.fail();
        }
        ExtentTestManager.getTest().log(Status.INFO, test);
    }
}