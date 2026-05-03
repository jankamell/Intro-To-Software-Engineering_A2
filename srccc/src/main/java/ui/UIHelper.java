package ui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class UIHelper {

    public static Label title(String text) {
        Label l = new Label(text);
        l.setFont(Font.font(20));

        // 🔹 BLACK TITLE TEXT
        l.setTextFill(Color.BLACK);

        return l;
    }

    public static Button button(String text) {
        Button b = new Button(text);
        b.setPrefWidth(220);

        // 🔹 BLACK TEXT ON BUTTON
        b.setStyle("-fx-text-fill: black;");

        return b;
    }

    public static VBox card() {
        VBox box = new VBox(10);
        box.setPadding(new Insets(15));

        // 🔹 LIGHT CARD BACKGROUND
        box.setStyle("-fx-background-color: #f5f5f5; -fx-background-radius: 10;");

        return box;
    }

    public static VBox root() {
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));

        // 🔹 LIGHT BACKGROUND + FORCE TEXT BLACK
        root.setStyle("-fx-background-color: white; -fx-text-fill: black;");

        return root;
    }
}