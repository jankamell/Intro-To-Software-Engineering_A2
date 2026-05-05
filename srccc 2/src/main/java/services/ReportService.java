package services;

import models.*;

/**
 * Service class responsible for aggregating financial data into readable summaries.
 * It calculates totals for income, expenses, and budget utilization to provide
 * a comprehensive financial health report for the user.
 */
public class ReportService {

    /**
     * Generates a formatted text report summarizing the user's financial status.
     * The report includes total income, total expenses, net balance, 
     * and detailed budget tracking (limit, spent, remaining, and status).
     * * @param u The user for whom the report is being generated
     * @return String A multi-line formatted report string
     */
    public String generateReport(User u) {

        double income = 0;
        double expense = 0;

        for (Transaction t : u.getTransactions()) {
            if (t instanceof Income)
                income += t.getAmount();

            if (t instanceof Expense)
                expense += t.getAmount();
        }

        double balance = income - expense;

        // 🔹 BUDGET DATA
        double budget = u.getBudget();
        double spent = expense;
        double remaining = budget - spent;

        double percent = 0;
        if (budget > 0) {
            percent = (spent / budget) * 100;
        }

        String status;
        if (percent >= 100) {
            status = " Budget exceeded!";
        } else if (percent >= 80) {
            status = " Near budget!";
        } else {
            status = " Budget OK";
        }

        return "=== REPORT ===" +
                "\nIncome: " + income +
                "\nExpense: " + expense +
                "\nBalance: " + balance +

                "\n\n--- Budget ---" +
                "\nBudget: " + budget +
                "\nSpent: " + spent +
                "\nRemaining: " + remaining +
                "\nUsage: " + String.format("%.1f", percent) + "%" +
                "\n" + status;
    }
}