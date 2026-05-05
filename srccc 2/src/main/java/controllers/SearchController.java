package controllers;

import services.*;
import models.*;
import java.util.*;

/**
 * Controller responsible for handling search and filter operations for transactions.
 * This class facilitates the retrieval of specific financial records based on user criteria.
 */
public class SearchController {

    private SearchService service = new SearchService();

    /**
     * Filters the user's transaction history based on a specific category.
     * SDS Mapping: filterByCategory
     * @param u The user whose transactions are being searched.
     * @param cat The category string used as the filter criteria (e.g., "Food", "Utilities").
     * @return A list of Transaction objects that match the specified category.
     */
    public List<Transaction> search(User u, String cat) {
        return service.filterByCategory(u, cat);
    }
}