package stepdefinitions;

import io.cucumber.java.en.Given;

public class SmokeSteps {

    @Given("framework is initialized")
    public void init() {
        System.out.println("Framework is working!");
    }
}