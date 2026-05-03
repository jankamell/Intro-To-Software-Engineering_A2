package services;

import models.*;

public class ReportService {

    public String generateReport(User u) {

        double income = 0;
        double expense = 0;

        for (Transaction t : u.getTransactions()) {
            if (t instanceof Income) income += t.getAmount();
            if (t instanceof Expense) expense += t.getAmount();
        }

        return "Income: " + income +
                "\nExpense: " + expense +
                "\nBalance: " + (income - expense);
    }

    public void groupTransactionsByDate(User u) {}
}