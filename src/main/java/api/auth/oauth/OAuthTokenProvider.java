package api.auth.oauth;

public class OAuthTokenProvider {

    private static String accessToken;

    public static void setToken(String token) {
        accessToken = token;
    }

    public static String getToken() {
        return accessToken;
    }

    public static void clear() {
        accessToken = null;
    }
}