package api.base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;

public class ApiBase {

    protected static RequestSpecification request;

    public static void init() {

        RestAssured.baseURI = ConfigReader.get("base.url");

        request = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .log().all();
    }
}