package controllers;

import services.*;
import models.*;
import java.util.*;

public class SearchController {

    private SearchService service = new SearchService();

    // SDS: filterByCategory
    public List<Transaction> search(User u, String cat) {
        return service.filterByCategory(u, cat);
    }
}