package services;

import models.*;

/**
 * Service class responsible for managing user financial goals.
 * It provides functionality to initialize new goals and update the progress
 * of existing savings targets.
 */
public class GoalService {

    /**
     * Initializes a new financial goal and attaches it to the user's profile.
     * @param u The user creating the goal
     * @param name The descriptive name of the goal
     * @param target The total monetary amount required to complete the goal
     */
    public void createGoal(User u, String name, double target) {
        u.getGoals().add(new Goal(name, target));
    }

    /**
     * Records a new contribution towards a specific goal's total savings.
     * @param g The specific Goal object to be updated
     * @param amount The amount of money to add to the current progress
     */
    public void updateGoal(Goal g, double amount) {
        g.add(amount);
    }
}