package api.client;

import api.base.ApiBase;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

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
}