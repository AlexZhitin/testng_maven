package Tests;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @Test

    public void validLogin() {

        LoginPage login = new LoginPage(driver);
        login.LoginToBlaBlaCar("aszhitin@gmail.com", "lenovos820");
    }

}
