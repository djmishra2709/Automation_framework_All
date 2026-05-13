package stepdefinitions.api;

import api.base.ApiBase;
import api.services.UserService;
import validators.ResponseValidator;
import validators.StatusCodeValidator;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import api.services.AuthService;
import api.pojo.User;
import api.pojo.UserResponse;
public class UserApiSteps {

    Response response;
    UserService userService = new UserService();
    AuthService authService = new AuthService();


    @Given("I initialize API")
    public void init_api() {
        ApiBase.init();
    }

    @Given("I generate auth token")
    public void generate_auth_token() {

        authService.generateToken();
    }

    @When("I send GET request for user id {int}")
    public void get_user(int id) {
        response = userService.getUser(id);
    }

    @Then("I should receive status code {int}")
    public void validate_status(int statusCode) {
        StatusCodeValidator.validateStatusCode(response.getStatusCode(),statusCode);
    }

    @When("I create user with name {string} and job {string}")
    public void create_user(String name,String job) {

        User user = new User(name, job);
        response = userService.createUser(user);
    }
    @Then("I validate response contains name {string}")
    public void validate_name(String expectedName) {

        UserResponse userResponse = response.as(UserResponse.class);
        ResponseValidator.validateEquals( userResponse.getName(),expectedName,"Name validation failed");
    }
}