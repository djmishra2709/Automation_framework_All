package api.spec;

import api.auth.TokenManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;

public class RequestSpecFactory {

    public static RequestSpecification getRequestSpec() {

        RequestSpecBuilder builder =
                new RequestSpecBuilder()
                        .setBaseUri(
                                ConfigReader.get("base.url")
                        )
                        .addHeader(
                                "Content-Type",
                                "application/json"
                        );

        // Add Authorization header dynamically
        if (TokenManager.getToken() != null) {

            builder.addHeader(
                    "Authorization",
                    "Bearer " + TokenManager.getToken()
            );
        }

        return builder.build();
    }

    public static RequestSpecification getAuthRequestSpec() {

        return new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/api")
                .setContentType("application/json")

                // if your API requires key (as per your earlier error)
                .addHeader("x-api-key", "free_user_3DjqK4ZPykCT6flb8oMEfnPJTHR")

                .build();
    }
}