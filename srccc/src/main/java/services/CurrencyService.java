package services;

public class CurrencyService {

    public double convert(double amount, String from, String to) {

        if (from.equals(to)) return amount;


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