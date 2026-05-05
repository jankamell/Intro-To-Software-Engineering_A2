package services;

/**
 * Utility service for handling currency conversions within the application.
 * This service allows users to view their financial data in different currencies
 * using fixed exchange rates (e.g., USD, EGP, EUR).
 */
public class CurrencyService {

    /**
     * Converts a monetary amount from one currency to another based on fixed rates.
     * Supported currencies: USD, EGP, EUR.
     * * @param amount The value to be converted
     * @param from The source currency code (e.g., "USD")
     * @param to The target currency code (e.g., "EGP")
     * @return double The converted amount; returns original amount if codes match or are unknown.
     */
    public double convert(double amount, String from, String to) {

        if (from.equals(to)) return amount;

        // simple fixed rates
        switch (from + "_" + to) {
            case "USD_EGP": return amount * 48;
            case "EGP_USD": return amount / 48;

            case "USD_EUR": return amount * 0.92;
            case "EUR_USD": return amount / 0.92;

            case "EGP_EUR": return amount * 0.019;
            case "EUR_EGP": return amount / 0.019;
        }

        return amount;
    }
}