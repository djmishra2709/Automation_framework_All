package Ui.pages;

import core.DriverManager;
import org.openqa.selenium.WebDriver;
import utils.ActionUtils;

public class BasePage {

    protected WebDriver driver;
    protected ActionUtils actions;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.actions = new ActionUtils(driver);
    }
}