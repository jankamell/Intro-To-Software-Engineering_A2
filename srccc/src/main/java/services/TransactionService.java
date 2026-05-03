package services;

import models.*;

public class TransactionService {

    private CurrencyService currencyService = new CurrencyService();

    // 🔹 ADD TRANSACTION WITH CURRENCY CONVERSION
    public void addTransaction(User user, Transaction t) {

        // assume base currency is USD
        String baseCurrency = "USD";
        String userCurrency = user.getCurrency();

        double convertedAmount = currencyService.convert(
                t.getAmount(),
                baseCurrency,
                userCurrency
        );

        // 🔹 update transaction amount after conversion
        t.setAmount(convertedAmount);

        user.getTransactions().add(t);
    }

    // 🔹 FETCH TRANSACTIONS (SDS)
    public java.util.List<Transaction> fetchTransactions(User user) {
        return user.getTransactions();
    }
}