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

import java.util.List;

public class Collection {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//nav[@id='nav_references']//a")
    List<WebElement> items;

    @FindBy(xpath = "//a[@id='navbtn_references']")
    WebElement tab;

    String java = "Java Reference";

    String url = "https://www.w3schools.com/";
    String expectedUrl = "https://www.w3schools.com/java/java_ref_keywords.asp";

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

    public void Test() throws InterruptedException {

        wait = new WebDriverWait(driver, 5);

        tab.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(items));


        try {
            for (WebElement i : items)
                if (i.getText().equals(java)) {
                    i.click();
                } else {
                }
        } catch (Throwable e) {
            System.out.println(e);
        }
            Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Failed");

        }


        @Test
    public void Test2() throws InterruptedException {

        wait = new WebDriverWait(driver, 5);

        tab.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(items));

            for (WebElement i : items){
                System.out.println(i);
            }
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Failed");

    }


    @AfterMethod

    public void tearDown(){
        driver.quit();
    }
}

