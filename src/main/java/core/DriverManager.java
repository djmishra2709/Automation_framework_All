package core;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.LoggerUtils;

public class DriverManager {

    // Thread-safe WebDriver storage
    private static final ThreadLocal<WebDriver>  driverThreadLocal = new ThreadLocal<>();
    private static final Logger logger =  LoggerUtils.getLogger(DriverManager.class);
    public static void initDriver()
    {
        String browser =  ConfigReader.get("browser");
        WebDriver driver =  BrowserFactory.createDriver(browser);
        // Store driver per thread
        driverThreadLocal.set(driver);
        logger.info("Launching browser: {}", browser );
    }

    public static WebDriver getDriver()
    {
        return driverThreadLocal.get();
    }

    public static void quitDriver()
    {
        if (getDriver() != null)
        {
            getDriver().quit();
            logger.info("Quitting driver");
            // VERY IMPORTANT
            driverThreadLocal.remove();
        }
    }
}