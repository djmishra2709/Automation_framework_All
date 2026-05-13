package api.services;

import api.client.RestClient;
import io.restassured.response.Response;
import api.pojo.User;

public class UserService {

    public Response getUser(int id) {

        return RestClient.get("/users/" + id);
    }

    public Response createUser(User user) {

        return RestClient.post("/users",user);
    }
}