package controllers;

import services.*;
import models.*;

public class ReportController {

    private ReportService service = new ReportService();

    // SDS: generateReport
    public String getReport(User u) {
        return service.generateReport(u);
    }
}