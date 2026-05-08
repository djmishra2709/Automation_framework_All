package core;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.LoggerUtils;
public class DriverManager {

    private static WebDriver driver;
    private static final Logger logger =  LoggerUtils.getLogger(DriverManager.class);
    public static void initDriver() {
        String browser = ConfigReader.get("browser");
        driver = BrowserFactory.createDriver(browser);
        logger.info("Launching browser: {}", browser);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            logger.info("Quitting driver");
        }

    }
}