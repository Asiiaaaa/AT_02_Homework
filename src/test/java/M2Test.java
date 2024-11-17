import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.After;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

public class M2Test {
    private AndroidDriver driver;
    private DriverFactory driverFactory;

    @Before
    public void setDriver() throws MalformedURLException {
        driverFactory = new DriverFactory();
        driver = DriverFactory.setUp();
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