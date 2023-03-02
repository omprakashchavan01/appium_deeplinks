package qa.byfactory;

import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static io.appium.java_client.remote.MobilePlatform.IOS;

public class ByElementManagerFactory {

    public static ByElementManager getByElementManager(String byElementManagerType) {
        return switch (byElementManagerType){
            case ANDROID -> new AndroidByElementManager();
            case IOS -> new IOSByElementManager();
            default -> throw new IllegalStateException("Invalid platform " + byElementManagerType);
        };
    }
}
