package utils;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionUtils {

    private static final Logger logger =
            LoggerUtils.getLogger(ActionUtils.class);
    private final WebDriver driver;
    private final WaitUtils waitUtils;
    public ActionUtils(WebDriver driver) {

        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void click(By locator) {

        try {

            logger.info("Clicking on element: {}", locator);

            waitUtils.waitForClickable(locator)
                    .click();

        } catch (Exception e) {

            logger.error(
                    "Failed to click element: {}",
                    locator,
                    e
            );

            throw new RuntimeException(
                    "Click action failed for locator: " + locator
            );
        }
    }

    public void type(By locator, String text) {

        try {

            logger.info(
                    "Typing text '{}' into element: {}",
                    text,
                    locator
            );

            waitUtils.waitForVisibility(locator)
                    .sendKeys(text);

        } catch (Exception e) {

            logger.error(
                    "Failed to type into element: {}",
                    locator,
                    e
            );

            throw new RuntimeException(
                    "Type action failed for locator: " + locator
            );
        }
    }

    public String getText(By locator) {

        try {

            logger.info("Fetching text from element: {}", locator);

            return waitUtils
                    .fluentWaitForVisibility(locator)
                    .getText();

        } catch (Exception e) {

            logger.error(
                    "Failed to fetch text from element: {}",
                    locator,
                    e
            );

            throw new RuntimeException(
                    "GetText action failed for locator: " + locator
            );
        }
    }

    public boolean isDisplayed(By locator) {

        try {

            return waitUtils
                    .fluentWaitForVisibility(locator)
                    .isDisplayed();

        } catch (Exception e) {

            logger.error("Element not displayed: {}", locator);

            return false;
        }
    }

    public boolean isEnabled(By locator) {

        try {

            return waitUtils
                    .fluentWaitForVisibility(locator)
                    .isEnabled();

        } catch (Exception e) {

            logger.error("Element not enabled: {}", locator);

            return false;
        }
    }

    public String getTitle() {

        try {

            logger.info("Fetching page title");

            return driver.getTitle();

        } catch (Exception e) {

            logger.error("Failed to fetch title", e);

            throw new RuntimeException(
                    "Unable to fetch page title"
            );
        }
    }

    public String getCurrentUrl() {

        return driver.getCurrentUrl();
    }
}