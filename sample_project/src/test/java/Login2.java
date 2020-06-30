import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login2 {

    static WebDriver driver;

    @FindBy(xpath = "//*[@name = 'username']")
    WebElement fieldUsername;

    @FindBy(xpath = "//*[@name = 'password']")
    WebElement fieldPassword;

    @FindBy(xpath = "//*[@type = 'submit']")
    WebElement button;

    String username = "bla-bla";
    String password = "bla-bla";
    String url = "http://www.stealmylogin.com/demo.html";
    String expectedURL = "https://example.com/";


    public static class Waiter {

        public static void wait(WebElement element, int time) {
            try {
                WebDriverWait waiter = new WebDriverWait(driver, time);
                waiter.until(ExpectedConditions.visibilityOf(element));

            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }


    @BeforeMethod

    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "D:\\QA\\Selenium_projects\\testng_maven\\Allure\\src\\main\\resources\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        PageFactory.initElements(driver, this);
    }

    @Test

    public void Login() {

        Waiter.wait(fieldUsername, 10);
        fieldUsername.sendKeys(username);

        Waiter.wait(fieldUsername, 10);
        fieldPassword.sendKeys(password);
        button.click();


        for (int i = 0; i < 2; i++) {
            driver.switchTo().alert().accept();
        }

        Assert.assertEquals(expectedURL, driver.getCurrentUrl(), "Test failed");
    }

    @AfterMethod

    public void tearDown() {
        driver.quit();
    }

}
