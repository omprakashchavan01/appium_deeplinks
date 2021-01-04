package qa.base;

import org.json.JSONObject;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import qa.utils.JsonParser;
import qa.utils.StringParser;

import java.util.HashMap;

public class BaseTest {
    public static HashMap<String, String> strings = new HashMap<>();
    public static JSONObject loginUsers;

    @Parameters({"platformName"})
    @BeforeTest
    public void beforeTest(String platformName) throws Exception {
        DriverManager.initializeDriver(platformName);
        strings = StringParser.parseStringXML("strings.xml");
        loginUsers = JsonParser.parse("loginUsers.json");
    }

    @AfterTest(alwaysRun = true)
    public void quit() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
        }
    }
}
