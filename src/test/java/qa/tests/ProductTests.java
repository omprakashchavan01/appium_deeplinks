package qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import qa.base.BaseTest;
import qa.base.DriverManager;
import qa.pages.LoginPage;
import qa.pages.ProductDetailsPage;
import qa.pages.ProductsPage;
import qa.ui.DeepLink;

public class ProductTests extends BaseTest {

    @Test
    public void validateProductOnProductsPage() {
        SoftAssert sa = new SoftAssert();
/*        ProductsPage productsPage = new LoginPage().login(loginUsers.getJSONObject("validUser").getString("username")
                , loginUsers.getJSONObject("validUser").getString("password"));*/
        DeepLink.OpenAppWith("swaglabs://swag-overview/0,5");
        ProductsPage productsPage = new ProductsPage();
        sa.assertEquals(productsPage.getSLBTitle(), strings.get("products_page_slb_title"));
        sa.assertEquals(productsPage.getSLBPrice(), strings.get("products_page_slb_price"));
        sa.assertAll();
    }

    @Test
    public void validateProductOnProductDetailsPage() {
/*        ProductsPage productsPage = new LoginPage().login(loginUsers.getJSONObject("validUser").getString("username")
                , loginUsers.getJSONObject("validUser").getString("password"));*/
        DeepLink.OpenAppWith("swaglabs://swag-overview/0,5");
        ProductsPage productsPage = new ProductsPage();
        ProductDetailsPage productDetailsPage = productsPage.pressSLBTitle();
        Assert.assertEquals(productDetailsPage.getSLBTitle(), strings.get("product_details_page_slb_title"));
    }
}
