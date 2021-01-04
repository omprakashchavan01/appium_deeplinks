package qa.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;

public class LoginPage extends BasePage {
    @AndroidFindBy(accessibility = "test-Username")
    @iOSXCUITFindBy(id = "test-Username")
    private MobileElement usernameTxtFld;

    @AndroidFindBy(accessibility = "test-Password")
    @iOSXCUITFindBy(id = "test-Password")
    private MobileElement passwordTxtFld;

    @AndroidFindBy(accessibility = "test-LOGIN")
    @iOSXCUITFindBy(id = "test-LOGIN")
    private MobileElement loginBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Error message\"]/child::XCUIElementTypeStaticText")
    private MobileElement errTxt;

    public LoginPage enterUserName(String username) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(usernameTxtFld));
        e.clear();
        e.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(passwordTxtFld));
        e.clear();
        e.sendKeys(password);
        return this;
    }

    public ProductsPage pressLoginBtn() {
        wait.until(ExpectedConditions.visibilityOf(loginBtn)).click();
        return new ProductsPage();
    }

    public ProductsPage login(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        return pressLoginBtn();
    }

    public String getErrTxt() {
        return wait.until(ExpectedConditions.visibilityOf(errTxt)).getText();
    }
}
