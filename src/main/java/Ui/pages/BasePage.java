package Ui.pages;

import org.openqa.selenium.WebDriver;
import utils.ActionUtils;

public class BasePage {

    protected WebDriver driver;
    protected ActionUtils actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new ActionUtils(driver);
    }
}