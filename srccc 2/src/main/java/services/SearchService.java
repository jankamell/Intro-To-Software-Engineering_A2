package services;

import java.util.*;
import models.*;

/**
 * Service class that provides search and filtering capabilities for transaction history.
 * This class allows users to query their financial records based on specific criteria
 * such as transaction categories.
 */
public class SearchService {

    /**
     * Filters a user's transaction list to find all entries matching a specific category.
     * The search is case-insensitive (e.g., "Food" will match "food").
     * * @param u The user whose transactions are being searched
     * @param cat The category string to filter by (e.g., "Shopping", "Bills")
* @return {@code List<Transaction>} A list of transactions that match the given category     */
    public List<Transaction> filterByCategory(User u, String cat) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : u.getTransactions()) {
            if (t.getCategory().equalsIgnoreCase(cat))
                result.add(t);
        }
        return result;
    }
}