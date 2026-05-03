package controllers;

import services.*;
import models.*;

public class GoalController {

    private GoalService service = new GoalService();

    // SDS: createGoal
    public void create(User u, String name, double target) {
        service.createGoal(u, name, target);
    }

    // SDS: updateGoal
    public void update(Goal g, double amount) {
        service.updateGoal(g, amount);
    }
}