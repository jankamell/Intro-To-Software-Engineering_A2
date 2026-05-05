package controllers;

import services.*;
import models.*;

/**
 * Controller responsible for managing user-specific settings and profile data.
 * This class facilitates updates to user preferences within the system.
 */
public class UserController {

    private UserService service = new UserService();

    /**
     * Updates the preferred currency setting for a specific user.
     * SDS Mapping: updateSettings
     * @param u The user whose settings are being modified.
     * @param currency The new currency string to be applied (e.g., "EGP", "USD").
     */
    public void updateCurrency(User u, String currency) {
        service.updateSettings(u, currency);
    }
}