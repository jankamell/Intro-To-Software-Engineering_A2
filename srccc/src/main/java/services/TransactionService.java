package services;

import models.*;

public class TransactionService {

    private CurrencyService currencyService = new CurrencyService();


    public void addTransaction(User user, Transaction t) {


        String baseCurrency = "USD";
        String userCurrency = user.getCurrency();

        double convertedAmount = currencyService.convert(
                t.getAmount(),
                baseCurrency,
                userCurrency
        );


        t.setAmount(convertedAmount);

        user.getTransactions().add(t);
    }


    public java.util.List<Transaction> fetchTransactions(User user) {
        return user.getTransactions();
    }
}