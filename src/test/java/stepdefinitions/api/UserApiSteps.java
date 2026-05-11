package stepdefinitions.api;

import api.base.ApiBase;
import api.services.UserService;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.testng.Assert;

public class UserApiSteps {

    Response response;
    UserService userService = new UserService();

    @Given("I initialize API")
    public void init_api() {
        ApiBase.init();
    }

    @When("I send GET request for user id {int}")
    public void get_user(int id) {
        response = userService.getUser(id);
    }

    @Then("I should receive status code {int}")
    public void validate_status(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
    }
}