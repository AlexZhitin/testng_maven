import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestNGListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseClass implements ITestNGListener {

    public static ThreadLocal<WebDriver> dr = new ThreadLocal<>();
    private WebDriver driver;
    private String osname = System.getProperty("os.name");
    private static String driverPath = System.getProperty("user.dir") + "/src/main/resources/";

    public WebDriver getDriver() {
        return dr.get();
    }

    private void setDriver(String browserType, String appURL) {
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver(appURL);
                break;
            case "firefox":
                driver = initFirefoxDriver(appURL);
                break;
            case "safari":
                driver = initSafariDriver(appURL);
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
        setWebDriver(driver);
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
        setWebDriver(driver);
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    private WebDriver initSafariDriver(String appURL) {
        System.out.println("Launching Safari browser..");
        WebDriver driver = new SafariDriver();
        setWebDriver(driver);
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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

    public void setWebDriver(WebDriver driver){
        dr.set(driver);
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        dr.set(null);
    }
}

