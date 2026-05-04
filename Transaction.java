package models;

public abstract class Transaction {

    protected double amount;
    protected String category;

    public Transaction(double a, String c) {
        amount = a;
        category = c;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    // 🔹 ADD THIS (fix error)
    public void setAmount(double amount) {
        this.amount = amount;
    }
}