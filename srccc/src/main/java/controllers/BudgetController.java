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


    public void check(User u) {
        service.checkBudget(u);
    }
}