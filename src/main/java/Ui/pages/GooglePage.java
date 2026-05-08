package Ui.pages;

import core.ConfigReader;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.LoggerUtils;

public class GooglePage extends BasePage {

    private static final Logger logger =
            LoggerUtils.getLogger(GooglePage.class);

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public void openGoogle() {
        actions.openUrl(ConfigReader.get("url"));
        logger.info("Opening application URL");
    }
}