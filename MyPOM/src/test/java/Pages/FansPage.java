package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FansPage {

  protected WebDriver driver;

  /*Create elements with locators*/

  private By logo = By.xpath("//div[@class='sidebar-logo']");
  boolean logoElement;


  public FansPage(WebDriver driver) {
    this.driver = driver;
  }

  public boolean logoIsDisplayed() {
    WebElement element = driver.findElement(logo);
    return logoElement = element.isDisplayed();
  }
}