package hooks;

import api.base.ApiBase;
import api.services.OAuthService;
import io.cucumber.java.Before;

public class OAuthHooks {

    @Before("@oauth")
    public void generateOAuthToken() {

        System.out.println("Generating OAuth token...");

        OAuthService.generateToken();

        System.out.println("OAuth token generated successfully");
    }

    @Before(order = 0)
    public void globalSetup() {
        ApiBase.init();
    }
}