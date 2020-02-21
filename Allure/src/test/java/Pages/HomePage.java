package Pages;

import Helper.Utils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    @FindBy(xpath = "//li[@data-level='1']")
    List<WebElement> sections;

    @FindBy(xpath = "//*[@class='item-login']//a")
    WebElement profile;

    protected WebDriver driver;

    public HomePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Select the section \"{0}\" to open")
    public void clickSection(String sectionName) {
        Utils.clickElementByClassAttribute(sections, sectionName, 10, driver);
    }

    @Step("Check if profile is displayed on the home page")
    public boolean profileIsDisplayed() {
        return Utils.elementIsDisplayed(profile, 5, driver);
    }
}