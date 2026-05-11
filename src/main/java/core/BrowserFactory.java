package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ConfigReader;

import java.net.URL;

public class BrowserFactory {

    public static WebDriver createDriver( String browser) {

        String executionType = ConfigReader.get("execution.type");

        try {

            switch (executionType.toLowerCase()) {

                // =========================
                // LOCAL EXECUTION
                // =========================

                case "local":

                    switch (browser.toLowerCase()) {

                        case "chrome":

                            WebDriverManager.chromedriver().setup();
                            return new ChromeDriver();

                        case "firefox":

                            WebDriverManager.firefoxdriver().setup();
                            return new FirefoxDriver();

                        default:

                            throw new RuntimeException("Invalid browser: " + browser );
                    }

                    // =========================
                    // HEADLESS EXECUTION
                    // =========================

                case "headless":

                    switch (browser.toLowerCase()) {

                        case "chrome":

                            WebDriverManager.chromedriver().setup();

                            ChromeOptions options = new ChromeOptions();
                            options.addArguments("--headless=new");   // 🔷 Selenium 4 update
                            options.addArguments("--disable-gpu");
                            options.addArguments("--window-size=1920,1080");

                            return new ChromeDriver(options);

                        case "firefox":

                            WebDriverManager
                                    .firefoxdriver()
                                    .setup();

                            FirefoxOptions firefoxOptions =
                                    new FirefoxOptions();

                            firefoxOptions.addArguments(
                                    "--headless"
                            );

                            return new FirefoxDriver(
                                    firefoxOptions
                            );

                        default:

                            throw new RuntimeException(
                                    "Invalid browser: "
                                            + browser
                            );
                    }

                    // =========================
                    // REMOTE GRID EXECUTION
                    // =========================

                case "remote":

                    String gridUrl =  ConfigReader.get("grid.url" );

                    switch (browser.toLowerCase()) {

                        case "chrome":

                            ChromeOptions chromeGridOptions = new ChromeOptions();
                            return new RemoteWebDriver( new URL(gridUrl), chromeGridOptions );

                        case "firefox":

                            FirefoxOptions firefoxGridOptions = new FirefoxOptions();
                            return new RemoteWebDriver(new URL(gridUrl), firefoxGridOptions );

                        default:

                            throw new RuntimeException("Invalid browser: "  + browser);
                    }

                default:

                    throw new RuntimeException( "Invalid execution type: "  + executionType);
            }

        } catch (Exception e) {

            throw new RuntimeException(
                    "Failed to create driver",
                    e
            );
        }
    }
}