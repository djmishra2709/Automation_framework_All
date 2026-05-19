package api.client;

import api.auth.TokenManager;
import api.base.ApiBase;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.restassured.specification.RequestSpecification;
public class RestClient extends ApiBase {

    public static Response get(String endpoint) {

        return given()
                .spec(request)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response post( String endpoint, Object payload) {

        return given()
                .spec(request)
                .body(payload)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    private static RequestSpecification attachOAuthToken( RequestSpecification request)
    {

        String token = TokenManager.getToken();

        if (token != null && !token.isEmpty()) {
            request.header("Authorization", "Bearer " + token);
        }

        return request;
    }

}