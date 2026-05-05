package models;

/**
 * Represents an income transaction in the budget application.
 * This class extends the base Transaction class to categorize positive cash flow.
 */
public class Income extends Transaction {

    /**
     * Constructs a new Income entry with a specified amount and category.
     * * @param a The monetary value of the income
     * @param c The source or category of the income (e.g., "Salary", "Gift")
     */
    public Income(double a, String c) {
        super(a, c);
    }
}