package ui;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import models.User;
import services.CurrencyService;

/**
 * Graphical interface for application settings and utility tools.
 * Currently provides a currency conversion tool to assist users with 
 * international financial transactions.
 * * SDS Mapping: UC-08 Currency Conversion Utility
 */
public class SettingsView extends BorderPane {

    /** The currently authenticated user session */
    private User user;

    /**
     * Constructs the Settings/Utility view.
     * Initializes currency input fields and binds conversion logic to the UI.
     * * @param s The primary stage for scene switching
     * @param u The user session to maintain context during navigation
     */
    public SettingsView(Stage s, User u) {

        this.user = u;

        VBox root = UIHelper.root();

        // UI components for currency conversion inputs
        TextField oldCurrency = new TextField();
        oldCurrency.setPromptText("From Currency (USD)");

        TextField amountField = new TextField();
        amountField.setPromptText("Amount");

        TextField newCurrency = new TextField();
        newCurrency.setPromptText("To Currency (EGP)");

        Label result = new Label();

        CurrencyService cs = new CurrencyService();

        Button convertBtn = UIHelper.button("Convert");
        Button backBtn = UIHelper.button("Back");

        /**
         * Action handler for the conversion process.
         * Validates input, normalizes currency codes to uppercase, 
         * and invokes the CurrencyService to calculate results.
         */
        convertBtn.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());

                String from = oldCurrency.getText().toUpperCase().trim();
                String to = newCurrency.getText().toUpperCase().trim();

                if (from.isEmpty() || to.isEmpty()) {
                    result.setText("Enter both currencies");
                    return;
                }

                double converted = cs.convert(amount, from, to);

                result.setText(
                        amount + " " + from +
                                " → " + converted + " " + to
                );

            } catch (NumberFormatException ex) {
                result.setText("Invalid amount");
            }
        });

        // Navigation handler to return to the main dashboard
        backBtn.setOnAction(e ->
                s.setScene(new Scene(new DashboardView(s, user), 600, 450))
        );

        VBox card = UIHelper.card();
        card.getChildren().addAll(
                UIHelper.title("Currency Converter"),
                oldCurrency,
                amountField,
                newCurrency,
                convertBtn,
                result,
                backBtn
        );

        root.getChildren().add(card);
        setCenter(root);
    }
}