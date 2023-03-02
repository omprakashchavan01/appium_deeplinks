package qa.byfactory;

import org.openqa.selenium.By;

public interface ByElementManager {

    By getXpathUsingTextOrName(String textOrName);
}
