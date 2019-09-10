package Base;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariOptions;

public class CapabilityFactory {
    public Capabilities capabilities;
    public DesiredCapabilities caps;

    public Capabilities getCapabilities (String browser, String browser_version, String platform) {
        if (browser.equals("chrome"))
            capabilities = getChromeOptions(browser_version, platform, browser);
        if (browser.equals("firefox"))
            capabilities = getFirefoxOptions(browser_version, platform, browser);
        if (browser.equals("safari"))
            capabilities = getSafariOptions(browser_version, platform, browser);
        return capabilities;
    }

        //Get Chrome Options
        public ChromeOptions getChromeOptions(String browser_version, String platform, String browser) {
            ChromeOptions options = new ChromeOptions();
        /*DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability("browser_version", browser_version);
        cap.setCapability("os", platform);
        options.merge(cap);*/
            options.setCapability("browserVersion", browser_version);
            options.setCapability("platformName", platform);
            options.setCapability("browserName", browser);

        /*cap.setCapability("os_version", "10");
        cap.setCapability("resolution", "1024x768");
        cap.setCapability("name", "Bstack-[Java] Sample Test");*/
            options.addArguments("--start-maximized");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-popup-blocking");
            //options.addArguments("--incognito");
            return options;
        }

        //Get Firefox Options
        public FirefoxOptions getFirefoxOptions(String browser_version, String platform, String browser) {

            FirefoxOptions options = new FirefoxOptions();


            /*System.setProperty("webdriver.gecko.driver", "/Users/Sasha/Documents/Selenium_projects/testng_maven/SeleniumGrid/src/main/resources/geckodriver");*/
            options.setCapability("browserVersion", browser_version);
            options.setCapability("platformName", platform);
            options.setCapability("browserName", browser);
        /*DesiredCapabilities cap = DesiredCapabilities.firefox();
        cap.setCapability("browser_version", browser_version);
        cap.setCapability("os", platform);
        options.merge(cap);*/
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

        public SafariOptions getSafariOptions(String browser_version, String platform, String browser) {
            SafariOptions options = new SafariOptions();
            options.setCapability("browserVersion", browser_version);
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
    }
