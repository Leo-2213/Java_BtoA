package com.learning301.designpatttern.BehaviouralPattern.IteratorPattern.WithoutPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * BookCollection - WITHOUT Iterator Pattern
 * 
 * Problems with this approach:
 * 1. ENCAPSULATION VIOLATION - Exposes internal data structure
 * 2. TIGHT COUPLING - Client depends on specific collection type (List)
 * 3. NO ABSTRACTION - Client must know collection implementation details
 * 4. SECURITY RISK - Client can modify internal collection directly
 * 5. INFLEXIBILITY - Hard to change internal storage without breaking clients
 */
public class BookCollection {

    // Internal storage - should be hidden from clients
    private List<Book> books = new ArrayList<>();

    /**
     * Add a book to the collection
     * This method is fine - provides controlled access
     */
    public void addBook(Book book){
        books.add(book);
    }

    /**
     * PROBLEM METHOD - Exposes internal data structure
     * 
     * Issues:
     * - Returns direct reference to internal List
     * - Client can modify collection externally: getBooks().clear()
     * - Violates encapsulation principle
     * - Couples client to ArrayList implementation
     * - Cannot change internal storage without breaking clients
     * - No control over how collection is traversed
     */
    public List<Book> getBooks() {
       return books; // Direct exposure - BAD!
    }
}
