package controllers;

import services.*;
import models.*;

public class BudgetController {

    private BudgetService service = new BudgetService();

    public void setBudget(User u, double b) {
        service.createBudget(u, b);
    }

    public double getSpent(User u) {
        return service.calculateSpent(u);
    }


    public double getRemaining(User u) {
        return service.getRemaining(u);
    }

    public double getUsagePercentage(User u) {
        return service.getUsagePercentage(u);
    }

    public String getStatus(User u) {
        return service.checkBudgetStatus(u);
    }
}