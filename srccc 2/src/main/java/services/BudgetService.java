package services;

import models.*;

/**
 * Service class that handles all budget-related calculations and logic.
 * It provides methods to track spending, determine remaining balances, 
 * and monitor budget health status.
 */
public class BudgetService {

    /**
     * Sets a new monthly spending limit for a specific user.
     * @param user The user whose budget is being updated
     * @param limit The maximum amount the user intends to spend
     */
    public void createBudget(User user, double limit) {
        user.setBudget(limit);
    }

    /**
     * Iterates through a user's transaction history to sum all expenses.
     * @param user The user whose transactions are being analyzed
     * @return double The total sum of all transactions of type Expense
     */
    public double calculateSpent(User user) {
        double sum = 0;

        for (Transaction t : user.getTransactions()) {
            if (t instanceof Expense) {
                sum += t.getAmount();
            }
        }

        return sum;
    }

    /**
     * Calculates the amount left in the budget after subtracting total expenses.
     * @param user The user whose remaining balance is needed
     * @return double The difference between the budget limit and total spent
     */
    public double getRemaining(User user) {
        return user.getBudget() - calculateSpent(user);
    }

    /**
     * Calculates what percentage of the budget has been utilized.
     * @param user The user whose usage percentage is being calculated
     * @return double The percentage of budget spent (0 if budget is not set)
     */
    public double getUsagePercentage(User user) {
        if (user.getBudget() == 0) return 0;
        return (calculateSpent(user) / user.getBudget()) * 100;
    }

    /**
     * Evaluates the health of the user's budget and returns a status message.
     * Provides warnings when spending reaches critical thresholds (80% and 100%).
     * @param user The user whose status is being checked
     * @return String A status message: "Exceeded", "Warning", or "Under control"
     */
    public String checkBudgetStatus(User user) {
        double used = getUsagePercentage(user);

        if (used >= 100) {
            return "Budget exceeded!";
        } else if (used >= 80) {
            return " Warning: Near budget!";
        } else {
            return " Budget is under control";
        }
    }
}