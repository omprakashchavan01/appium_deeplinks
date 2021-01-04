package qa.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.json.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;
import qa.utils.JsonParser;

import java.net.URL;

public class DriverManager {
    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public static AppiumDriver getDriver(){
        return driver.get();
    }

    public static void setDriver(AppiumDriver driver1){
        driver.set(driver1);
    }

    public static void initializeDriver(String platformName) throws Exception {
        AppiumDriver driver;
        JSONObject deviceObj = new JSONObject(JsonParser.parse("Devices.json").getJSONObject(platformName).toString());
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", platformName);
        caps.setCapability("udid", deviceObj.getString("udid"));
        caps.setCapability("app", System.getProperty("user.dir") + deviceObj.getString("app_url"));
        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        switch(platformName) {
            case "Android":
                caps.setCapability("appPackage", deviceObj.getString("appPackage"));
                caps.setCapability("appActivity", deviceObj.getString("appActivity"));
                driver = new AndroidDriver(url, caps);
                break;
            case "iOS":
                caps.setCapability("deviceName", deviceObj.getString("device"));
                caps.setCapability("automationName", "XCUITest");
                driver = new IOSDriver(url, caps);
                break;
            default:
                throw new Exception("Invalid platform! - " + platformName);
        }
        setDriver(driver);
    }
}
