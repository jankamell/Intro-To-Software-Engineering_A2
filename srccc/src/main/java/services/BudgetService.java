package services;

import models.*;

public class BudgetService {

    public void createBudget(User user, double limit) {
        user.setBudget(limit);
    }

    public double calculateSpent(User user) {
        double sum = 0;

        for (Transaction t : user.getTransactions()) {
            if (t instanceof Expense) {
                sum += t.getAmount();
            }
        }

        return sum;
    }

    public double getRemaining(User user) {
        return user.getBudget() - calculateSpent(user);
    }

    public double getUsagePercentage(User user) {
        if (user.getBudget() == 0) return 0;
        return (calculateSpent(user) / user.getBudget()) * 100;
    }

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