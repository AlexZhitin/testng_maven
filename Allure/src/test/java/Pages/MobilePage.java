package Pages;

import Base.AllureTestListener;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MobilePage {

    @FindBy(xpath = "//h1")
    WebElement pageTitle;

    protected WebDriver driver;

    public MobilePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Getting page title")
    public String getPageTitleText() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfAllElements(pageTitle));
            System.out.println(pageTitle.getText());
            return pageTitle.getText();
        } catch (Throwable e) {
            AllureTestListener.saveTextLog(e.toString());
            System.out.println(e);
            return null;
        }
    }
}
