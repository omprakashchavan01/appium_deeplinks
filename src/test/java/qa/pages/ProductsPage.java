package qa.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.byfactory.ByElementManager;
import qa.byfactory.ByElementManagerFactory;

public class ProductsPage extends BasePage {
    private final ByElementManager byElementManager;

    public ProductsPage(AppiumDriver driver) {
        super(driver);
        byElementManager = ByElementManagerFactory.getByElementManager(platformType);
    }

    public void clickProduct(String title) {
        By productTitle = byElementManager.getXpathUsingTextOrName(title);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(productTitle))).click();
    }
}
