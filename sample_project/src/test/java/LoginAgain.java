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

public class LoginAgain {

    WebDriver driver;

    @FindBy(xpath = "//*[@name ='username']")
    WebElement fieldUsername;

    @FindBy(xpath = "//*[@name ='password']")
    WebElement fieldPassword;

    @FindBy(xpath = "//*[@value ='login']")
    WebElement button;


    String username = "aaa";
    String password = "bbb";
    String url = "http://www.stealmylogin.com/demo.html";
    String expectedURL = "https://example.com/";

    @BeforeMethod

    public void setUp(){

        String driverPath = "D:\\QA\\Selenium_projects\\testng_maven\\sample_project\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }


    @Test
    public void login(){

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(fieldUsername));
        fieldUsername.sendKeys(username);
        fieldPassword.sendKeys(password);
        button.click();

        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Didn't login");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
