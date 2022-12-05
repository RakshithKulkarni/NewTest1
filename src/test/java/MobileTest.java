import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;

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
        capabilities.setCapability("udid", "RF8M41K9B8D");
        try {
            wd = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            wd.findElementById("btnJoin").click();
            Assert.assertFalse("Join button is enabled",wd.findElementById("btnJoin").isEnabled());
            wd.findElementById("edtConfNumber").sendKeys(RandomStringUtils.randomNumeric(9));
            Assert.assertTrue("Join button is disabled",wd.findElementById("btnJoin").isEnabled());
            wd.hideKeyboard();
            if(wd.findElementById("chkNoVideo").getAttribute("checked").equals("false")){
                wd.findElementById("chkNoVideo").click();
            }
            wd.findElementById("btnJoin").click();
            Thread.sleep(10000);
            Assert.assertTrue("Invalid meeting Id message incorrect",wd.findElementById("txtMsg").getText().equals("Invalid meeting ID. Please check and try again."));
            wd.runAppInBackground(Duration.ofMinutes(-1));
            wd.activateApp("us.zoom.videomeetings");

            wd.closeApp();
        } catch (Exception | Error e) {
            throw new RuntimeException(e);
        }

    }
}
