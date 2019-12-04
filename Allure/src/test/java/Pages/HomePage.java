package Pages;

import com.aventstack.extentreports.Status;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {

    protected WebDriver driver;

    private By sections = By.xpath("//li[@data-level='1']");


    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    @Step("Select the section \"{0}\" to open")
    public void clickSection(String section) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sections));
            List<WebElement> list = driver.findElements(sections);
            for (WebElement i : list)
                if (i.getAttribute("class").contains(section)) {
                    i.click();
                } else {
                }
        } catch (Throwable e) {
            /*ExtentTestManager.getTest().log(Status.INFO, e);*/
            System.out.println(e);
        }
    }
}
