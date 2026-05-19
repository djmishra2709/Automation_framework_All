package api.auth.oauth;

import java.util.ResourceBundle;

public class OAuthConfig {

    private static final ResourceBundle rb =
            ResourceBundle.getBundle("config.config");

    public static final String TOKEN_URL =
            rb.getString("oauth.token.url");

    public static final String EMAIL =
            rb.getString("oauth.email");

    public static final String PASSWORD =
            rb.getString("oauth.password");
    public static Object API_KEY=
            rb.getString("oauth.API_KEY");
}