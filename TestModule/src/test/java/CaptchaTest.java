import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CaptchaTest {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/Sasha/Documents/Selenium_projects/testng_maven/TestModule/src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://www.google.com/recaptcha/api2/demo";

        driver.navigate().to(baseUrl);
        Thread.sleep(3000);
        driver.switchTo().frame(0);
        WebElement captcha = driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]"));
        captcha.click();
        Thread.sleep(3000);

        if (captcha.isSelected()){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
    }
}
