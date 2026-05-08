package utils;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public WaitUtils(WebDriver driver) {

        this.driver = driver;

        // Selenium 4 style wait
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement waitForVisibility(By locator) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    public WebElement waitForClickable(By locator) {

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }
    public WebElement fluentWaitForVisibility(By locator) {

        FluentWait<WebDriver> fluentWait =
                new FluentWait<>(driver)

                        .withTimeout(Duration.ofSeconds(15))
                        .pollingEvery(Duration.ofMillis(500))
                        .ignoring(NoSuchElementException.class)
                        .ignoring(StaleElementReferenceException.class);

        return fluentWait.until(driver ->
                driver.findElement(locator)
        );
    }
}