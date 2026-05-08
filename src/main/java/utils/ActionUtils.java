package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionUtils {

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
}