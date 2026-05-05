package services;

import models.*;
import storage.Storage;

public class AuthService {

    public void createUser(String e, String p) {
        Storage.getUsers().add(new User(e, p));
    }

    public User validateUser(String e, String p) {
        for (User u : Storage.getUsers()) {
            if (u.getEmail().equals(e) && u.getPassword().equals(p))
                return u;
        }
        return null;
    }
}