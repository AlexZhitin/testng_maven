package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {



  protected WebDriver driver;

  /*Create elements with locators*/

  private By email = By.xpath("//input[@placeholder='Email']");
  private By password = By.xpath("//input[@placeholder='Password']");
  private By loginButton = By.xpath("//button[@type='submit']");



  public BasePage(WebDriver driver) {
    this.driver = driver;
  }


  public void typeEmail(String useremail){
    System.out.println("Type the email address on the Sign in page");
    driver.findElement(email).sendKeys();

  }

  public void clickSignInBtn() {

    System.out.println("Click on sign in button");
    driver.findElement(loginButton).click();

  }

  public void typePassword(String userpassword){
    System.out.println("Type in the password on the Sign in page");
    driver.findElement(password).sendKeys("12345678");
  }
}