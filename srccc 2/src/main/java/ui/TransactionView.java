package ui;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import controllers.*;
import models.*;

/**
 * The user interface for recording and viewing financial transactions.
 * This view allows users to input amounts and categories for both income 
 * and expenses, and displays a real-time list of all recorded activity.
/**
 * ...
 * * SDS Mapping: UC-09 Record Transaction and UC-10 View Transaction History
 */ 
public class TransactionView extends BorderPane {

    /**
     * Constructs the Transaction management view.
     * Initializes input fields, action buttons for different transaction types,
     * and a dynamic list to display historical data.
     * * @param s The primary stage for scene switching
     * @param u The currently authenticated user whose transactions are being managed
     */
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

        /**
         * Refresh utility to synchronize the ListView with the user's transaction list.
         * Identifies the specific subclass (Income/Expense) to label each entry correctly.
         */
        Runnable refresh = () -> {
            list.getItems().clear();

            for (Transaction t : u.getTransactions()) {
                // Polymorphic check to determine the transaction type for display
                String type = (t instanceof Expense) ? "Expense" : "Income";

                list.getItems().add(
                        type + " | " +
                                t.getAmount() + " | " +
                                t.getCategory()
                );
            }
        };

        // Handler for recording a new Expense record
        exp.setOnAction(e -> {
            try {
                c.addExpense(u, Double.parseDouble(amount.getText()), cat.getText());
                out.setText("Expense added");
                refresh.run();
            } catch (NumberFormatException ex) {
                out.setText("Invalid amount");
            }
        });

        // Handler for recording a new Income record
        inc.setOnAction(e -> {
            try {
                c.addIncome(u, Double.parseDouble(amount.getText()), cat.getText());
                out.setText("Income added");
                refresh.run();
            } catch (NumberFormatException ex) {
                out.setText("Invalid amount");
            }
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