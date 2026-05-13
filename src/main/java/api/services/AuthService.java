package api.services;

import api.auth.TokenManager;

public class AuthService {

    public void generateToken() {

        /*
         * Simulated token generation
         * Later we will call real auth API
         */

        String fakeToken ="sample-enterprise-token";

        TokenManager.setToken(fakeToken);
    }
}