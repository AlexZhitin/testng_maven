package Pages;

/*

This class stores all the locators and methods of login page

 */

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;

public class LoginPage {

  WebDriver driver;

  By email = By.name("login");
  By password = By.name("password");
  By loginButton = By.xpath("//button[@type='submit']");


  public LoginPage(WebDriver driver) {

    this.driver = driver;
  }


  public void typeEmail() {

    driver.findElement(email).sendKeys("aszhitin@gmail.com");
  }

  public void typePassword() {

    driver.findElement(password).sendKeys("lenovos820");

  }

  public void clickLogin() {

    driver.findElement(loginButton).click();

  }
}
