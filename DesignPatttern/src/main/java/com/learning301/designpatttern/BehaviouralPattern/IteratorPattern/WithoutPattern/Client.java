package com.learning301.designpatttern.BehaviouralPattern.IteratorPattern.WithoutPattern;

/**
 * Client - WITHOUT Iterator Pattern
 * 
 * Problems demonstrated:
 * 1. TIGHT COUPLING - Client depends on specific collection type (List)
 * 2. ENCAPSULATION VIOLATION - Accesses internal data structure directly
 * 3. SECURITY RISK - Can accidentally modify collection during iteration
 * 4. NO ABSTRACTION - Must know collection implementation details
 * 5. INFLEXIBILITY - Cannot easily change collection type
 * 6. TRAVERSAL COUPLING - Client code tied to specific traversal method
 */
public class Client {
    public static void main(String[] args) {
        // Create collection
        BookCollection bookCollection = new BookCollection();

        // Add books to collection
        bookCollection.addBook(new Book("Book 1"));
        bookCollection.addBook(new Book("Book 2"));
        bookCollection.addBook(new Book("Book 3"));
        bookCollection.addBook(new Book("Book 4"));
        bookCollection.addBook(new Book("Book 5"));

        // PROBLEMATIC ITERATION:
        // 1. Client must know collection returns a List
        // 2. Directly accesses internal data structure
        // 3. Could accidentally modify: bookCollection.getBooks().clear()
        // 4. Tightly coupled to List interface
        // 5. If BookCollection changes internal storage (e.g., to Array),
        //    this code breaks
        for (Book book : bookCollection.getBooks()) {
            System.out.println(book);
        }
        
        // Demonstrates security problem:
        // bookCollection.getBooks().clear(); // This would work! BAD!
        // System.out.println("Books after clear: " + bookCollection.getBooks().size());
        
        // What if we want different traversal orders?
        // - Reverse order
        // - Filtered iteration
        // - Lazy loading
        // Current approach doesn't support these easily
    }
}
