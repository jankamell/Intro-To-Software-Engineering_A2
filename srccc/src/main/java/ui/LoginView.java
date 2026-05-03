package ui;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import controllers.*;
import models.*;
import ui.UIHelper;

public class LoginView extends BorderPane {

    public LoginView(Stage stage) {

        VBox root = UIHelper.root();

        TextField email = new TextField();
        email.setPromptText("Email");

        PasswordField pass = new PasswordField();
        pass.setPromptText("Password");

        Label msg = new Label();


        AuthController c = new AuthController();

        Button login = UIHelper.button("Login");
        Button reg = UIHelper.button("Register");

        login.setOnAction(e -> {
            User u = c.login(email.getText(), pass.getText());
            if (u != null)
                stage.setScene(new Scene(new DashboardView(stage, u), 600, 450));
            else msg.setText("Invalid login");
        });

        reg.setOnAction(e -> {
            c.register(email.getText(), pass.getText());
            msg.setText("Registered!");
        });

        VBox card = UIHelper.card();
        card.getChildren().addAll(UIHelper.title("Login"), email, pass, login, reg, msg);

        root.getChildren().add(card);
        setCenter(root);
    }
}