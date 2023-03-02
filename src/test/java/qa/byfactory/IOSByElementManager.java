package qa.byfactory;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class IOSByElementManager implements ByElementManager {
    @Override
    public By getXpathUsingTextOrName(String textOrName) {
        return AppiumBy.xpath("//XCUIElementTypeOther[@name=\"" + textOrName + "\"]");
    }
}
