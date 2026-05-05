package models;

import java.util.*;

/**
 * Represents a user within the personal finance system.
 * Stores authentication details, financial preferences, and maintains 
 * the user's collections of transactions and savings goals.
 */
public class User {

    /** The unique email address for the user account */
    private String email;
    /** The account password */
    private String password;

    /** List containing all income and expense history for this user */
    private List<Transaction> transactions = new ArrayList<>();
    
    /** List containing all financial goals set by the user */
    private List<Goal> goals = new ArrayList<>();

    /** The monthly or overall budget limit set by the user */
    private double budget = 0;

    /** The preferred currency for display and calculations (default is USD) */
    private String currency = "USD";

    /**
     * Constructs a new User with essential login credentials.
     * @param e The user's email address
     * @param p The user's password
     */
    public User(String e, String p) {
        email = e;
        password = p;
    }

    /** @return String The user's registered email */
    public String getEmail() { return email; }
    
    /** @return String The user's password */
    public String getPassword() { return password; }

    /** @return List A list of all transactions associated with this user */
    public List<Transaction> getTransactions() { return transactions; }
    
    /** @return List A list of all goals created by this user */
    public List<Goal> getGoals() { return goals; }

    /** @return double The current budget value */
    public double getBudget() { return budget; }
    
    /** @param b The new budget limit to set */
    public void setBudget(double b) { budget = b; }

    /** @return String The current currency code (e.g., "USD", "EGP") */
    public String getCurrency() { return currency; }

    /** @param currency The new currency code to be used for the account */
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}