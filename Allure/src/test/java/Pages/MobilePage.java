package Pages;

import Base.AllureTestListener;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.commons.lang.exception.ExceptionUtils;
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
    private By pageTitle = By.xpath("//h1");


    public MobilePage(WebDriver driver) {

        this.driver = driver;
    }

    @Step("Getting page title")
    public String getPageTitleText() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
            WebElement title = driver.findElement(pageTitle);
            System.out.println(title.getText());
            return title.getText();
        } catch (Throwable e) {
            AllureTestListener.saveTextLog(e.toString());
            System.out.println(e);
            return null;
        }
    }
}
