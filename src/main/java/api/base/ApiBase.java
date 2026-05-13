package api.base;

import api.spec.RequestSpecFactory;
import io.restassured.specification.RequestSpecification;

public class ApiBase {

    protected static RequestSpecification request;

    public static void init() {

        request =
                RequestSpecFactory
                        .getRequestSpec();
    }
}