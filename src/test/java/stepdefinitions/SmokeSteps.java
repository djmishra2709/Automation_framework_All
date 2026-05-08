package stepdefinitions;

import core.DriverManager;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import Ui.pages.GooglePage;

public class SmokeSteps {

    @Given("framework is initialized")
    public void init() {

        WebDriver driver = DriverManager.getDriver();
        GooglePage googlePage = new GooglePage(driver);
        googlePage.openGoogle();
        googlePage.enterSearchText("Selenium 4");

    }
}