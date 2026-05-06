package Ui.pages;

import core.ConfigReader;
import org.openqa.selenium.WebDriver;

public class GooglePage extends BasePage {

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public void openGoogle() {
        actions.openUrl(ConfigReader.get("url"));
    }
}