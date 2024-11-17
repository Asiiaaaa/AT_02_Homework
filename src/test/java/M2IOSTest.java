import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

public class M2IOSTest {
    private IOSDriver driver;
    private IOSDriverFactory driverFactory;

    @Before
    public void setDriver() throws MalformedURLException {
        driverFactory = new IOSDriverFactory();
        driver = driverFactory.setUp();
    }

    @Test
    public void M2Test() throws InterruptedException {
        Thread.sleep(Long.parseLong("5000"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}