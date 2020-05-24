import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginAgain {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//*[@name ='username']")
    WebElement fieldUsername;

    @FindBy(xpath = "//*[@name ='password']")
    WebElement fieldPassword;

    @FindBy(xpath = "//*[@value ='login']")
    WebElement button;

    String url = "http://www.stealmylogin.com/demo.html";
    String expectedURL = "https://example.com/";
    String username = "aaa";
    String password = "bbb";
    String driverPath = "D:\\QA\\Selenium_projects\\testng_maven\\Allure\\src\\main\\resources\\chromedriver.exe";

    @BeforeMethod

    public void SetUp() {

        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        PageFactory.initElements(driver, this);
    }

    @Test

    public void login() {
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElements(fieldUsername, fieldPassword, button));

        fieldUsername.sendKeys(username);
        fieldPassword.sendKeys(password);
        button.click();

        int a = 0;
        while (a < 2) {
            driver.switchTo().alert().accept();
            a++;
        }

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Didn't login");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
