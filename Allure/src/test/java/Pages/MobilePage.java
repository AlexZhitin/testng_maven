package Pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MobilePage {

    protected WebDriver driver;

   /* private By categories = By.xpath("//span[@class='title']");
    private By subcategories = By.xpath("//a[@class='link-blue']");*/
    private By pageTitle = By.xpath("//div[@class='cell-12']/h1");


    public MobilePage(WebDriver driver) {

        this.driver = driver;
    }

    public String getPageTitleText() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
            WebElement title = driver.findElement(pageTitle);
            System.out.println(title.getText());
            return title.getText();
        } catch (Throwable e) {
            /*ExtentTestManager.getTest().log(Status.INFO, e);*/
            System.out.println(e);
            return null;
        }
    }
}
