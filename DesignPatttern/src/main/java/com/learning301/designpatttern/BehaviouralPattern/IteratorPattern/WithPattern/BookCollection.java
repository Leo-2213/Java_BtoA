package com.learning301.designpatttern.BehaviouralPattern.IteratorPattern.WithPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * BookCollection - Aggregate/Collection with Iterator Pattern
 * 
 * Benefits of this approach:
 * 1. ENCAPSULATION - Internal data structure is hidden
 * 2. ABSTRACTION - Client uses iterator interface, not specific collection
 * 3. FLEXIBILITY - Can change internal storage without affecting clients
 * 4. SECURITY - No direct access to internal collection
 * 5. MULTIPLE ITERATIONS - Can create multiple iterators simultaneously
 * 6. UNIFORM INTERFACE - Same iteration pattern for different collections
 */
public class BookCollection {
    // Internal storage - completely hidden from clients
    private List<Book> books = new ArrayList<>();

    /**
     * Add a book to the collection
     * Controlled access to modify collection
     */
    public void addBook(Book book){
        books.add(book);
    }

    /**
     * Create an iterator for traversing the collection
     * This is the key method that provides Iterator Pattern benefits
     * 
     * @return Iterator for Book objects
     */
    public Iterator<Book> createIterator() {
        return new BookIterator(this.books);
    }

    /**
     * Concrete Iterator - BookIterator
     * 
     * Inner class that implements the Iterator interface
     * Encapsulates the traversal logic for this specific collection
     * Maintains iteration state (current position)
     * 
     * Benefits:
     * - Knows how to traverse the specific data structure
     * - Maintains iteration state independently
     * - Can be customized for different traversal patterns
     * - Multiple iterators can exist simultaneously
     */
    private static class BookIterator implements Iterator<Book> {
        private final List<Book> books;
        private int currentIndex = 0;

        /**
         * Constructor - receives reference to collection data
         * Note: In production, consider defensive copying for immutability
         */
        public BookIterator(List<Book> books) {
            this.books = books;
        }

        /**
         * Check if more elements exist for iteration
         * @return true if more elements available
         */
        @Override
        public boolean hasNext() {
            return currentIndex < books.size();
        }

        /**
         * Get next element and advance iterator position
         * @return next Book in the collection
         */
        @Override
        public Book next() {
            if (!hasNext()) {
                throw new RuntimeException("No more elements to iterate");
            }
            return books.get(currentIndex++);
        }
    }
}
