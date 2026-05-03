package models;

import java.util.*;

public class User {

    private String email, password;

    private List<Transaction> transactions = new ArrayList<>();
    private List<Goal> goals = new ArrayList<>();

    private double budget = 0;


    private String currency = "USD";

    public User(String e, String p) {
        email = e;
        password = p;
    }

    public String getEmail() { return email; }
    public String getPassword() { return password; }

    public List<Transaction> getTransactions() { return transactions; }
    public List<Goal> getGoals() { return goals; }

    public double getBudget() { return budget; }
    public void setBudget(double b) { budget = b; }


    public String getCurrency() { return currency; }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}