package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

  private WebDriver driver;



  private By headerPageText = By.xpath("//div[@class='login__header title']");
  private By emailTextBox = By.xpath("//input[@placeholder='Email']");
  private By passwordTextBox = By.xpath("//input[@placeholder='Password']");
  private By loginBtn = By.xpath("//button[@type='submit']");
  private By errorMsgTxt = By.xpath("//div[@class='login__error']");

  public SignInPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getSignInPageTitle() {
    String pageTitle = driver.getTitle();
    return pageTitle;
  }

  public boolean verifySignInPageTitle() {
    String expectedTitle = "Login";
    return getSignInPageTitle().contains(expectedTitle);
  }

  public boolean verifySignInPageText() {
    WebElement element = driver.findElement(headerPageText);
    String pageText = element.getText();
    String expectedPageText = "Login";
    return pageText.contains(expectedPageText);
  }

  public boolean verifySignIn() {
    enterUserName("//div[@class='login__error']");
    enterPassword("12345678");
    clickOnSignIn();
    return getErrorMessage().contains("Invalid email or password");
  }

  public void enterUserName(String userName) {
    WebElement emailTxtBox = driver.findElement(emailTextBox);
    if (emailTxtBox.isDisplayed())
      emailTxtBox.sendKeys(userName);
  }

  public void enterPassword(String password) {
    WebElement passwordTxtBox = driver.findElement(passwordTextBox);
    if (passwordTxtBox.isDisplayed())
      passwordTxtBox.sendKeys(password);
  }

  public void clickOnSignIn() {
    WebElement signInBtn = driver.findElement(loginBtn);
    if (signInBtn.isDisplayed())
      signInBtn.click();
  }

  public String getErrorMessage() {
    String strErrorMsg = null;
    WebElement errorMsg = driver.findElement(errorMsgTxt);
    if (errorMsg.isDisplayed() && errorMsg.isEnabled())
      strErrorMsg = errorMsg.getText();
    return strErrorMsg;
  }
}