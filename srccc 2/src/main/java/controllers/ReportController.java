package controllers;

import services.*;
import models.*;

/**
 * Controller responsible for generating financial reports for users.
 * This class facilitates the creation of summary data based on user transactions and budgets.
 */
public class ReportController {

    private ReportService service = new ReportService();

    /**
     * Generates a comprehensive financial report for a specific user.
     * SDS Mapping: generateReport
     * @param u The user for whom the report is being generated.
     * @return A string containing the formatted report data.
     */
    public String getReport(User u) {
        return service.generateReport(u);
    }
}