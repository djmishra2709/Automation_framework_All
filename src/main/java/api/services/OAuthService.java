package api.services;

import api.auth.oauth.OAuthConfig;
import api.auth.oauth.OAuthTokenProvider;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class OAuthService {

    public static String generateToken() {

        // =========================
        // TOKEN API CALL
        // =========================
        Response response =
                given()
                        .header("Content-Type", "application/json")

                        // Optional API key support
                        .header("x-api-key", OAuthConfig.API_KEY )

                        .body("""
                                {
                                   "email": "%s",
                                   "password": "%s"
                                }
                                """.formatted(
                                OAuthConfig.EMAIL,
                                OAuthConfig.PASSWORD
                        ))

                        .when()

                        .post(OAuthConfig.TOKEN_URL);

        // =========================
        // DEBUG LOGS
        // =========================
        System.out.println("========== TOKEN RESPONSE ==========");
        System.out.println("STATUS CODE : " + response.getStatusCode());
        System.out.println("RESPONSE BODY : ");
        System.out.println(response.asPrettyString());

        // =========================
        // STATUS VALIDATION
        // =========================
        if (response.getStatusCode() != 200) {

            throw new RuntimeException(
                    "OAuth token generation failed : "
                            + response.asPrettyString()
            );
        }

        // =========================
        // EXTRACT TOKEN
        // =========================
        String token =
                response.jsonPath().getString("token");

        // =========================
        // NULL CHECK
        // =========================
        if (token == null || token.isEmpty()) {

            throw new RuntimeException(
                    "Token is null or empty"
            );
        }

        // =========================
        // STORE TOKEN
        // =========================
        OAuthTokenProvider.setToken(token);

        System.out.println("Generated Token : " + token);

        return token;
    }
}