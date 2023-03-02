package qa.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.json.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;
import qa.utils.JsonParser;

import java.net.URL;

import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static io.appium.java_client.remote.MobilePlatform.IOS;

public class DriverManager {

    public static AppiumDriver initializeDriver(String platformName) throws Exception {
        JSONObject deviceObj = new JSONObject(JsonParser.parse("Devices.json").getJSONObject(platformName).toString());
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", platformName);
        caps.setCapability("udid", deviceObj.getString("udid"));
        caps.setCapability("app", System.getProperty("user.dir") + deviceObj.getString("app_url"));
        URL url = new URL("http://127.0.0.1:4723");

        switch (platformName) {
            case ANDROID -> {
                caps.setCapability("automationName", "UiAutomator2");
                caps.setCapability("appPackage", deviceObj.getString("appPackage"));
                caps.setCapability("appActivity", deviceObj.getString("appActivity"));
                return new AndroidDriver(url, caps);
            }
            case IOS -> {
                caps.setCapability("deviceName", deviceObj.getString("device"));
                caps.setCapability("automationName", "XCUITest");
                return new IOSDriver(url, caps);
            }
            default -> throw new Exception("Invalid platform! - " + platformName);
        }
    }
}
