package Stream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LinksWithStream {

    WebDriver driver;

    @FindBy(xpath = "//footer//li")
    List<WebElement> footerList;

    String url = "https://www.freshworks.com/";

    @BeforeMethod

    public void SetUp() {

        System.setProperty("webdriver.chrome.driver", "D:\\QA\\Selenium_projects\\testng_maven\\Allure\\src\\main\\resources\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    @Test

    public void links() {

        List<String> newFooterList= new ArrayList<>();

        footerList.stream()
                .forEach(e -> newFooterList.add(e.getText())); //filters can be added here as well

        newFooterList.stream().forEach(e -> System.out.println(e));


    }

    @AfterMethod

    public void tearDown() {
        driver.quit();
    }
}
