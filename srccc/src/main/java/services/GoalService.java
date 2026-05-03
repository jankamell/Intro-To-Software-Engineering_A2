package services;

import models.*;

public class GoalService {

    public void createGoal(User u, String name, double target) {
        u.getGoals().add(new Goal(name, target));
    }

    public void updateGoal(Goal g, double amount) {
        g.add(amount);
    }
}