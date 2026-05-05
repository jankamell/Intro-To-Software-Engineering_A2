package ui;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import controllers.*;
import models.*;

/**
 * Graphical interface for creating and tracking savings goals.
 * Provides inputs for naming new goals and updating the progress of existing ones
 * through a visual list.
 * * SDS Mapping: UC-07 Manage Savings Goals UI
 */
public class GoalView extends BorderPane {

    /**
     * Constructs the Goal management view.
     * Initializes input fields, progress tracking buttons, and a refreshable list.
     * * @param s The primary stage for scene switching
     * @param u The currently authenticated user managing their goals
     */
    public GoalView(Stage s, User u) {

        VBox root = UIHelper.root();

        TextField name = new TextField();
        name.setPromptText("Goal Name");

        TextField target = new TextField();
        target.setPromptText("Target");

        TextField addAmount = new TextField();
        addAmount.setPromptText("Add to Goal");

        Label out = new Label();
        out.setTextFill(javafx.scene.paint.Color.BLACK);

        ListView<String> list = new ListView<>();

        GoalController c = new GoalController();

        Button create = UIHelper.button("Create Goal");
        Button update = UIHelper.button("Add Progress");
        Button back = UIHelper.button("Back");

        /**
         * A refresh utility to sync the UI list with the user's data.
         * Formats the goal progress as a percentage.
         */
        Runnable refresh = () -> {
            list.getItems().clear();

            for (Goal g : u.getGoals()) {
                list.getItems().add(
                        g.getName() +
                                " | Progress: " +
                                String.format("%.1f", g.getProgress()) + "%"
                );
            }
        };

        // Event handler for creating new goal records
        create.setOnAction(e -> {
            c.create(u, name.getText(), Double.parseDouble(target.getText()));
            out.setText("Goal created");
            refresh.run();
        });

        // Event handler for updating the first goal in the list with a savings amount
        update.setOnAction(e -> {
            if (!u.getGoals().isEmpty()) {
                Goal g = u.getGoals().get(0); // simple: first goal
                c.update(g, Double.parseDouble(addAmount.getText()));
                out.setText("Goal updated");
                refresh.run();
            }
        });

        back.setOnAction(e ->
                s.setScene(new Scene(new DashboardView(s, u), 600, 450))
        );

        refresh.run();

        VBox card = UIHelper.card();
        card.getChildren().addAll(
                UIHelper.title("Goals"),
                name,
                target,
                create,
                addAmount,
                update,
                list,
                back,
                out
        );

        root.getChildren().add(card);
        setCenter(root);
    }
}