package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionUtils {

    private WebDriver driver;

    public ActionUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }
}