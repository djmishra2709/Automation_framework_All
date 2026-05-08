package Ui.pages;

import core.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import utils.LoggerUtils;

public class GooglePage extends BasePage {

    private static final Logger logger =
            LoggerUtils.getLogger(GooglePage.class);

    // =========================
    // Locators
    // =========================

    private final By searchBox = By.name("q");

    // =========================
    // Constructor
    // =========================

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    // =========================
    // Page Actions
    // =========================

    public void openGoogle() {
        logger.info("Opening application URL");
        actions.openUrl(ConfigReader.get("url"));
    }

    public void enterSearchText(String text) {
        logger.info("Entering search text: {}", text);
        actions.type(searchBox, text);
    }
}