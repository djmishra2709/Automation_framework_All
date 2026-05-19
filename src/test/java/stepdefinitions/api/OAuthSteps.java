package stepdefinitions.auth;

import api.services.OAuthService;
import api.client.RestClient;
import io.restassured.response.Response;
import org.testng.Assert;
import io.cucumber.java.en.*;

public class OAuthSteps {

    private Response response;

    // =========================
    // STEP 1: GENERATE TOKEN
    // =========================
    @Given("I generate OAuth2 token")
    public void generate_oauth_token() {

        String token = OAuthService.generateToken();

        Assert.assertNotNull(token, "Token should not be null");
        System.out.println("Generated Token: " + token);
    }

    // =========================
    // STEP 2: CALL USER API
    // =========================
    @When("I get user with id {int}")
    public void get_user(int id) {

        response = RestClient.get("/users/" + id);
    }

    // =========================
    // STEP 3: VALIDATE STATUS
    // =========================
    @Then("OAuth should receive status code {int}")
    public void validate_status(int expectedStatus) {

        Assert.assertEquals(
                response.getStatusCode(),
                expectedStatus,
                "Status code mismatch"
        );
    }

    // =========================
    // STEP 4: VALIDATE TOKEN EXISTS
    // =========================
    @Then("I should have a valid access token")
    public void validate_token_exists() {

        Assert.assertTrue(
                api.auth.oauth.OAuthTokenProvider.getToken() != null,
                "Token should exist"
        );
    }
}