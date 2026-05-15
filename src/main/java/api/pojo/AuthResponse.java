package api.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthResponse {

    private String token;

    public AuthResponse() {}

    public String getToken() {
        return token;
    }
}