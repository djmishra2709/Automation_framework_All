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
        waitUtils.waitForClickable(locator).click();
    }

    public void type(By locator, String text) {
        waitUtils.waitForVisibility(locator).sendKeys(text);
    }

    public String getText(By locator) {
        return waitUtils.fluentWaitForVisibility(locator).getText();
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

        return driver.getTitle();
    }

    public String getCurrentUrl() {

        return driver.getCurrentUrl();
    }
}