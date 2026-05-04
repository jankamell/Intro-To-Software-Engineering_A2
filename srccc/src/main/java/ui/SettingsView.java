package ui;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import models.User;
import services.CurrencyService;

public class SettingsView extends BorderPane {

    private User user;

    public SettingsView(Stage s, User u) {

        this.user = u;

        VBox root = UIHelper.root();


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