package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {



  protected WebDriver driver;
  private By signInButton = By.xpath("//button[@type='submit']");

  public BasePage(WebDriver driver) {
    this.driver = driver;
  }

  public SignInPage clickSignInBtn() {

    System.out.println("Click on sign in button");
    WebElement signInBtnElement = driver.findElement(signInButton);
    if (signInBtnElement.isDisplayed() || signInBtnElement.isEnabled())
      signInBtnElement.click();
    else
      System.out.println("Element not found");
    return new SignInPage(driver);

  }
}