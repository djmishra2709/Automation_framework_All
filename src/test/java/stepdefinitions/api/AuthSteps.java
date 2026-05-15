package stepdefinitions.api;

import api.auth.TokenManager;
import api.base.ApiBase;
import api.services.AuthService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AuthSteps {

    AuthService authService =
            new AuthService();

    @Given("I initialize Auth API")
    public void init_api() {
        ApiBase.initAuth();
    }
    @When("I generate Basic auth token")
    public void generateAuthToken() {

        authService.generateToken();
    }

    @Then("token should be generated successfully")
    public void validateToken() {

        String token = TokenManager.getToken();
        System.out.println("Generated Token: " + token );
        Assert.assertNotNull(token);
    }
}