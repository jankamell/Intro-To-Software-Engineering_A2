package ui;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import controllers.*;
import models.*;
import ui.UIHelper;

/**
 * The initial landing page of the application for user authentication.
 * Provides the interface for existing users to sign in or new users to register.
 * This class coordinates with the AuthController to validate credentials.
 * * * SDS Mapping: UC-01 User Login and UC-02 User Registration */
public class LoginView extends BorderPane {

    /**
     * Constructs the Login view.
     * Sets up input fields for credentials and configures authentication actions.
     * * * @param stage The primary application stage used for navigation after login
     */
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

        /**
         * Action for the login button.
         * Attempts to authenticate via AuthController. If successful, transitions 
         * the stage to the DashboardView; otherwise, displays an error message.
         */
        login.setOnAction(e -> {
            User u = c.login(email.getText(), pass.getText());
            if (u != null)
                stage.setScene(new Scene(new DashboardView(stage, u), 600, 450));
            else msg.setText("Invalid login");
        });

        /**
         * Action for the registration button.
         * Passes the user's input to the AuthController to create a new account record.
         */
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