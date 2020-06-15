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

public class CheckBoxWithStream {

    WebDriver driver;

    @FindBy(xpath = "//td[contains(@class, 'select-checkbox')]")
    List<WebElement> checkBoxList;

    String url = "https://datatables.net/extensions/select/examples/initialisation/checkbox.html";

    @BeforeMethod

    public void SetUp() {

        System.setProperty("webdriver.chrome.driver", "D:\\QA\\Selenium_projects\\testng_maven\\Allure\\src\\main\\resources\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    @Test

    public void Checkbox() {

        checkBoxList.stream().forEach(e -> e.click()); // select every checkbox
    }

    @AfterMethod

    public void tearDown() {
        driver.quit();
    }
}
