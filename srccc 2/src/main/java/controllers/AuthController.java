package controllers;

import services.*;
import models.*;

/**
 * Handles user authentication processes such as registration and login.
 * This class ensures that user credentials are validated against the system records.
 */
public class AuthController {

    private AuthService service = new AuthService();

    /**
     * Registers a new user in the system.
     * @param email The unique email address for the new account.
     * @param pass The password for the new account.
     */
    public void register(String email, String pass) {
        service.createUser(email, pass);
    }

    /**
     * Validates user credentials during the login process.
     * SDS Mapping: validateUser
     * @param email The user's login email.
     * @param pass The user's login password.
     * @return The authenticated User object if successful, null otherwise.
     */
    public User login(String email, String pass) {
        return service.validateUser(email, pass);
    }
}