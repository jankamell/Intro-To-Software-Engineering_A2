package ui;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import controllers.*;
import models.*;
import ui.UIHelper;

/**
 * The graphical interface for managing a user's budget.
 * This class provides inputs for setting budget limits and displays
 * real-time feedback on spending, remaining balance, and budget status.
 * * * SDS Mapping: UC-04 Manage Budget UI
 */
public class BudgetView extends BorderPane {

    /**
     * Constructs the Budget Management view.
     * * @param s The primary stage for scene switching
     * @param u The currently authenticated user whose budget is being viewed
     */
    public BudgetView(Stage s, User u) {

        VBox root = UIHelper.root();

        TextField budgetField = new TextField();
        budgetField.setPromptText("Enter Budget");

        Label out = new Label();
        out.setTextFill(javafx.scene.paint.Color.BLACK);

        BudgetController c = new BudgetController();

        Button setBtn = UIHelper.button("Set Budget");
        Button backBtn = UIHelper.button("Back");

        /**
         * Event handler for the "Set Budget" button.
         * Parses the input, updates the user's budget via BudgetController,
         * and refreshes the status labels.
         */
        setBtn.setOnAction(e -> {
            try {
                double budget = Double.parseDouble(budgetField.getText());

                c.setBudget(u, budget);

                double spent = c.getSpent(u);
                double remaining = c.getRemaining(u);
                double percent = c.getUsagePercentage(u);

                String status = c.getStatus(u);

                out.setText(
                        "Spent: " + spent +
                                "\nRemaining: " + remaining +
                                "\nUsage: " + String.format("%.1f", percent) + "%" +
                                "\n" + status
                );

            } catch (Exception ex) {
                out.setText("Invalid input");
            }
        });

        backBtn.setOnAction(e ->
                s.setScene(new Scene(new DashboardView(s, u), 600, 450))
        );

        VBox card = UIHelper.card();
        card.getChildren().addAll(
                UIHelper.title("Budget Management"),
                budgetField,
                setBtn,
                out,
                backBtn
        );

        root.getChildren().add(card);
        setCenter(root);
    }
}