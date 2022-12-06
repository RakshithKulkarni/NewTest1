import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

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

    @Test
    public void sample2() {
        AppiumDriver wd;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("ignoreUnimportantViews", false);
        capabilities.setCapability("noSign", true);
        capabilities.setCapability("intentAction", "android.intent.action.VIEW");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("appPackage", "com.linkedin.android");
        capabilities.setCapability("appActivity", ".authenticator.LaunchActivity");
        capabilities.setCapability("udid", "RF8M41K9B8D");
        try {
            wd = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            wd.findElementById("growth_prereg_fragment_login_button").click();
            Thread.sleep(5000);
            wd.findElementById("growth_login_join_fragment_email_address").sendKeys("mytestuser517@gmail.com");
            wd.findElementById("growth_login_join_fragment_password").sendKeys("Password");
            wd.findElementById("growth_login_fragment_sign_in").click();
            Thread.sleep(5000);
            wd.findElementById("search_bar_text").click();
            wd.findElementById("search_bar_edit_text").sendKeys("CallSign");
            Assert.assertTrue("See all results button not displayed",wd.findElementById("search_typeahead_see_all_button").getText().equals("See all results"));
            List<WebElement> elementList = wd.findElementsById("search_typeahead_entity_text");
            for(WebElement element : elementList){
                Assert.assertTrue("Results does not have Callsign text",element.getText().equalsIgnoreCase("Callsign"));
            }
            wd.navigate().back();
            wd.navigate().back();
            wd.findElementById("ad_notification_badge_icon").click();
            wd.findElementById("conversation_filter_lever_image").click();
            wd.findElementById("filter_connection_lever_btn").click();
            wd.navigate().back();
            wd.navigate().back();
            wd.findElementById("me_launcher").click();
            wd.findElementById("home_nav_premium_upsell_text_view").click();
            JavascriptExecutor js = (JavascriptExecutor) wd;
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("elementId",((RemoteWebElement)wd.findElement(By.xpath("//android.webkit.WebView"))).getId());
            scrollObject.put("direction", "down");
            scrollObject.put("percent", "1");
            js.executeScript("mobile: scrollGesture", scrollObject);

            wd.closeApp();
        } catch (Exception | Error e) {
            throw new RuntimeException(e);
        }
    }
}
