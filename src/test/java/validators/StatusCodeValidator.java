package validators;

import io.restassured.response.Response;
import org.testng.Assert;

public class StatusCodeValidator {

    public static void validate( Response response, int expectedStatus) {

        Assert.assertEquals(response.statusCode(),expectedStatus, "Status code validation failed");
    }
}