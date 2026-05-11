package api.services;

import api.client.RestClient;
import io.restassured.response.Response;

public class UserService {

    public Response getUser(int id) {

        return RestClient.get("/users/" + id);
    }
}