package stepdefinitions;

import io.cucumber.java.en.Given;
import Ui.pages.GooglePage;

public class SmokeSteps {

    GooglePage googlePage = new GooglePage();

    @Given("framework is initialized")
    public void init() {
        googlePage.openGoogle();
        System.out.println("Opened Google via Page Object");
    }
}