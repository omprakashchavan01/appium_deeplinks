package qa.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static qa.base.Config.getPlatformType;

public class BasePage {
    protected final AppiumDriver driver;
    protected final WebDriverWait wait;
    protected final String platformType;

    public BasePage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        platformType = getPlatformType();
    }
}
