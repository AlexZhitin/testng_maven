package Base;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilityFactory {
    public Capabilities capabilities;

    public Capabilities getCapabilities (String browser) {
        if (browser.equals("chrome"))
            capabilities = OptionsManager.getChromeOptions();
        if (browser.equals("firefox"))
            capabilities = OptionsManager.getFirefoxOptions();
        return capabilities;
    }
}
