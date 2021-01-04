package qa.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.base.DriverManager;

import java.util.HashMap;
import java.util.Objects;

public class DeepLink {

    public static void OpenAppWith(String url){
        AppiumDriver driver = DriverManager.getDriver();

        switch(Objects.requireNonNull(driver.getPlatformName())){
            case "android":
                HashMap<String, String> deepUrl = new HashMap<>();
                deepUrl.put("url", url);
                deepUrl.put("package", "com.swaglabsmobileapp");
                driver.executeScript("mobile: deepLink", deepUrl);
                break;
            case "ios":
                By urlBtn = MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' && name CONTAINS 'URL'");
                By urlFld = MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeTextField' && name CONTAINS 'URL'");
                By openBtn = MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' && name CONTAINS 'Open'");
                driver.activateApp("com.apple.mobilesafari");
                WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.visibilityOfElementLocated(urlBtn)).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(urlFld)).sendKeys("" + url + "\uE007");
                wait.until(ExpectedConditions.visibilityOfElementLocated(openBtn)).click();
                break;
        }
    }
}
