package qa.base;

import io.appium.java_client.AppiumDriver;
import org.json.JSONObject;
import org.testng.annotations.*;
import qa.utils.JsonParser;
import qa.utils.StringParser;

import java.util.HashMap;

import static qa.base.Config.getPlatformType;

public class BaseTest {
    public static HashMap<String, String> strings = new HashMap<>();
    public static JSONObject loginUsers;
    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public static AppiumDriver getDriver() {
        return driver.get();
    }

    private static void setDriver(AppiumDriver driver) {
        BaseTest.driver.set(driver);
    }

    @Parameters({"platformType"})
    @BeforeTest
    public void setUp(@Optional String platformType) throws Exception {
        if(platformType == null){
            setDriver(DriverManager.initializeDriver(getPlatformType()));
        } else {
            setDriver(DriverManager.initializeDriver(platformType));
        }

        strings = StringParser.parseStringXML("strings.xml");
        loginUsers = JsonParser.parse("loginUsers.json");
    }

    @AfterTest()
    public void quit() {
        getDriver().quit();
    }
}
