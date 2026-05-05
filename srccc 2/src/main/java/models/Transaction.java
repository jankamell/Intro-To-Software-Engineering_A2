package models;

/**
 * An abstract base class representing a financial transaction.
 * This class provides the common structure for both Income and Expense types,
 * ensuring consistency in how financial data is handled.
 */
public abstract class Transaction {

    /** The monetary value of the transaction */
    protected double amount;
    
    /** The classification of the transaction (e.g., "Food", "Salary") */
    protected String category;

    /**
     * Constructs a new Transaction.
     * * @param a The amount of the transaction
     * @param c The category/label for the transaction
     */
    public Transaction(double a, String c) {
        amount = a;
        category = c;
    }

    /**
     * @return double The current amount of this transaction
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @return String The category assigned to this transaction
     */
    public String getCategory() {
        return category;
    }

    /**
     * Updates the amount of the transaction.
     * * @param amount The new value to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
}