package ui;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import controllers.*;
import models.*;
import ui.UIHelper;

public class BudgetView extends BorderPane {

    public BudgetView(Stage s, User u) {

        VBox root = UIHelper.root();

        TextField b = new TextField();
        b.setPromptText("Budget");

        Label out = new Label();

        BudgetController c = new BudgetController();

        Button set = UIHelper.button("Set Budget");
        Button back = UIHelper.button("Back");

        set.setOnAction(e -> {
            double budget = Double.parseDouble(b.getText());
            c.setBudget(u, budget);

            double spent = c.getSpent(u);

            if (spent >= budget)
                new Alert(Alert.AlertType.WARNING, "Budget exceeded!").show();

            out.setText("Spent: " + spent);
        });

        back.setOnAction(e ->
                s.setScene(new Scene(new DashboardView(s, u), 600, 450))
        );

        VBox card = UIHelper.card();
        card.getChildren().addAll(UIHelper.title("Budget"), b, set, back, out);

        root.getChildren().add(card);
        setCenter(root);
    }
}