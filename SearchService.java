package services;

import java.util.*;
import models.*;

public class SearchService {

    public List<Transaction> filterByCategory(User u, String cat) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : u.getTransactions()) {
            if (t.getCategory().equalsIgnoreCase(cat))
                result.add(t);
        }
        return result;
    }
}