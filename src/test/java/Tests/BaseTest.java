package Tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class BaseTest {

    public AppiumDriver driver;

    public AndroidDriver androidDriver;

    public WebDriverWait wait;

    public WebDriverWait getWait() {

        return wait;
    }

    @Before
    public void beforeTest() throws Exception {
        final DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Android SKD built for x86");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appActivity", "com.google.android.apps.nexuslauncher.NexusLauncherActivity");
        capabilities.setCapability("appPackage", "com.google.android.apps.nexuslauncher");
        capabilities.setCapability("unlockDevice", true);
        capabilities.setCapability("autoAcceptAlerts", true);

        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        androidDriver = new AndroidDriver(url, capabilities);
    }
    @After
    public void afterTest() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
