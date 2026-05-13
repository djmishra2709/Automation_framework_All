package Ui.pages;

import utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import utils.LoggerUtils;

public class GooglePage extends BasePage {

    private static final Logger logger =   LoggerUtils.getLogger(GooglePage.class);

    // =========================
    // Locators
    // =========================

    private final By searchBox = By.name("q1");
    private final By googleSearchButton = By.name("btnK");
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

    public void clickSearch() {

        logger.info("Clicking Google Search button");
        actions.click(googleSearchButton);
    }
    public boolean isSearchBoxDisplayed() {

        logger.info("Checking if search box is displayed");
        return actions.isDisplayed(searchBox);
    }

    public boolean isSearchButtonEnabled() {

        logger.info("Checking if search button is enabled");
        return actions.isEnabled(googleSearchButton);
    }
    public String fetchPageTitle() {

        logger.info("Fetching page title");
        return actions.getTitle();
    }
}