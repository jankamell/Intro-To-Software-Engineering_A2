package controllers;

import services.*;
import models.*;

/**
 * Controller for managing financial goals.
 * This class handles the creation and progress tracking of user-defined goals.
 */
public class GoalController {

    private GoalService service = new GoalService();

    /**
     * Creates a new financial goal for a user.
     * SDS Mapping: createGoal
     * @param u The user who owns the goal.
     * @param name The descriptive name of the goal.
     * @param target The total target amount to be saved or reached.
     */
    public void create(User u, String name, double target) {
        service.createGoal(u, name, target);
    }

    /**
     * Updates the progress of an existing goal by adding a specific amount.
     * SDS Mapping: updateGoal
     * @param g The specific goal object to be updated.
     * @param amount The numerical value to add to the current goal progress.
     */
    public void update(Goal g, double amount) {
        service.updateGoal(g, amount);
    }
}