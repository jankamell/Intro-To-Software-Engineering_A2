package models;

/**
 * Represents a financial goal that a user wants to achieve.
 * Tracks the target amount and the current progress of savings.
 */
public class Goal {

    private String name;
    private double target;
    private double saved;

    /**
     * Constructs a new Goal with a target amount.
     * * @param n The name or title of the goal (e.g., "New Laptop")
     * @param t The total target amount to be saved
     */
    public Goal(String n, double t) {
        name = n;
        target = t;
        saved = 0;
    }

    /**
     * Adds an amount to the current savings for this goal.
     * * @param amount The value to add to the saved total
     */
    public void add(double amount) { saved += amount; }

    /**
     * Calculates the percentage of the goal achieved.
     * * @return double The progress as a percentage (0 to 100)
     */
    public double getProgress() {
        return (saved / target) * 100;
    }

    /**
     * @return String The name of the goal
     */
    public String getName() { return name; }
}