package controllers;

import services.*;
import models.*;

/**
 * Facilitates the addition of financial transactions to a user's account.
 */
public class TransactionController {

    private TransactionService service = new TransactionService();

    /**
     * Records a new expense transaction.
     * SDS Mapping: addTransaction
     * @param u The user who incurred the expense.
     * @param amount The cost of the transaction.
     * @param cat The category assigned to the expense.
     */
    public void addExpense(User u, double amount, String cat) {
        service.addTransaction(u, new Expense(amount, cat));
    }

    /**
     * Records a new income transaction.
     * @param u The user receiving the income.
     * @param amount The value of the income.
     * @param cat The source or category of the income.
     */
    public void addIncome(User u, double amount, String cat) {
        service.addTransaction(u, new Income(amount, cat));
    }
}