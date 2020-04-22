package Base;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

public class CapabilityFactory {
    public Capabilities capabilities;

    public Capabilities getCapabilities(String platform, String browser, String version) {
        if (browser.equals("chrome"))
            capabilities = getChromeOptions(platform, browser, version);
        if (browser.equals("firefox"))
            capabilities = getFirefoxOptions(platform, browser, version);
        if (browser.equals("safari"))
            capabilities = getSafariOptions(platform, browser);
        if (browser.equals("MicrosoftEdge"))
            capabilities = getEdgeOptions(platform, browser);
        return capabilities;
    }

    //Get Chrome Options
    public ChromeOptions getChromeOptions(String platform, String browser, String version) {
        ChromeOptions options = new ChromeOptions();

        options.setCapability("platform", platform);
        options.setCapability("browser", browser);
        options.setCapability("version", version);
        options.setCapability("enableVNC", true);
        options.setCapability("enableVideo", false); //enables video recording



        /*cap.setCapability("os_version", "10");
        cap.setCapability("resolution", "1024x768");
        cap.setCapability("name", "Bstack-[Java] Sample Test");*/
            /*options.addArguments("--start-maximized");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-popup-blocking");*/
        //options.addArguments("--incognito");
        return options;
    }

    //Get Firefox Options
    public FirefoxOptions getFirefoxOptions(String platform, String browser, String version) {

        FirefoxOptions options = new FirefoxOptions();


        /*System.setProperty("webdriver.gecko.driver", "/Users/Sasha/Documents/Selenium_projects/testng_maven/SeleniumGrid/src/main/resources/geckodriver");*/

        options.setCapability("platform", platform);
        options.setCapability("browserName", browser);
        options.setCapability("version", version);
        options.setCapability("enableVNC", true);
        options.setCapability("enableVideo", false);
        /*options.addArguments("--start-maximized");*/


        /*FirefoxProfile profile = new FirefoxProfile();
        //Accept Untrusted Certificates
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        //Use No Proxy Settings
        profile.setPreference("network.proxy.type", 0);
        //Set Firefox profile to capabilities
        options.setCapability(FirefoxDriver.PROFILE, profile);*/
        return options;
    }

    public SafariOptions getSafariOptions(String platform, String browser) {
        SafariOptions options = new SafariOptions();
        /*options.setCapability("browserVersion", browser_version);*/
        options.setCapability("platformName", platform);
        options.setCapability("browserName", browser);
        /*FirefoxProfile profile = new FirefoxProfile();
        //Accept Untrusted Certificates
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        //Use No Proxy Settings
        profile.setPreference("network.proxy.type", 0);
        //Set Firefox profile to capabilities
        options.setCapability(FirefoxDriver.PROFILE, profile);*/
        return options;
    }

    public EdgeOptions getEdgeOptions( String platform, String browser) {
        EdgeOptions options = new EdgeOptions();
        /*options.setCapability("browserVersion", browser_version);*/
        options.setCapability("platformName", platform);
        options.setCapability("browserName", browser);
        return options;
    }
}
