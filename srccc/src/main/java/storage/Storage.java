package storage;

import java.util.*;
import models.User;

public class Storage {

    private static List<User> users = new ArrayList<>();

    public static void load() {}

    public static void save(User u) {
        System.out.println("Saving user...");
    }

    public static List<User> getUsers() {
        return users;
    }
}