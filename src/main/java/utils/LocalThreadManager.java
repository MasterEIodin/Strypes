package utils;

import org.openqa.selenium.WebDriver;

public class LocalThreadManager {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    public static WebDriver getDriver() {
        return webDriver.get();
    }
}
