package ui;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import models.*;
import ui.UIHelper;

public class DashboardView extends BorderPane {

    public DashboardView(Stage s, User u) {

        VBox root = UIHelper.root();

        Button t = UIHelper.button("Transactions");
        Button b = UIHelper.button("Budget");
        Button se = UIHelper.button("Search");
        Button r = UIHelper.button("Report");
        Button g = UIHelper.button("Goals");
        Button st = UIHelper.button("Settings");

        t.setOnAction(e -> s.setScene(new Scene(new TransactionView(s, u), 600, 450)));
        b.setOnAction(e -> s.setScene(new Scene(new BudgetView(s, u), 600, 450)));
        se.setOnAction(e -> s.setScene(new Scene(new SearchView(s, u), 600, 450)));
        r.setOnAction(e -> s.setScene(new Scene(new ReportView(s, u), 600, 450)));
        g.setOnAction(e -> s.setScene(new Scene(new GoalView(s, u), 600, 450)));
        st.setOnAction(e -> s.setScene(new Scene(new SettingsView(s, u), 600, 450)));

        VBox card = UIHelper.card();
        card.getChildren().addAll(UIHelper.title("Dashboard"), t, b, se, r, g, st);

        root.getChildren().add(card);
        setCenter(root);
    }
}