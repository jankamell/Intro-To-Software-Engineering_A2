package ui;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import controllers.*;
import models.*;
import ui.UIHelper;

/**
 * Graphical interface for searching and filtering transaction history.
 * Users can input a category name to find related transactions, with the
 * logic being processed by the SearchController.
 * * SDS Mapping: UC-05 Search Transactions UI
 */
public class SearchView extends BorderPane {

    /**
     * Constructs the Search view.
     * Initializes the category input field and search action handlers.
     * * @param s The primary stage for scene switching
     * @param u The currently authenticated user whose transactions are being searched
     */
    public SearchView(Stage s, User u) {

        VBox root = UIHelper.root();

        TextField cat = new TextField();
        cat.setPromptText("Category");

        Label out = new Label();

        SearchController c = new SearchController();

        Button search = UIHelper.button("Search");
        Button back = UIHelper.button("Back");

        /**
         * Action for the search button.
         * Retrieves the list of matching transactions via the SearchController 
         * and updates the results count in the UI.
         */
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