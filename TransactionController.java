package controllers;

import services.*;
import models.*;

public class TransactionController {

    private TransactionService service = new TransactionService();

    // SDS: addTransaction
    public void addExpense(User u, double amount, String cat) {
        service.addTransaction(u, new Expense(amount, cat));
    }

    public void addIncome(User u, double amount, String cat) {
        service.addTransaction(u, new Income(amount, cat));
    }
}