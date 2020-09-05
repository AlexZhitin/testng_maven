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

//test

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


    public void type(WebElement field, String text) {
        try {
            field.sendKeys(text);
        } catch (Throwable e) {
            System.out.println(e);
        }
    }

    public void wait(WebElement element, int seconds) {
        try {
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Throwable e) {
            System.out.println(e);
        }
    }


    @BeforeMethod

    public void SetUp() {

        System.setProperty("webdriver.chrome.driver", "D:\\QA\\Selenium_projects\\testng_maven\\Allure\\src\\main\\resources\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }


    @Test
    public void login() {
        /*wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(fieldUsername));*/
        wait(fieldUsername, 10);
        type(fieldUsername, username);

        wait(fieldPassword, 10);
        fieldPassword.sendKeys(password);

        wait(submit, 10);
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

