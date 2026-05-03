package models;

public class Goal {

    private String name;
    private double target;
    private double saved;

    public Goal(String n, double t) {
        name = n;
        target = t;
        saved = 0;
    }

    public void add(double amount) { saved += amount; }

    public double getProgress() {
        return (saved / target) * 100;
    }

    public String getName() { return name; }
}