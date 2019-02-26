package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBase {

  private WebDriver driver;

  public WebDriver getDriver() {
    return driver;
  }

  private void setDriver(String browserType, String appURL) {
    switch (browserType) {
      case "chrome":
        driver = initChromeDriver(appURL);
        break;
      case "firefox":
        driver = initFirefoxDriver(appURL);
        break;
      default:
        System.out.println("browser: " + browserType + " is invalid. Launching Chrome as browser of choice..");
        driver = initChromeDriver(appURL);

    }

  }

  private WebDriver initChromeDriver(String appURL) {
    System.out.println("Launching google chrome with new profile..");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.navigate().to(appURL);
    return driver;
  }


  private WebDriver initFirefoxDriver(String appURL) {
    System.out.println("Launching Firefox browser..");
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.navigate().to(appURL);
    return driver;
  }

  @Parameters({"browserType", "appURL"})
  @BeforeClass
  public void initializeTestBaseSetup(String browserType, String appURL) {
    try {
      setDriver(browserType, appURL);

    } catch (Exception e) {
      System.out.println("Error....." + e.getStackTrace());
    }
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }
}