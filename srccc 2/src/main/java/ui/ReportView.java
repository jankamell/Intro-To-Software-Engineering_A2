package ui;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import controllers.*;
import models.*;
import ui.UIHelper;

/**
 * Graphical interface for displaying financial summaries and budget health.
 * This view retrieves a formatted string from the ReportController and presents 
 * it to the user to provide an overview of income, expenses, and savings.
 * * SDS Mapping: UC-06 Generate Financial Report UI
 */
public class ReportView extends BorderPane {

    /**
     * Constructs the Report view.
     * Fetches the generated report data and initializes the display components.
     * * @param s The primary stage for scene switching
     * @param u The currently authenticated user whose data is being reported
     */
    public ReportView(Stage s, User u) {

        VBox root = UIHelper.root();

        ReportController c = new ReportController();

        // Displays the formatted text report retrieved from the controller
        Label out = new Label(c.getReport(u));
        out.setTextFill(javafx.scene.paint.Color.BLACK);
        out.setStyle("-fx-font-size: 14px;");

        Button back = UIHelper.button("Back");

        back.setOnAction(e ->
                s.setScene(new Scene(new DashboardView(s, u), 600, 450))
        );

        VBox card = UIHelper.card();
        card.getChildren().addAll(UIHelper.title("Report"), out, back);

        root.getChildren().add(card);
        setCenter(root);
    }
}