package Base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class TestBase {

    WebDriver webdriver;

    public ThreadLocal<WebDriver> driverLocal = new ThreadLocal<>();

    private String osname = System.getProperty("os.name");
    private static String driverPath = System.getProperty("user.dir") + "/src/main/resources/";


    private void setDriver(String browserType, String appURL) {
        switch (browserType) {
            case "chrome":
                webdriver = initChromeDriver(appURL);
                break;
            case "firefox":
                webdriver = initFirefoxDriver(appURL);
                break;
            case "safari":
                webdriver = initSafariDriver(appURL);
                break;
            default:
                System.out.println("browser: " + browserType + " is invalid. Launching Chrome as browser of choice..");
                webdriver = initChromeDriver(appURL);
        }
    }

    private WebDriver initChromeDriver(String appURL) {
        System.out.println("Launching Chrome browser..");
        if (osname.startsWith("Mac OS X")) {
            System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver");
        } else if (osname.startsWith("Windows")) {
            System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions"); // to disable extension
        options.addArguments("--disable-notifications"); // to disable notification
        options.addArguments("--disable-application-cache"); // to disable cache
        WebDriver driver = new ChromeDriver(options);
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
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(new FirefoxProfile());
        options.addPreference("dom.webnotifications.enabled", false);
        WebDriver driver = new FirefoxDriver(options);
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

    @BeforeMethod
    @Parameters({"local", "browser", "appURL", "platform", "version"})
    public void LocalOrRemote (String local, String browser, String appURL, String platform, String version) throws MalformedURLException, InterruptedException {
        if (local.equals("true")){
            initializeTestBaseSetup(browser, appURL);
        } else {
            setup(local, browser, appURL, platform, version);
        }
    }


    @Parameters({"browser", "appURL"})
    public void initializeTestBaseSetup(String browser, String appURL) {
        try {
            setDriver(browser, appURL);
        } catch (Exception e) {
            System.out.println("Error....." + e.getStackTrace());
        }
    }

    public void setWebDriver(WebDriver driver) {
        driverLocal.set(driver);
    }



    //Next part is for grid

    public ThreadLocal<RemoteWebDriver> driverRemote = new ThreadLocal<>();
    public CapabilityFactory capabilityFactory = new CapabilityFactory();


    public void setup(String local, String browser, String appURL, String platform, String version) throws MalformedURLException, InterruptedException {
        //Set Browser to ThreadLocalMap
        driverRemote.set(new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), capabilityFactory.getCapabilities(platform, browser, version)));

        /*getDriver().manage().window().maximize();*/
       /* Toolkit toolkit = Toolkit.getDefaultToolkit();
        int width = (int) toolkit.getScreenSize().getWidth();
        int height = (int) toolkit.getScreenSize().getHeight();
        getDriver().manage().window().setSize(new Dimension(width, height));*/

        Toolkit toolkit;
        if (browser.equals("chrome")) {
            toolkit = Toolkit.getDefaultToolkit();
            /*int width = (int) toolkit.getScreenSize().getWidth();
            int height = (int) toolkit.getScreenSize().getHeight();*/
            getDriver(local).manage().window().setSize(new Dimension(1280, 960));
            getDriver(local).navigate().to(appURL);
            getDriver(local).manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else {
            getDriver(local).manage().window().maximize();
            getDriver(local).navigate().to(appURL);
            getDriver(local).manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }


    //Get driver from ThreadLocalMap

    @Parameters({"local"})
    public WebDriver getDriver(String local) {
        if (local.equals("true")) {
            return driverLocal.get();
        } else {
            return driverRemote.get();
        }
    }

    @Parameters({"local"})
    @AfterMethod
    public void tearDown(String local) {
        if (local.equals("true")) {
            getDriver(local).quit();
            driverLocal.set(null);
        } else {
            getDriver(local).quit();
            driverRemote.remove();
        }
    }
}