package services;

import models.*;

public class UserService {

    public void updateSettings(User u, String currency) {
        u.setCurrency(currency);
    }
}