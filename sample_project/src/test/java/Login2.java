import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login2 {

    WebDriver driver;

    @FindBy(xpath = "//*[@name='username']")
    WebElement fieldUsername;

    @FindBy(name = "password")
    WebElement fieldPassword;

    @FindBy(xpath ="//*[@type='submit']")
    WebElement button;


    String username = "aaa";
    String password = "bbb";

    String URL = "http://www.stealmylogin.com/demo.html";
    String expectedURL = "https://example.com/";


    @BeforeMethod

    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "D:\\QA\\Selenium_projects\\testng_maven\\Allure\\src\\main\\resources\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    @Test

    public void login(){

        fieldUsername.sendKeys(username);
        fieldPassword.sendKeys(password);
        button.click();

        int a = 0;

        while (a<2){
            driver.switchTo().alert().accept();
            a++;
        }

        Assert.assertEquals(expectedURL, driver.getCurrentUrl(), "Failed");

    }

    @AfterMethod

    public void tearDown(){
        driver.quit();
    }
}
