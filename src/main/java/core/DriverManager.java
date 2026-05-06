package core;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static WebDriver driver;

    public static void initDriver() {
        String browser = ConfigReader.get("browser");
        driver = BrowserFactory.createDriver(browser);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}