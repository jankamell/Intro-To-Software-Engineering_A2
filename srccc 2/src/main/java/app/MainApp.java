//mvn clean javafx:run

package app;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.LoginView;
import storage.Storage;

/**
 * The main entry point for the Budget Management Application.
 * This class initializes the application storage and sets up the primary 
 * JavaFX stage with the login interface.
 */
public class MainApp extends Application {

    /**
     * Initializes the stage and transitions to the Login screen.
     * This method is called automatically by the JavaFX runtime.
     * @param stage The primary window for this application.
     */
    @Override
    public void start(Stage stage) {
        // Loads existing data from memory or disk
        Storage.load(); 
        
        stage.setTitle("Budget App");
        stage.setScene(new Scene(new LoginView(stage), 600, 450));
        stage.show();
    }

    /**
     * The standard main method that launches the JavaFX application.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        launch();
    }
}