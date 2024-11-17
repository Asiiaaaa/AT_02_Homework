import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.IOSMobileCapabilityType.BUNDLE_ID;
import static io.appium.java_client.remote.MobileCapabilityType.*;

public class IOSDriverFactory {

    public static IOSDriver setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability(DEVICE_NAME, "iPhone 12 Pro Max");
        capabilities.setCapability(PLATFORM_VERSION, "14.4");
        capabilities.setCapability(UDID,"6E6ED0AF-003B-400D-B88F-FDDB08A74432");
        capabilities.setCapability(BUNDLE_ID, "com.apple.MobileSMS");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub"); // где находиться аппиум

        return new IOSDriver(remoteUrl, capabilities);

    }
}