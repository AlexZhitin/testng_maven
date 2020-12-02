/*
package Stream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WindowHandlerStream {

    WebDriver driver;

    @FindBy(xpath = "//a[@class='black']")
    WebElement link;

    String url = "http://popuptest.com/goodpopups.html";

    @BeforeMethod

    public void SetUp() {

        System.setProperty("webdriver.chrome.driver", "D:\\QA\\Selenium_projects\\testng_maven\\Allure\\src\\main\\resources\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    @Test

    public void windowHandler() {

        link.click();

        String title = switchToWindowTest(driver);
        System.out.println(title);

    }

    @AfterMethod

    public void tearDown() {
        driver.quit();
    }


    public static String switchToWindowTest(WebDriver driver) {
        return driver.getWindowHandles()
                .stream()
                .map(handler -> driver.switchTo().window(handler).getTitle())
                .findFirst()
                .orElseThrow(() -> {
                    throw new RuntimeException("No Such Window");
                });
    }
}
*/
