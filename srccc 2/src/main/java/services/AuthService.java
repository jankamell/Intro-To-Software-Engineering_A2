package services;

import models.*;
import storage.Storage;

/**
 * Service class responsible for user authentication and account management.
 * This class handles the creation of new users and validates login credentials
 * against the persistent storage.
 */
public class AuthService {

    /**
     * Creates a new User object and adds it to the system storage.
     * * @param e The email address for the new account
     * @param p The password for the new account
     */
    public void createUser(String e, String p) {
        Storage.getUsers().add(new User(e, p));
    }

    /**
     * Checks if the provided credentials match any user in the system.
     * * @param e The email address to check
     * @param p The password to check
     * @return User The authenticated User object if found; null otherwise
     */
    public User validateUser(String e, String p) {
        for (User u : Storage.getUsers()) {
            if (u.getEmail().equals(e) && u.getPassword().equals(p))
                return u;
        }
        return null;
    }
}