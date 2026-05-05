package controllers;

import services.*;
import models.*;

/**
 * Manages budget-related operations including setting limits and tracking usage.
 */
public class BudgetController {

    private BudgetService service = new BudgetService();

    /**
     * Establishes a monthly budget limit for a specific user.
     * @param u The user setting the budget.
     * @param b The total amount allowed for the budget period.
     */
    public void setBudget(User u, double b) {
        service.createBudget(u, b);
    }

    /**
     * Retrieves the total amount the user has spent in the current period.
     * @param u The user whose spending is being tracked.
     * @return The total sum of expenses.
     */
    public double getSpent(User u) {
        return service.calculateSpent(u);
    }

    /**
     * Calculates the remaining funds available in the user's budget.
     * @param u The user whose remaining budget is requested.
     * @return The difference between the budget limit and total spent.
     */
    public double getRemaining(User u) {
        return service.getRemaining(u);
    }

    /**
     * Provides a percentage of budget used relative to the set limit.
     * @param u The user to check.
     * @return A percentage value (0.0 to 100.0+).
     */
    public double getUsagePercentage(User u) {
        return service.getUsagePercentage(u);
    }

    /**
     * Returns a status message regarding the user's budget health.
     * SDS Mapping: checkBudgetStatus
     * @param u The user to check.
     * @return A status string (e.g., "Within Budget" or "Over Budget").
     */
    public String getStatus(User u) {
        return service.checkBudgetStatus(u);
    }
}