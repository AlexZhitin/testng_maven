package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {

  private WebDriver driver;
  private By profileLocation = By.xpath("//div[@class='block-short-info']//div[@class='title'][contains(text(),'Location')]");

  public ProfilePage(WebDriver driver) {
    this.driver = driver;
  }

  public String getPageTitle() {
    String title = driver.getTitle();
    return title;
  }

  public boolean verifyPageTitle() {
    String pageTitle = "Profile";
    return getPageTitle().contains(pageTitle);
  }

  public boolean verifyprofileLocationText() {
    WebElement element = driver.findElement(profileLocation);
    String profileLocationText = "Location";
    return element.getText().contains(profileLocationText);
  }

  public void clickEdit() {
    // need to write steps for creating an account
  }
}