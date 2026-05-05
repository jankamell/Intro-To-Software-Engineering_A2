package models;

/**
 * Represents an expense transaction in the budget application.
 * This class extends the base Transaction class to categorize negative cash flow.
 */
public class Expense extends Transaction {

    /**
     * Constructs a new Expense with a specified amount and category.
     * * @param a The monetary value of the expense
     * @param c The category of the expense (e.g., "Food", "Rent")
     */
    public Expense(double a, String c) {
        super(a, c);
    }
}