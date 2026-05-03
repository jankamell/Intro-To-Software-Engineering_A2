package ui;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import controllers.*;
import models.*;
import ui.UIHelper;

public class ReportView extends BorderPane {

    public ReportView(Stage s, User u) {

        VBox root = UIHelper.root();

        ReportController c = new ReportController();

        Label out = new Label(c.getReport(u));

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