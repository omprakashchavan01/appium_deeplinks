package qa.base;

public class Config {

    static String getPlatformType(){
        String platformType = System.getProperty("platform", "ios").toLowerCase();
        return switch (platformType) {
            case "ios" -> "iOS";
            case "android" -> "Android";
            default -> throw new IllegalStateException("Invalid platform " + platformType);
        };
    }
}
