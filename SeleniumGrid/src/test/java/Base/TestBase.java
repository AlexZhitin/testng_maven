package Base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {
    //Declare ThreadLocal Driver (ThreadLocalMap) for ThreadSafe Tests
    public ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    public CapabilityFactory capabilityFactory = new CapabilityFactory();

    @BeforeMethod
    @Parameters({"browser", "appURL", "platform"})
    public void setup(String browser, String appURL, /*String browser_version,*/ String platform) throws MalformedURLException, InterruptedException {
        //Set Browser to ThreadLocalMap
        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilityFactory.getCapabilities(browser, /*browser_version,*/ platform)));

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
            getDriver().manage().window().setSize(new Dimension(1280, 960));
            getDriver().navigate().to(appURL);
            getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        } else {
            getDriver().manage().window().maximize();
            getDriver().navigate().to(appURL);
            getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
    }

    public WebDriver getDriver() {
        //Get driver from ThreadLocalMap
        return driver.get();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        driver.remove();
    }
}