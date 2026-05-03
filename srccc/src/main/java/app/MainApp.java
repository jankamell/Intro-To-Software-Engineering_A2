package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.LoginView;
import storage.Storage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        Storage.load();
        stage.setTitle("Budget App");
        stage.setScene(new Scene(new LoginView(stage), 600, 450));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}