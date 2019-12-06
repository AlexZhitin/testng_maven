package Pages;

import Base.AllureTestListener;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {

    @FindBy (xpath = "//li[@data-level='1']")
    List<WebElement> sections;

    protected WebDriver driver;


    public HomePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Select the section \"{0}\" to open")
    public void clickSection(String section) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfAllElements(sections));
            for (WebElement i : sections)
                if (i.getAttribute("class").contains(section)) {
                    i.click();
                } else {
                }
        } catch (Throwable e) {
            AllureTestListener.saveTextLog(e.toString());
            System.out.println(e);
        }
    }
}
