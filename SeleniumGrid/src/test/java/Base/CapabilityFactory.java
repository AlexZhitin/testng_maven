package Base;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilityFactory {
    public Capabilities capabilities;

    public Capabilities getCapabilities (String browser, String browser_version, String platform) {
        if (browser.equals("chrome"))
            capabilities = OptionsManager.getChromeOptions(browser_version, platform, browser);
        if (browser.equals("firefox"))
            capabilities = OptionsManager.getFirefoxOptions(browser_version, platform, browser);
        if (browser.equals("safari"))
            capabilities = OptionsManager.getSafariOptions(browser_version, platform, browser);
        return capabilities;
    }
}
