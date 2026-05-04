package ui;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import controllers.*;
import models.*;

public class TransactionView extends BorderPane {

    public TransactionView(Stage s, User u) {

        VBox root = UIHelper.root();

        TextField amount = new TextField();
        amount.setPromptText("Amount");

        TextField cat = new TextField();
        cat.setPromptText("Category");

        Label out = new Label();
        out.setTextFill(javafx.scene.paint.Color.BLACK);


        ListView<String> list = new ListView<>();

        TransactionController c = new TransactionController();

        Button exp = UIHelper.button("Add Expense");
        Button inc = UIHelper.button("Add Income");
        Button back = UIHelper.button("Back");


        Runnable refresh = () -> {
            list.getItems().clear();

            for (Transaction t : u.getTransactions()) {
                String type = (t instanceof Expense) ? "Expense" : "Income";

                list.getItems().add(
                        type + " | " +
                                t.getAmount() + " | " +
                                t.getCategory()
                );
            }
        };

        exp.setOnAction(e -> {
            c.addExpense(u, Double.parseDouble(amount.getText()), cat.getText());
            out.setText("Expense added");
            refresh.run();
        });

        inc.setOnAction(e -> {
            c.addIncome(u, Double.parseDouble(amount.getText()), cat.getText());
            out.setText("Income added");
            refresh.run();
        });

        back.setOnAction(e ->
                s.setScene(new Scene(new DashboardView(s, u), 600, 450))
        );


        refresh.run();

        VBox card = UIHelper.card();
        card.getChildren().addAll(
                UIHelper.title("Transactions"),
                amount,
                cat,
                exp,
                inc,
                list,
                back,
                out
        );

        root.getChildren().add(card);
        setCenter(root);
    }
}