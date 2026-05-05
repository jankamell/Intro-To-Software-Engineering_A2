package storage;

import java.util.*;
import models.User;

/**
 * Acts as the centralized data repository for the application.
 * This class provides static access to the list of registered users and 
 * simulates persistence operations (loading and saving data).
 */
public class Storage {

    /** The in-memory list of users registered in the system */
    private static List<User> users = new ArrayList<>();

    /**
     * Placeholder method for loading user data from external storage (e.g., File or Database).
     */
    public static void load() {}

    /**
     * Simulates the persistence of a user's current state.
     * @param u The user object to be saved
     */
    public static void save(User u) {
        System.out.println("Saving user...");
    }

    /**
     * Provides global access to the list of system users.
* @return {@code List<User>} The complete collection of users currently in memory     */
    public static List<User> getUsers() {
        return users;
    }
}