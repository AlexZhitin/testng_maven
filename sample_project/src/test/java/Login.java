import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class Login {

    WebDriver driver;
    WebDriverWait wait;


    @FindBy(xpath = "//*[@name='username']")
    WebElement fieldUsername;

    @FindBy(xpath = "//*[@name='password']")
    WebElement fieldPassword;

    @FindBy(xpath = "//*[@value='login']")
    WebElement submit;

    String username = "aaa";
    String password = "aaa";

    String expectedUrl = "https://example.com/";
    String url = "http://www.stealmylogin.com/demo.html";


    @BeforeMethod

    public void SetUp() {
        String driverPath = System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }


    @Test
    public void login() {
        /*wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(fieldUsername));*/

        fieldUsername.sendKeys(username);
        fieldPassword.sendKeys(password);
        submit.click();

        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();


        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Test failed");
    }

    @AfterMethod

    public void tearDown() {
        driver.quit();
    }
}
