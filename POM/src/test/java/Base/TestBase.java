package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class TestBase {

  private WebDriver driver;
  private String osname = System.getProperty("os.name");
  private static String driverPath = System.getProperty("user.dir") + "/src/main/resources/";

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
    if (osname.startsWith("Mac OS X")) {
      System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver");
    } else if (osname.startsWith("Windows")) {
      System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
    }
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.navigate().to(appURL);
    return driver;
  }


  private WebDriver initFirefoxDriver(String appURL) {
    System.out.println("Launching Firefox browser..");
    if (osname.startsWith("Mac OS X")) {
      System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver");
    } else if (osname.startsWith("Windows")) {
      System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
    }
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.navigate().to(appURL);
    return driver;
  }

  @Parameters({"browserType", "appURL"})
  @BeforeMethod
  public void initializeTestBaseSetup(String browserType, String appURL) {
    try {
      setDriver(browserType, appURL);

    } catch (Exception e) {
      System.out.println("Error....." + e.getStackTrace());
    }
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}
