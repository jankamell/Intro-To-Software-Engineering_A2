package ui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * A utility class providing factory methods for consistent UI components.
 * This class implements the Utility Pattern to centralize styling and 
 * layout configurations, ensuring a uniform look and feel across the application.
 */
public class UIHelper {

    /**
     * Creates a styled title label with a standard font size and color.
     * @param text The text to display in the title
     * @return Label A configured JavaFX Label object
     */
    public static Label title(String text) {
        Label l = new Label(text);
        l.setFont(Font.font(20));

        // 🔹 BLACK TITLE TEXT
        l.setTextFill(Color.BLACK);

        return l;
    }

    /**
     * Creates a button with standardized dimensions and text styling.
     * @param text The label for the button
     * @return Button A configured JavaFX Button object
     */
    public static Button button(String text) {
        Button b = new Button(text);
        b.setPrefWidth(220);

        // 🔹 BLACK TEXT ON BUTTON
        b.setStyle("-fx-text-fill: black;");

        return b;
    }

    /**
     * Creates a container designed to group related UI elements visually.
     * Uses a light background and rounded corners to simulate a "card" interface.
     * @return VBox A configured VBox with padding and background styling
     */
    public static VBox card() {
        VBox box = new VBox(10);
        box.setPadding(new Insets(15));

        // 🔹 LIGHT CARD BACKGROUND
        box.setStyle("-fx-background-color: #f5f5f5; -fx-background-radius: 10;");

        return box;
    }

    /**
     * Creates the primary layout container for view screens.
     * Provides standard padding and base background coloring for all application views.
     * @return VBox A configured VBox acting as a root container
     */
    public static VBox root() {
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));

        // 🔹 LIGHT BACKGROUND + FORCE TEXT BLACK
        root.setStyle("-fx-background-color: white; -fx-text-fill: black;");

        return root;
    }
}