package api.services;

import api.auth.TokenManager;
import api.base.ApiBase;
import api.pojo.AuthRequest;
import api.pojo.AuthResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthService {

    AuthRequest request =
            new AuthRequest(
                    "eve.holt@reqres.in",
                    "cityslicka"
            );
    public Response generateToken() {

        Response response =
                given()
                        .spec(ApiBase.getRequest())
                        .body(request)
                        .when()
                        .post("/login");

        if (response.getStatusCode() == 200) {
            System.out.println("Good");
        }

        System.out.println("response id ==="+response.asString());

        AuthResponse authResponse =
                response.then()
                        .extract()
                        .as(AuthResponse.class);

        System.out.println("Token from POJO: " + authResponse.getToken());

        TokenManager.setToken(authResponse.getToken());

        return response;
    }
}