package controllers;

import services.*;
import models.*;

public class UserController {

    private UserService service = new UserService();


    public void updateCurrency(User u, String currency) {
        service.updateSettings(u, currency);
    }
}