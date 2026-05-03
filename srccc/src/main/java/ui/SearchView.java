package ui;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import controllers.*;
import models.*;
import ui.UIHelper;

public class SearchView extends BorderPane {

    public SearchView(Stage s, User u) {

        VBox root = UIHelper.root();

        TextField cat = new TextField();
        cat.setPromptText("Category");

        Label out = new Label();

        SearchController c = new SearchController();

        Button search = UIHelper.button("Search");
        Button back = UIHelper.button("Back");

        search.setOnAction(e -> {
            var res = c.search(u, cat.getText());
            out.setText("Found: " + res.size());
        });

        back.setOnAction(e ->
                s.setScene(new Scene(new DashboardView(s, u), 600, 450))
        );

        VBox card = UIHelper.card();
        card.getChildren().addAll(UIHelper.title("Search"), cat, search, back, out);

        root.getChildren().add(card);
        setCenter(root);
    }
}