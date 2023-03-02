package qa.ui;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.base.BasePage;
import qa.base.DriverManager;

import java.time.Duration;
import java.util.HashMap;
import java.util.Objects;

import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static io.appium.java_client.remote.MobilePlatform.IOS;

public class DeepLink extends BasePage {

    public DeepLink(AppiumDriver driver) {
        super(driver);
    }

    public void OpenAppWith(String url){

        switch (platformType) {
            case ANDROID -> {
                HashMap<String, String> deepUrl = new HashMap<>();
                deepUrl.put("url", url);
                deepUrl.put("package", "com.swaglabsmobileapp");
                driver.executeScript("mobile: deepLink", deepUrl);
            }
            case IOS -> {
                By urlBtn = AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' && name CONTAINS 'URL'");
                By urlFld = AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeTextField' && name CONTAINS 'URL'");
                By openBtn = AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' && name CONTAINS 'Open'");
                ((IOSDriver) driver).activateApp("com.apple.mobilesafari");
                wait.until(ExpectedConditions.visibilityOfElementLocated(urlBtn)).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(urlFld)).sendKeys("" + url + "\uE007");
                wait.until(ExpectedConditions.visibilityOfElementLocated(openBtn)).click();
            }
        }
    }
}
