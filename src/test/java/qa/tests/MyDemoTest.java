package qa.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.pages.ProductsPage;

public class MyDemoTest extends BaseTest {

    @Test
    public void shouldBeAbleToPlaceAnOrder() {
        getDriver().findElement(AppiumBy.xpath())
        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage.clickProduct("Sauce Labs Backpack");
    }
}
