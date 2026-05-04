package controllers;

import services.*;
import models.*;

public class AuthController {

    private AuthService service = new AuthService();

    public void register(String email, String pass) {
        service.createUser(email, pass);
    }


    public User login(String email, String pass) {
        return service.validateUser(email, pass);
    }
}