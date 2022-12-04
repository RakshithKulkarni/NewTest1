import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileTest {

    @Test
    public void sample1() {
        AppiumDriver wd;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("ignoreUnimportantViews", false);
        capabilities.setCapability("noSign", true);
        capabilities.setCapability("intentAction", "android.intent.action.VIEW");
        capabilities.setCapability("noSign", false);
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("appPackage", "us.zoom.videomeetings");
        capabilities.setCapability("appActivity", "com.zipow.videobox.LauncherActivity");
        capabilities.setCapability("udid", "4544305030423498");
        try {
            wd = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            wd.findElementById("btnJoin").click();
        } catch (
                MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}
