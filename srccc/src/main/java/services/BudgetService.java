package services;

import models.*;

public class BudgetService {

    public void createBudget(User u, double limit) {
        u.setBudget(limit);
    }

    public double calculateSpent(User u) {
        double sum = 0;
        for (Transaction t : u.getTransactions())
            if (t instanceof Expense)
                sum += t.getAmount();
        return sum;
    }

    public void checkBudget(User u) {
        if (calculateSpent(u) >= u.getBudget())
            System.out.println("Budget exceeded");
    }
}