package Pages;

import Helper.Utils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    protected WebDriver driver;

    @FindBy(xpath = "//input[@name='login']")
    WebElement inputEmail;

    @FindBy(xpath = "//input[@name='password']")
    WebElement inputPassword;

    @FindBy(xpath = "//input[@data-id='verification']")
    WebElement Submit;

    @FindBy(xpath = "//div[@class='errors']")
    WebElement Error;

    @FindBy(xpath = "//div[@class='item-error']")
    WebElement ErrorMessage;


    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Put in the email")
    public void typeEmail(String email) {
        Utils.input(inputEmail, 10, driver, email);
    }

    @Step("Put in the password")
    public void typePassword(String password) {
        Utils.input(inputPassword, 10, driver, password);
    }

    @Step("Click submit")
    public void clickSubmit() {
        Utils.clickElement(Submit, 10, driver);
    }

    @Step("Check if error pop-up is displayed")
    public boolean errorDisplayed() {
        return Utils.elementIsDisplayed(Error, 10, driver);
    }

    @Step("Check if error message is displayed")
    public boolean errorMessageDisplayed() {
        return Utils.elementIsDisplayed(ErrorMessage, 10, driver);
    }
}

