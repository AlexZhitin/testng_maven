package Pages;

import Helper.Utils;
import Helper.Waiters;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
            Waiters.waitVisibilityOfElement(pageTitle, driver);
            return pageTitle.getText();
        } catch (Throwable e) {
            Utils.addErrorToAllureReport(e.toString());
            return null;
        }
    }
}
