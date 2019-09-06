package Base;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariOptions;

public class OptionsManager {

    //Get Chrome Options
    public static ChromeOptions getChromeOptions(String browser_version, String platform, String browser) {
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
        /*options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");*/
        //options.addArguments("--incognito");
        return options;
    }

    //Get Firefox Options
    public static FirefoxOptions getFirefoxOptions(String browser_version, String platform, String browser) {
        FirefoxOptions options = new FirefoxOptions();
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

    public static SafariOptions getSafariOptions(String browser_version, String platform, String browser) {
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
